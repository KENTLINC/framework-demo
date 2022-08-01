package com.lin.demo.test;

import org.springframework.beans.factory.SmartInitializingSingleton;

/**
 * @author: Lin
 * @Date: 2022/8/1 16:41
 */
public class MyAfterSingletonsInstantiated implements SmartInitializingSingleton {
    @Override
    public void afterSingletonsInstantiated() {
        System.out.println("最后执行 MyAfterSingletonsInstantiated.afterSingletonsInstantiated");
    }
}
