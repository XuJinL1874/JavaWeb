package cn.mastc.ajax_2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 20:53 2018/9/11
 * @Modified By:
 */
@WebServlet(name = "AjaxServlet2", urlPatterns = {"/ajaxServlet2"})
public class AjaxServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String age = request.getParameter("age");

        System.out.println(name + "  " + age);

        // java代码只能返回一个json类型的字符串{"name":"tom", "age":22}

        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("{\"name\":\"汤姆\", \"age\":22}");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
