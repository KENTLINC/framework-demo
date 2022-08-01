package com.lin.demo.test;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;



/**
 * @author JC.Lin
 * @description: TODO
 * @date 2022/7/31 17:48 星期日
 */
public class BeforeInstantiationBeanPostProcess implements InstantiationAwareBeanPostProcessor {
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInstantiation()");
        if (beanClass == Student.class) {
            Student car = new Student();
            car.setName("Lin");
            return car;
        }
        return null;
    }
}
