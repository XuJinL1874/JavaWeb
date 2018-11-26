package cn.mastc.springmvc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author X_JinL
 * @version 1.0.0
 * @ClassName interceptor1.java
 * @Description
 * @createTime 2018/11/25 21:15
 */
public class interceptor1 implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("方法前1");
        // 判断用户是否登录,如果没有登录,重定向到登录页面 不放行  如果登录了 就放行
        // URL  http://localhost:8080/WEB32_SpringMVC/login.action
        // URI  /login.action
        String requestURI = httpServletRequest.getRequestURI();
        if (requestURI.contains("/login")) {
            Object username = httpServletRequest.getSession().getAttribute("USER_SESSION");
            if (username == null) {
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login.action");
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("方法后1");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("页面渲染后1");
    }
}
