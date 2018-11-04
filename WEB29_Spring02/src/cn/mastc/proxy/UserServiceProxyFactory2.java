package cn.mastc.proxy;

import cn.mastc.service.UserService;
import cn.mastc.service.UserServiceImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: X_JinL
 * @Description:  cglib代理
 * @Date: Created in 16:34 2018/11/4
 * @Modified By:
 */
public class UserServiceProxyFactory2 implements MethodInterceptor {

    public UserService getUserServiceProxy() {
        // 帮我们生成代理对象
        Enhancer en = new Enhancer();
        // 设置对谁进行代理
        en.setSuperclass(UserServiceImpl.class);
        // 代理要做什么
        en.setCallback(this);
        // 创建代理对象
        UserService us = (UserService) en.create();
        return us;

    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        // 打开事务
        System.out.println("打开事务!");
        // 调用原有方法
        Object returnValue = methodProxy.invokeSuper(o, objects);
        // 提交事务
        System.out.println("提交事务!");
        return returnValue;
    }
}
