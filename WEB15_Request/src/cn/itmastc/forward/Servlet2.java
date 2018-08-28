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
 * @Date: Created in 19:43 2018/8/28
 * @Modified By:
 */
@WebServlet(name = "Servlet2", urlPatterns = {"/servlet2"})
public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Object attribute = request.getAttribute("name");
        response.getWriter().write("Welcome To There..." + attribute);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
