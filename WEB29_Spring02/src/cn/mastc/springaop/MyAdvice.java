package cn.mastc.springaop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @Author: X_JinL
 * @Description:  通知类
 * @Date: Created in 17:55 2018/11/4
 * @Modified By:
 */
public class MyAdvice {


    /**
     *     // 前置通知: 目标方法运行前调用
     *
     *     // 后置通知(如果出现异常不会调用): 在目标方法调用之后调用
     *
     *     // 环绕通知: 在目标方法之前和之后都调用
     *
     *     // 异常拦截通知: 如果出现异常,就会调用
     *
     *     // 后置通知(无论是否出现异常都会调用): 在目标方法之后调用
     */

    // 前置通知
    public void before() {
        System.out.println("这是前置通知!!!");
    }

    // 后置通知
    public void afterReturning() {
        System.out.println("这是后置通知,如果出现异常不会调用!!!");
    }

    // 环绕通知
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("这是环绕通知之前的部分");
        // 调用目标方法
        Object proceed = pjp.proceed();
        System.out.println("这是环绕通知之后的部分");
        return proceed;
    }

    // 异常通知
    public void afterException() {
        System.out.println("出现异常了!!!");
    }

    // 后置通知
    public void after() {
        System.out.println("这是后置通知,出现异常也会调用!!!");
    }

}
