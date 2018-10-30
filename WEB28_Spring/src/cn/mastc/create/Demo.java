package cn.mastc.create;

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

    // 创建方式1:空参构造

    @Test
    public void fun1(){

        // 1.创建容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext
                ("cn/mastc/create/applicationContext.xml");
        // 2.向容器"要"user对象
        Object user = applicationContext.getBean("user");
        // 3.打印user对象
        System.out.println(user);

    }

    // 创建方式2:静态工厂创建

    @Test
    public void fun2(){

        // 1.创建容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext
                ("cn/mastc/create/applicationContext.xml");
        // 2.向容器"要"user对象
        Object user = applicationContext.getBean("user2");
        // 3.打印user对象
        System.out.println(user);

    }

    // 创建方式3:实例工厂

    @Test
    public void fun3(){

        // 1.创建容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext
                ("cn/mastc/create/applicationContext.xml");
        // 2.向容器"要"user对象
        Object user = applicationContext.getBean("user3");
        // 3.打印user对象
        System.out.println(user);

    }

}
