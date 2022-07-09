package com.zhexinit.test.service;

import com.zhexinit.spring.BeanPostProcessor;
import com.zhexinit.spring.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: Lin
 * @Date: 2022/7/9 14:03
 */
@Component("initializationBeanPostProcessor")
public class InitializationBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("postProcessBeforeInitialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("postProcessAfterInitialization");
        if (beanName.equals("userService")) {
            Object proxyInstance = Proxy.newProxyInstance(InitializationBeanPostProcessor.class.getClassLoader(), bean.getClass().getInterfaces(), (proxy, method, args) -> {
                System.out.println("proxy");
                return method.invoke(bean, args);
            });
            return proxyInstance;
        }
        return bean;

    }

}
