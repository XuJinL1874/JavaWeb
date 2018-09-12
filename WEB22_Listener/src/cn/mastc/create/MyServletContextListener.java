package cn.mastc.create;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 19:45 2018/9/12
 * @Modified By:
 */
public class MyServletContextListener implements ServletContextListener {

    // 监听context域对象的创建
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        // 就是被监听的对象----servletContext
        // ServletContext servletContext = servletContextEvent.getServletContext();
        // getSource获得被监听的对象----是通用的方法
        // ServletContext source = (ServletContext) servletContextEvent.getSource();
        System.out.println("context创建...");
    }

    // 监听context域对象的销毁
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("context销毁...");
    }
}
