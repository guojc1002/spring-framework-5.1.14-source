package com.guojc.bean.lookUp;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class User {
    public void showMe(){
        log.info("i am User");
        log.info("User.hashCode"+this.hashCode());
    }
}
