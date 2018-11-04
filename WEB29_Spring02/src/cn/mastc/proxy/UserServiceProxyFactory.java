package cn.mastc.proxy;

import cn.mastc.service.UserService;
import cn.mastc.service.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: X_JinL
 * @Description:  动态代理
 * @Date: Created in 15:59 2018/11/4
 * @Modified By:
 */
public class UserServiceProxyFactory implements InvocationHandler {

    private UserService us;

    public UserServiceProxyFactory(UserService us) {
        this.us = us;
    }

    public UserService getUserServiceProxy() {
        // 生成动态代理
        UserService usProxy = (UserService) Proxy.newProxyInstance(UserServiceProxyFactory.class.getClassLoader(),
                UserServiceImpl.class.getInterfaces(),
                this
        );
        // 返回
        return usProxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("打开事务!");
        Object invoke = method.invoke(us, args);
        System.out.println("提交事务!");
        return invoke;
    }
}
