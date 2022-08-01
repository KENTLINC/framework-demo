package com.lin.demo.test;

import org.springframework.beans.factory.InitializingBean;

/**
 * @author: Lin
 * @Date: 2022/8/1 14:11
 */
public class StudentInitializingBean implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    public void init() {
        System.out.println("StudentInitializingBean.init");
    }
}
