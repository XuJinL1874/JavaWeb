package cn.mastc.annotationaop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @Author: X_JinL
 * @Description:  通知类
 * @Date: Created in 17:55 2018/11/4
 * @Modified By:
 */
@SuppressWarnings("all")
@Aspect
// 表示该类是一个通知类
public class MyAdvice {

    @Pointcut("execution(* cn.mastc.service.*ServiceImpl.*(..))")
    public void pc(){}

    // 前置通知
    // 指定该方法是前置通知,并指定切入点
    @Before("MyAdvice.pc()")
    public void before() {
        System.out.println("这是前置通知!!!");
    }

    // 后置通知
    @AfterReturning("execution(* cn.mastc.service.*ServiceImpl.*(..))")
    public void afterReturning() {
        System.out.println("这是后置通知,如果出现异常不会调用!!!");
    }

    // 环绕通知
    @Around("execution(* cn.mastc.service.*ServiceImpl.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("这是环绕通知之前的部分");
        // 调用目标方法
        Object proceed = pjp.proceed();
        System.out.println("这是环绕通知之后的部分");
        return proceed;
    }

    // 异常通知
    @AfterThrowing("execution(* cn.mastc.service.*ServiceImpl.*(..))")
    public void afterException() {
        System.out.println("出现异常了!!!");
    }

    // 后置通知
    @After("execution(* cn.mastc.service.*ServiceImpl.*(..))")
    public void after() {
        System.out.println("这是后置通知,出现异常也会调用!!!");
    }

}
