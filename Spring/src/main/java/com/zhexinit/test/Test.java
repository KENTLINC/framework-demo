package com.zhexinit.test;

import com.zhexinit.spring.SpringDemoApplicationContext;
import com.zhexinit.test.service.RoleService;
import com.zhexinit.test.service.UserService;

/**
 * @author: Lin
 * @Date: 2022/7/9 12:33
 */
public class Test {
    public static void main(String[] args) {
        SpringDemoApplicationContext applicationContext = new SpringDemoApplicationContext(AppConfig.class);

        RoleService roleService = (RoleService) applicationContext.getBean("roleService");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.test();


    }
}
