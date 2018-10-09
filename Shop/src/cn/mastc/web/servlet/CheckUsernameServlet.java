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
 * @Date: Created in 18:17 2018/10/9
 * @Modified By:
 */
@WebServlet(name = "CheckUsernameServlet", urlPatterns = {"/checkUsername"})
public class CheckUsernameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 获得用户名
        String username = request.getParameter("username");

        UserService service = new UserService();
        boolean isExist = service.checkUsername(username);

        String json = "{\"isExist\":" + isExist + "}";
        response.getWriter().write(json);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
