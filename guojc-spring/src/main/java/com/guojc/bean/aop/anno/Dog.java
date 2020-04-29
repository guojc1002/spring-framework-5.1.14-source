package com.guojc.bean.aop.anno;

public class Dog implements Animal {
    public void sayHello() {
        System.out.println("--被增强的方法");
    }
}
