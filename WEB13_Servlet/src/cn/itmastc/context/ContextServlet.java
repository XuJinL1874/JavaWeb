package cn.itmastc.context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 17:54 2018/8/26
 * @Modified By:
 */
public class ContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获得ServletContext对象
        ServletContext context = this.getServletContext();
        /**
         * 1.获得初始化参数
         */
        String initParameter = context.getInitParameter("driver");
        System.out.println(initParameter);

        /**
         * 2.ServletContext 获得web应用中任何资源的绝对路径(重要 重要 重要)
         */
        // 2.0获取a b c d.txt的绝对路径    相对于整个WEB_Servlet应用
        // 2.1获取a.txt
        String realPath_A = context.getRealPath("a.txt");
        System.out.println(realPath_A);
        // 2.2获取b.txt
        String realPath_B = context.getRealPath("WEB-INF/b.txt");
        System.out.println(realPath_B);
        // 2.3获得c.txt
        String realPath_C = context.getRealPath("WEB-INF/classes/c.txt");
        System.out.println(realPath_C);
        // 2.4获取d.txt---获取不到   发布项目到服务器,,只发布web下的全部内容

        // 在读取src(classes)下的资源是可以同类加载器-----专门加载classes 下的文件
        // getResource() 参数是一个相对地址 相对classes
        String path = ContextServlet.class.getClassLoader().getResource("c.txt").getPath();
        System.out.println(path);

        /**
         *
         *  3.ServletContext 是一个域对象(重要 重要 重要)
         *      存储数据的区域就是域对象
         *      ServletContext域对象的作用范围: 整个web应用(所有的web资源都可以随意向ServletContext域中存储数据,数据
         *      可以共享)
         *
         *      域对象的通用方法
         *          setAttribute(String name, Object obj)
         *          getAttribute(String name)
         *          removeAttribute(String name)
         */
        // 域对象----向ServletContext中存数据
        context.setAttribute("name", "ZhangSan");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
