package cn.mastc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 20:36 2018/10/7
 * @Modified By:
 */
public class ProxyTest2 {

    public static void main(String[] args) {

        Target target = new Target();

        // 动态创建代理对象

        TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    // 被执行几次?----看代理对象调用方法几次
                    // 代理对象调用接口相应方法,都是调用invoke

                    /**
                     * proxy:是代理对象
                     * method:代表的是目标方法的字节码对象
                     * args:代表的是调用目标方法时 参数
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 反射知识点
                        // 目标对象的相应方法
                        Object invoke = method.invoke(target, args);
                        // return返回的值给代理对象
                        return invoke;
                    }
                }
        );

        // 调用invoke----Method:目标对象的mehtod1()方法 args:null 返回值:null
        proxy.method1();
        // 调用invoke----Method:目标对象的mehtod2()方法 args:null 返回值:method2
        String method2 = proxy.method2();
        // 调用invoke----Method:目标对象的mehtod3()方法 args:Object[]{100} 返回值:100
        int method3 = proxy.method3(100);


        System.out.println(method2);
        System.out.println(method3);
    }

}
