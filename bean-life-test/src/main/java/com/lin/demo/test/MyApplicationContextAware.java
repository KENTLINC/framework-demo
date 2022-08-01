package com.lin.demo.test;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


/**
 * @author: Lin
 * @Date: 2022/8/1 11:51
 */
public class MyApplicationContextAware implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("applicationContext");
        System.out.println(applicationContext);
    }
}
