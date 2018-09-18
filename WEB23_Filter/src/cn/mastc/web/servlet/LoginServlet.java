package cn.mastc.web.servlet;

import cn.mastc.domain.User;
import cn.mastc.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 16:36 2018/9/18
 * @Modified By:
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        // 获取数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserService service = new UserService();
        User user = null;
        try {
            user = service.login(username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (user != null) {
            // 登录成功
            // 将登陆的user对象存储到session中
            session.setAttribute("user", user);
            // 重定向到首页
            response.sendRedirect(request.getContextPath());
        } else {
            // 登录失败 转发到登录页面 提示信息
            request.setAttribute("loginInfo", "用户名或密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
