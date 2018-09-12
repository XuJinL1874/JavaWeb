package cn.mastc.web;

import cn.mastc.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 14:53 2018/9/12
 * @Modified By:
 */
@WebServlet(name = "CheckUsernameServlet", urlPatterns = {"/checkUsername"})
public class CheckUsernameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 获得要校验的用户名
        String username = request.getParameter("username");

        // 传递username到service
        UserService service = new UserService();
        boolean isExist = false;
        try {
            isExist = service.checkUsername(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.getWriter().write("{\"isExist\":"+isExist+"}");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
