package com.guojc.bean;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Person {
    private String lastName;
    private Integer age;
    private String gender;
    private String email;

    public Person() {
        super();
        System.out.println("person创建了...");
    }
}
