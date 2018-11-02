package cn.mastc.spring_01.injection;

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
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("cn/mastc/injection/applicationContext.xml");
        // 2.向容器"要"user对象
        Object user = applicationContext.getBean("user");
        // 3.打印user对象
        System.out.println(user);

    }
    @Test
    public void fun2(){

        // 1.创建容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("cn/mastc/injection/applicationContext.xml");
        // 2.向容器"要"user对象
        Object user = applicationContext.getBean("user2");
        // 3.打印user对象
        System.out.println(user);

    }

    @Test
    public void fun3(){

        // 1.创建容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("cn/mastc/injection/applicationContext.xml");
        // 2.向容器"要"user对象
        Object user = applicationContext.getBean("user3");
        // 3.打印user对象
        System.out.println(user);

    }

    @Test
    public void fun4(){

        // 1.创建容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("cn/mastc/injection/applicationContext.xml");
        // 2.向容器"要"user对象
        Object user = applicationContext.getBean("user4");
        // 3.打印user对象
        System.out.println(user);

    }

    @Test
    public void fun5(){

        // 1.创建容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("cn/mastc/injection/applicationContext.xml");
        // 2.向容器"要"user对象
        CollectionBean cb = (CollectionBean) applicationContext.getBean("cb");
        // 3.打印user对象
        System.out.println(cb);

    }

}
