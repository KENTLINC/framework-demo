package com.lin.demo.test;

import com.lin.demo.annotation.MyAutowired;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;

import java.lang.reflect.Constructor;
import java.util.Arrays;


/**
 * @author JC.Lin
 * @description: TODO
 * @date 2022/7/31 18:19 星期日
 */
public class MyInstantiationBeanPostProcess extends AutowiredAnnotationBeanPostProcessor {
    @Override
    public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName) throws BeanCreationException {
        System.out.println(beanClass);
        System.out.println("determineCandidateConstructors()");
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();

        Constructor[] constructors = Arrays.stream(declaredConstructors).
                filter(constructor -> constructor.isAnnotationPresent(MyAutowired.class)).toArray(Constructor[]::new);
        return constructors.length != 0 ? constructors : null;
    }
}
