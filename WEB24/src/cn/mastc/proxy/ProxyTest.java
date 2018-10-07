package cn.mastc.proxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 19:52 2018/10/7
 * @Modified By:
 */
public class ProxyTest {

    @Test
    public void test1() {
        // 获得动态的代理对象----在运行时,在代理中动态的为Target创建一个虚拟的代理对象
        // objProxy是代理对象,根据参数确定是谁的代理对象
        TargetInterface objProxy = (TargetInterface) Proxy.newProxyInstance(
                // 与目标对象相同的类加载器
                Target.class.getClassLoader(),
                new Class[]{TargetInterface.class},
                new InvocationHandler() {
                    // invoke 代表的是执行代理对象的方法
                    // method 代表目标对象的字节码对象
                    // args 代表目标对象的相应的方法的参数
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 执行目标对象的方法
                        method.invoke(new Target(), args);
                        return null;
                    }
                }
        );

        objProxy.method1();
        objProxy.method2();
    }

}
