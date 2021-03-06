package cn.mastc.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 19:50 2018/9/17
 * @Modified By:
 */
@WebServlet(name = "Servlet1", urlPatterns = {"/servlet1"})
public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Servlet1 running...");
        // response.getWriter().write("Servlet1 running...");
         request.getRequestDispatcher("/servlet2").forward(request, response);
        // response.sendRedirect(request.getContextPath() + "/servlet2");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
