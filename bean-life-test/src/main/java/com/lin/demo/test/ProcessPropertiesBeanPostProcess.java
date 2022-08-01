package com.lin.demo.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

/**
 * @author: Lin
 * @Date: 2022/8/1 9:56
 */
public class ProcessPropertiesBeanPostProcess implements InstantiationAwareBeanPostProcessor {
    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        if ("student".equals(beanName)) {
            if (pvs instanceof MutablePropertyValues) {
                MutablePropertyValues mpvs = (MutablePropertyValues) pvs;
                //将姓名设置为：postProcessPropertiesTest
                mpvs.add("name", "postProcessPropertiesTest");
                //将年龄属性的值修改为18
                mpvs.add("age", 18);
            }
        }
        return pvs;
    }
}
