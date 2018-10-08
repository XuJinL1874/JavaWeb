package cn.mastc.web.servlet;

import cn.mastc.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 21:28 2018/10/8
 * @Modified By:
 */
@WebServlet(name = "ActiveServlet", urlPatterns = {"/active"})
public class ActiveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 获得激活码
        String activeCode = request.getParameter("activeCode");

        UserService service = new UserService();
        service.active(activeCode);

        // 跳转到登录页面(重定向)
        response.sendRedirect(request.getContextPath() + "/login.jsp");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
