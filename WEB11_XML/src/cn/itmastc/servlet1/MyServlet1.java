package cn.itmastc.servlet1;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 14:38 2018/8/24
 * @Modified By:
 */
public class MyServlet1 implements HelloMyServlet{
    @Override
    public void init() {
        System.out.println("MyServlet1诞生了...");
    }

    @Override
    public void servlet() {
        System.out.println("MyServlet1开始服务了...");
    }

    @Override
    public void destory() {
        System.out.println("MyServlet1销毁了...");
    }
}
