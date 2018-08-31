package cn.itmastc.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 20:02 2018/8/31
 * @Modified By:
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // 验证码校验
        // 获得页面输入的验证
        String checkCode_client = request.getParameter("checkCode");
        // 获得生成图片的文字的验证码
        Object checkcode_session = request.getSession().getAttribute("checkcode_session");
        // 比对页面的和生成图片的验证码是否一致
        if (!checkCode_client.equals(checkcode_session)) {
            request.setAttribute("loginInfo", "您的验证码不正确");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }


        // 获得页面的用户名和密码进行数据库到校验
        // ......

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
