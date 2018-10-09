package cn.mastc.web.servlet;

import cn.mastc.service.UserService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ActiveServlet", urlPatterns = {"/active"})
public class ActiveServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //获得激活码
        String activeCode = request.getParameter("activeCode");

        UserService service = new UserService();
        service.active(activeCode);

        //跳转到登录页面
        response.sendRedirect(request.getContextPath()+"/login.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
