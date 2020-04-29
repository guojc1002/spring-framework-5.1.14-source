package com.guojc.bean.config;

import org.springframework.context.annotation.*;


//配置类==配置文件
@Configuration  //告诉Spring这是一个配置类
@ComponentScan(value="com.guojc.bean.config")
@Import({Color.class})
@PropertySource(value={"classpath:/person.properties"})
public class MainConfig {
    //给容器中注册一个Bean;类型为返回值的类型，id默认是用方法名作为id
    @Bean
    public Person2 person(){
        return new Person2("lisi", 20);
    }

}
