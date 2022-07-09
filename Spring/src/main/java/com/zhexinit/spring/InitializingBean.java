package com.zhexinit.spring;

/**
 * @author: Lin
 * @Date: 2022/7/9 13:55
 */
public interface InitializingBean {

    void afterPropertiesSet() throws Exception;

}
