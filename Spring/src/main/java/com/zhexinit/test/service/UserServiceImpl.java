package com.zhexinit.test.service;

import com.zhexinit.spring.Component;

/**
 * @author: Lin
 * @Date: 2022/7/9 12:36
 */
@Component("userService")
public class UserServiceImpl implements UserService{


    @Override
    public void test() {
        System.out.println("test");
    }
}
