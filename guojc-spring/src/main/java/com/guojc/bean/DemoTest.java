package com.guojc.bean;

import com.guojc.bean.lookUp.GetBeanTest;
import com.guojc.bean.replaced.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

@Slf4j
public class DemoTest {
    @Test
    public void testXmlBeanFactory() {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("application.xml"));
        Person person = bf.getBean("person", Person.class);
        log.info("person = {}", person);

        log.debug("执行完毕...");
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
}
