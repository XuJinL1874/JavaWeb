package cn.mastc.proxy;

/**
 * @Author: X_JinL
 * @Description:  AOP的开发中的相关术语
 * @Date: Created in 17:32 2018/11/4
 * @Modified By:
 */
public class Demo2 {

    /*Joinpoint(连接点):所谓连接点是指那些被拦截到的点。在 spring 中,这些点指的是方法,因为 spring 只 支持方法类型的连接点.
     Pointcut(切入点):所谓切入点是指我们要对哪些 Joinpoint 进行拦截的定义.
     Advice(通知/增强):所谓通知是指拦截到 Joinpoint 之后所要做的事情就是通知.通知分为前置通知,后置 通知,异常通知,最终通知,环绕通知(切面要完成的功能)
     Introduction(引介):引介是一种特殊的通知在不修改类代码的前提下, Introduction 可以在运行期为类 动态地添加一些方法或 Field.
     Target(目标对象):代理的目标对象 Weaving(织入):是指把增强应用到目标对象来创建新的代理对象的过程.
     spring 采用动态代理织入，而 AspectJ 采用编译期织入和类装在期织入
     Proxy（代理）:一个类被 AOP 织入增强后，就产生一个结果代理类 Aspect(切面): 是切入点和通知（引介）的结合*/

}
