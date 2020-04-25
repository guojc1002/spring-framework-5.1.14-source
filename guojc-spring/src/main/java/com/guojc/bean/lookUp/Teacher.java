package com.guojc.bean.lookUp;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Teacher extends User{
    @Override
    public void showMe() {
        log.info("i am Teacher");
        log.info("Teacher.hashCode"+this.hashCode());
    }
}
