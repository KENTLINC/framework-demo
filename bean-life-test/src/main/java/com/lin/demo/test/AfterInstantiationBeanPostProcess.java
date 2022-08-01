package com.lin.demo.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

/**
 * @author: Lin
 * @Date: 2022/8/1 9:55
 */
public class AfterInstantiationBeanPostProcess implements InstantiationAwareBeanPostProcessor {
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if ("student1".endsWith(beanName)) {
            return false;
        }
        return true;
    }
}
