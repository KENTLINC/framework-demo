package com.zhexinit.spring;

/**
 * @author: Lin
 * @Date: 2022/7/9 14:02
 */
public interface BeanPostProcessor {

    /**
     * 初始化前
     * @param bean
     * @param beanName
     * @return
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) ;


    /**
     * 初始化后
     * @param bean
     * @param beanName
     * @return
     */
    Object postProcessAfterInitialization(Object bean, String beanName) ;

}
