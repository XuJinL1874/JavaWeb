package cn.itmastc.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author: X_JinL
 * @Description: Servlet中的方法:
 *                  init(ServletConfig servletConfig)
 *                   何时执行: servlet对象创建的时候执行
 *
 *                   service(ServletRequest servletRequest, ServletResponse servletResponse)
 *                      何时执行: 每次请求都会执行
 *                      ServletRequest: 代表请求  认为ServletRequest内部封装的是http请求的信息
 *                      ServletResponse: 代表响应 认为ServletResponse要封装的是响应的信息
 *
 *                   destroy()
 *                      何时执行: servlet销毁的时候执行
 *
 *                  Servlet的生命周期
 *                      Servlet 何时创建
 *                          默认第一次访问servlet时创建该对象
 *                      Servlet 何时销毁
 *                          服务器关闭servlet就销毁了
 *                      每次访问必然执行的方法
 *                          service(ServletRequest servletRequest, ServletResponse servletResponse)方法
 * @Date: Created in 13:34 2018/8/25
 * @Modified By:
 */
public class QuickStratServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        // 1.获得servlet的name ---- <servlet-name>abc</servlet-name>
        String servletName = servletConfig.getServletName();
        // System.out.println(servletName); 结果abc
        // 2.获得servlet的初始化参数
        String initParameter = servletConfig.getInitParameter("url");
        System.out.println(initParameter);
        // 3.获得ServletContext对象
        ServletContext servletContext = servletConfig.getServletContext();

        System.out.println("init running...");
    }


    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("QuickStratServlet running...");
    }

    @Override
    public void destroy() {
        System.out.println("destroy running...");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }
}
