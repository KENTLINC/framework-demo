package com.lin.demo.test;

import com.lin.demo.annotation.MyAutowired;

/**
 * @author JC.Lin
 * @description: TODO
 * @date 2022/7/31 17:46 星期日
 */
public class StudentSecond {
    private String name;
    private Integer age;


    public StudentSecond() {
        System.out.println("执行无参数构造函数");
    }

    @MyAutowired
    public StudentSecond(String name ) {
        this.name = "lin";
        System.out.println("执行单个参数构造函数");
    }
    public StudentSecond(String name, Integer age) {
        this.name = "lin";
        this.age = 123;
        System.out.println("执行所有参数构造函数");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "BeforeInstantiationDemo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
