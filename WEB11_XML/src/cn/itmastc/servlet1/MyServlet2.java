package cn.itmastc.servlet1;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 14:38 2018/8/24
 * @Modified By:
 */
public class MyServlet2 implements HelloMyServlet{
    @Override
    public void init() {
        System.out.println("MyServlet2诞生了...");
    }

    @Override
    public void servlet() {
        System.out.println("MyServlet2开始服务了...");
    }

    @Override
    public void destory() {
        System.out.println("MyServlet2销毁了...");
    }
}
