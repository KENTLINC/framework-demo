package com.zhexinit.spring;

import com.zhexinit.test.service.InitializationBeanPostProcessor;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;

/**
 * @author: Lin
 * @Date: 2022/7/9 12:20
 */
public class SpringDemoApplicationContext {

    private Class configClass;
    /**
     * 单例池
     */
    private ConcurrentHashMap<String, Object> singletonObjets = new ConcurrentHashMap<>();
    /**
     * 储存beanDefinition
     */
    private ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    private List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    public SpringDemoApplicationContext(Class configClass) {
        this.configClass = configClass;
        // 解析配置类-> 扫描路径->BeanDefinition
        scan(configClass);

        for (Map.Entry<String, BeanDefinition> entry : beanDefinitionMap.entrySet()) {
            String beanName = entry.getKey();
            BeanDefinition beanDefinition = entry.getValue();
            if (beanDefinition.getScope().equals("singleton")) {
                Object bean = createBean(beanDefinition,beanName);
                singletonObjets.put(beanName, bean);
            }
        }

    }

    public Object createBean(BeanDefinition beanDefinition,String beanName) {
        Class clazz = beanDefinition.getClazz();

        try {
            // 实例化
            Object ins = clazz.getDeclaredConstructor().newInstance();

            // 装配属性
            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(Autowired.class)) {
                    Object bean = getBean(field.getName());
                    field.setAccessible(true);
                    field.set(ins,bean);
                }
            }
            // aware
            if (ins instanceof BeanNameAware) {
                ((BeanNameAware)ins).setBeanName(beanName);
            }

            for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
                if (beanPostProcessor instanceof InitializationBeanPostProcessor) {
                    Object o = beanPostProcessor.postProcessBeforeInitialization(ins, beanName);
                }
            }

            // 初始化
            if (ins instanceof InitializingBean) {
                ((InitializingBean)ins).afterPropertiesSet();
            }

            for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
                if (beanPostProcessor instanceof InitializationBeanPostProcessor) {
                    Object o = beanPostProcessor.postProcessAfterInitialization(ins, beanName);
                }
            }


            return ins;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    private void scan(Class configClass) {
        ComponentScan declaredAnnotation = (ComponentScan) configClass.getDeclaredAnnotation(ComponentScan.class);
        String path = declaredAnnotation.value();

        // 获取类加载器
        ClassLoader classLoader = SpringDemoApplicationContext.class.getClassLoader();
        String basePah = path.replaceAll("\\.", "/");
        String[] split = path.split("\\.");
        URL resource = classLoader.getResource(basePah);
        assert resource != null;
        parseFile(resource.getFile(),classLoader,split[0]);
    }

    public void parseFile(String path, ClassLoader classLoader,String firstDir) {
        File file = new File(path);

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            assert files != null;

            for (File f : files) {
                String fileName = f.getAbsolutePath();
                if (!fileName.endsWith(".class")) {
                    parseFile(fileName, classLoader,firstDir);
                }
                try{
                    String className = fileName.substring(fileName.indexOf(firstDir), fileName.indexOf(".class"));
                    className = className.replace(File.separator, ".");
                    createBeanDefinition(className,classLoader);
                } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public void createBeanDefinition(String className, ClassLoader classLoader) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> clazz = classLoader.loadClass(className);
        if (clazz.isAnnotationPresent(Component.class)) {

            if (BeanPostProcessor.class.isAssignableFrom(clazz)) {
                beanPostProcessors.add((BeanPostProcessor) clazz.getDeclaredConstructor().newInstance());

            }
            //解析类， 判断当前的bean 是一个单例bean 还是一个prototype bean
            Component component = clazz.getDeclaredAnnotation(Component.class);
            String beanName = component.value();

            BeanDefinition beanDefinition = new BeanDefinition();
            beanDefinition.setClazz(clazz);
            if (clazz.isAnnotationPresent(Scope.class)) {
                Scope scopeAnnotation = clazz.getDeclaredAnnotation(Scope.class);
                beanDefinition.setScope(scopeAnnotation.value());
            } else {
                beanDefinition.setScope("singleton");
            }
            this.beanDefinitionMap.put(beanName, beanDefinition);}
    }

    public Object getBean(String beanName) {
        if (beanDefinitionMap.containsKey(beanName)) {
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            if (beanDefinition.getScope().equals("singleton")) {
                return singletonObjets.get(beanName);
            }else{
                return createBean(beanDefinition,beanName);

            }

        }else{}
        throw new NullPointerException();
    }

}
