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
 * @Date: Created in 16:04 2018/9/19
 * @Modified By:
 */
@WebServlet(name = "EncodingServlet", urlPatterns = {"/encodingServlet"})
public class EncodingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String parameter = request.getParameter("username");
        System.out.println(parameter);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
