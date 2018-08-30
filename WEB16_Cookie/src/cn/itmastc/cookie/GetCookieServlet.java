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
 * @Date: Created in 19:23 2018/8/30
 * @Modified By:
 */
@WebServlet(name = "GetCookieServlet", urlPatterns = {"/getCookie"})
public class GetCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获得客户端携带的Cookie数据
        Cookie[] cookies = request.getCookies();
        // Cookie cookies = new Cookie("name", "zhangsan");
        // 通过cookie名称获得想要的cookie
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                // 获得cookie的名称
                String cookieName = cookie.getName();
                if (cookieName.equals("name")) {
                    // 获得该cookie的值
                    String cookieValue = cookie.getValue();
                    System.out.println(cookieValue);
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
