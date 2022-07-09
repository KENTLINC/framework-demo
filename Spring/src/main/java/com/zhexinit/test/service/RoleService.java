package com.zhexinit.test.service;

import com.zhexinit.spring.Autowired;
import com.zhexinit.spring.BeanNameAware;
import com.zhexinit.spring.Component;
import com.zhexinit.spring.InitializingBean;

/**
 * @author: Lin
 * @Date: 2022/7/9 13:39
 */
@Component("roleService")
public class RoleService implements BeanNameAware, InitializingBean {

    @Autowired
    private UserService userService;

    private String beanName;

    @Override
    public void setBeanName(String name) {
        this.beanName = beanName;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    public void test() {
        System.out.println("test");
    }
}
