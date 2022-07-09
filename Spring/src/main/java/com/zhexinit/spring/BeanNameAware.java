package com.zhexinit.spring;

/**
 * @author: Lin
 * @Date: 2022/7/9 13:49
 */
public interface BeanNameAware {

    /**
     * 设置bean 的名称
     * @param name
     */
    void setBeanName(String name);
}
