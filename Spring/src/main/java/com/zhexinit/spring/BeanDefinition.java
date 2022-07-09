package com.zhexinit.spring;

/**
 * @author: Lin
 * @Date: 2022/7/9 13:17
 */
public class BeanDefinition {

    private Class clazz;

    private String scope;

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
