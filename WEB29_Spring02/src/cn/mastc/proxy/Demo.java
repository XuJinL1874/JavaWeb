package cn.mastc.proxy;

import cn.mastc.service.UserService;
import cn.mastc.service.UserServiceImpl;
import org.junit.Test;

import java.sql.SQLOutput;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 16:17 2018/11/4
 * @Modified By:
 */
public class Demo {

    // 动态代理

    @Test
    public void fun1() {
        UserService us = new UserServiceImpl();

        UserServiceProxyFactory factory = new UserServiceProxyFactory(us);

        UserService usProxy = factory.getUserServiceProxy();

        usProxy.save();

        // 代理对象与被代理对象实现了相同的接口,代理对象与被代理对象没有继承关系=>false
        System.out.println(usProxy instanceof UserServiceImpl);
    }

    // cglib代理

    @Test
    public void fun2() {


        UserServiceProxyFactory2 factory = new UserServiceProxyFactory2();

        UserService usProxy = factory.getUserServiceProxy();

        usProxy.save();

        // 判断代理对象是否属于被代理对象类型,代理对象继承了被代理对象=>true
        System.out.println(usProxy instanceof UserServiceImpl);
    }

}
