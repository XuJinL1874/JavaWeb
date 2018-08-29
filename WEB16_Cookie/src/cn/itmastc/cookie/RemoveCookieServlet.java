package cn.itmastc.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 22:12 2018/8/29
 * @Modified By:
 */
@WebServlet(name = "RemoveCookieServlet", urlPatterns = {"/remove"})
public class RemoveCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 删除客户端保存name=zhangsan的cookie信息
        Cookie cookie = new Cookie("name", "");
        // 将path设置与要删除cookie的path一致
        cookie.setPath("WEB16_Cookie/sendCookie");
        // 设置时间是0
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
