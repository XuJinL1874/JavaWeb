package cn.mastc.web.filter;

import cn.mastc.domain.User;
import cn.mastc.service.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLDecoder;
import java.sql.SQLException;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 15:12 2018/9/19
 * @Modified By:
 */
@WebFilter(filterName = "AutoLoginFilter",urlPatterns = {"/*"})
public class AutoLoginFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();

        // 获得cookie中的用户名和密码, 进行登录的操作
        // 定义cookie_username
        String cookie_username = null;
        // 定义cookie_password
        String cookie_password = null;
        // 获得cookie
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                // 获得名字是cookie_username和cookie_password
                if ("cookie_username".equals(cookie.getName())) {
                    cookie_username = cookie.getValue();
                    // 恢复中文用户名
                    cookie_username = URLDecoder.decode(cookie_username, "UTF-8");
                }
                if ("cookie_password".equals(cookie.getName())) {
                    cookie_password = cookie.getValue();
                }
            }
            // 判断username和password是否为null
            if (cookie_username != null && cookie_password != null) {
                // 登录代码
                UserService service = new UserService();
                User user = null;
                try {
                    user = service.login(cookie_username, cookie_password);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                // 将登陆的user对象存储到session中
                session.setAttribute("user", user);
            }
        }
        // 放行
        chain.doFilter(req, resp);

    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
