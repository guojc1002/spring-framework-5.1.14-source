package com.guojc.bean.replaced;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class User {
    public void showMe(){
        log.info("初始方法...");
        log.info("User.hashCode"+this.hashCode());
    }
}
