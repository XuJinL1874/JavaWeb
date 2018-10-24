package com.itheima.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itheima.domain.User;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 16:14 2018/10/24
 * @Modified By:
 */
@WebFilter(filterName = "UserLoginPrivilegeFilter")
public class UserLoginPrivilegeFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        //校验用户是否登录----校验session是否存在user对象
        HttpSession session = req.getSession();

        //判断用户是否已经登录 未登录下面代码不执行
        User user = (User) session.getAttribute("user");
        if(user==null){
            //没有登录
            resp.sendRedirect(req.getContextPath()+"/login.jsp");
            return;
        }

        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
