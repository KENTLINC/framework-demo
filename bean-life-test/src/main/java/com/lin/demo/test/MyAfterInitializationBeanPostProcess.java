package com.lin.demo.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;


/**
 * @author: Lin
 * @Date: 2022/8/1 14:54
 */
public class MyAfterInitializationBeanPostProcess implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyAfterInitializationBeanPostProcess.postProcessAfterInitialization");
        return bean;
    }
}
