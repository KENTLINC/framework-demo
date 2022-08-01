package com.lin.demo;


import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author JC.Lin
 * @description: TODO
 * @date 2022/7/30 21:45 星期六
 */
public class DemoApplication {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans-config.xml");
//        Object student = context.getBean("student");
//        Object student1 = context.getBean("student1");
//        System.out.println(student);
//        System.out.println(student1);

//        Target target = (Target) context.getBean("target");
//        target.method();

    }
}
