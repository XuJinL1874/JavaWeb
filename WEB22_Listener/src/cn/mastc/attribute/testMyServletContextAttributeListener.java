package cn.mastc.attribute;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 16:07 2018/9/13
 * @Modified By:
 */
@WebServlet(name = "testMyServletContextAttributeListener", urlPatterns = {"/test1"})
public class testMyServletContextAttributeListener extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext context = this.getServletContext();

        // 向context域中存数据
        context.setAttribute("name", "tom");

        // 改context数据
        context.setAttribute("name", "lucy");

        // 删除context数据
        context.removeAttribute("name");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
