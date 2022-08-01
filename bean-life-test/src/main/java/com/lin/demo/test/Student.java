package com.lin.demo.test;

import com.lin.demo.annotation.MyAutowired;

import javax.annotation.PostConstruct;

/**
 * @author JC.Lin
 * @description: TODO
 * @date 2022/7/31 17:46 星期日
 */
public class Student {
    private String name;
    private Integer age;

    @PostConstruct
    public void init() {
        System.out.println("Student.init");
        this.name = "PostConstruct";
    }

    public Student() {
        System.out.println("执行无参数构造函数");
    }

    @MyAutowired
    public Student(String name ) {
        this.name = name;
        System.out.println("执行单个参数构造函数");
    }
    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
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
