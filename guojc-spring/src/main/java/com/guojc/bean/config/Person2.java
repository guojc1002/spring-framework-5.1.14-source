package com.guojc.bean.config;

import org.springframework.beans.factory.annotation.Value;

public class Person2 {
    private String name;
    private Integer age;
    @Value("${person.nickName}")
    private String nickName;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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

    public Person2(String name, Integer age) {
        super();
        this.name = name;
        this.age = age;
    }

    public Person2() {
        super();
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", nickName=" + nickName + "]";
    }
}

