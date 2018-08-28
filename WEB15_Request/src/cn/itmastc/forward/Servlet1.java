package cn.itmastc.forward;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 19:42 2018/8/28
 * @Modified By:
 */
@WebServlet(name = "Servlet1", urlPatterns = {"/servlet1"})
public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /**
         * request是一个域对象
         * request对象也是一个存储数据的域对象,所以也具有如下方法
         * setAttribute(String name, Object o)
         * getAttribute(String name)
         * removeAttribute(String name)
         *
         * 注意request域的作用范围: 一次请求中
         */
        // 向request域中存储数据
        request.setAttribute("name", "tom");

        // servlet1将请求转发给servlet2
        RequestDispatcher dispatcher = request.getRequestDispatcher("/servlet2");
        // 执行转发的方法
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
