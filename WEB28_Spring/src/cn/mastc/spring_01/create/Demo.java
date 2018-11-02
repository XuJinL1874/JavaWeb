package cn.mastc.spring_01.create;

import cn.mastc.spring_01.bean.User;
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
        User user = (User) applicationContext.getBean("user");
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

    // scope:singleton 单例
    // scope:prototype 多例

    @Test
    public void fun4(){

        // 1.创建容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext
                ("cn/mastc/create/applicationContext.xml");
        // 2.向容器"要"user对象
        User user = (User) applicationContext.getBean("user");
        User user2 = (User) applicationContext.getBean("user");
        User user3 = (User) applicationContext.getBean("user");
        User user4 = (User) applicationContext.getBean("user");
        // 单例: true,多例: false
        System.out.println(user2 == user4);
        // 3.打印user对象

        System.out.println(user);

    }

    // 测试生命周期方法

    @Test
    public void fun5(){

        // 1.创建容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext
                ("cn/mastc/create/applicationContext.xml");
        // 2.向容器"要"user对象
        User user = (User) applicationContext.getBean("user");
        // 3.打印user对象

        System.out.println(user);

        // 关闭容器,触发销毁方法
        ((ClassPathXmlApplicationContext) applicationContext).close();

    }

}
