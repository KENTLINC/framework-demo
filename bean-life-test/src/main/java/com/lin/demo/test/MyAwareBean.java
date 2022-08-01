package com.lin.demo.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * @author: Lin
 * @Date: 2022/8/1 10:35
 */
public class MyAwareBean implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware {
    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("setBeanClassLoader");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("setBeanName");
    }
}
