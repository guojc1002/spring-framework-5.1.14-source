package com.guojc.bean;

import com.guojc.bean.aop.anno.Dog;
import com.guojc.bean.aop.anno.IIntroduce;
import com.guojc.bean.aop.xml.Animal;
import com.guojc.bean.config.*;
import com.guojc.bean.lookUp.GetBeanTest;
import com.guojc.bean.replaced.User;
import com.guojc.bean.tx.anno.service.BookService2;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

@Slf4j
public class DemoTest {

    @Test
    public void testTxAnno() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("txAnnotation-application.xml");
        BookService2 bookService = ioc.getBean(BookService2.class);
        int price = bookService.getPrice("ISBN-001");
        System.out.println("读取到的数据："+price);
        System.out.println(bookService.getClass());

    }

    @Test
    public void testAnnotationConfig() {
        //AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(MainConfig.class);
        applicationContext.addBeanFactoryPostProcessor(new MyBeanFactoryPostProcessor());
        applicationContext.addBeanFactoryPostProcessor(new MyBeanDefinitionRegistryPostProcessor());
        applicationContext.refresh();

        Person2 person = applicationContext.getBean(Person2.class);
        System.out.println(person);

        BookController bookController = applicationContext.getBean(BookController.class);
        bookController.print();
    }

    @Test
    public void testAopAnnoIntroduce() {
        // 引入
        ApplicationContext ctx = new ClassPathXmlApplicationContext("aopanno-application.xml");
        // 注意：getBean获取的是dog
        IIntroduce introduce = ctx.getBean("dog", IIntroduce.class);
        introduce.sayIntroduce();
    }

    @Test
    public void testAopAnnoNormal() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("aopanno-application.xml");
        Dog dog = ctx.getBean("dog", Dog.class);
        dog.sayHello();
    }

    @Test
    public void testAopXmlException() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("aopxml-application.xml");
        Animal cat = ctx.getBean("cat", Animal.class);
        cat.sayException("美美", 3);
    }


    @Test
    public void testAopXmlNormal() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("aopxml-application.xml");
        Animal cat = ctx.getBean("cat", Animal.class);
        cat.sayHello("美美", 3);
    }


    @Test
    public void testLookUp() {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("application-lookUp.xml"));
        GetBeanTest getBeanTest = bf.getBean("getBeanTest", GetBeanTest.class);
        getBeanTest.showMe();

        log.info("==============================================");
        GetBeanTest getBeanTest2 = bf.getBean("getBeanTest", GetBeanTest.class);

        getBeanTest.showMe();
        log.debug("执行完毕...");
    }


    @Test
    public void testReplace() {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("application-replace.xml"));
        User user = bf.getBean("user", User.class);
        user.showMe();

        log.info("==============================================");
        User user2 = bf.getBean("user", User.class);

        user2.showMe();
        log.debug("执行完毕...");
    }

    @Test
    public void testClassPathXmlApplicationContext() {
        ClassPathXmlApplicationContext bf = new ClassPathXmlApplicationContext("application.xml");
        Person person = bf.getBean("person", Person.class);
        log.info("person = {}", person);

        log.debug("执行完毕...");
    }

    @Test
    public void testXmlBeanFactory() {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("application.xml"));
        Person person = bf.getBean("person", Person.class);
        log.info("person = {}", person);

        log.debug("执行完毕...");
    }
}
