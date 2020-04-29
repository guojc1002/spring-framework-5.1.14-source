package com.guojc.bean.aop.anno;

public class IntroduceImpl implements IIntroduce {
    @Override
    public void sayIntroduce() {
        System.out.println("--引入");
    }
}