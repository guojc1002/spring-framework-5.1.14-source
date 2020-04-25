package com.guojc.bean.replaced;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

@Slf4j
public class MyBeanReplacer implements MethodReplacer {

    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        log.info("我替换了原来的method!");
        log.info("MyBeanReplacer.hashCode() = {}",this.hashCode());
        return null;
    }
}