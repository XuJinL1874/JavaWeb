package cn.mastc.spring_01.demo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 16:38 2018/10/30
 * @Modified By:
 */
public class Demo {

    @Test
    public void fun1(){

        // 1.创建容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 2.向容器"要"user对象
        Object user = applicationContext.getBean("user");
        // 3.打印user对象
        System.out.println(user);

    }

}
