package cn.mastc.web.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 19:42 2018/9/17
 * @Modified By:
 */
public class QuickFilter1 implements Filter {
    /**
     * Filter创建的时候执行init方法
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 1.获得web.xml中filter的名称<filter-name>QuickFilter1</filter-name>
        System.out.println(filterConfig.getFilterName());
        // 2.获得当前filter的初始化参数
        System.out.println(filterConfig.getInitParameter("aaa"));
        // 3.获得servletContext
        filterConfig.getServletContext();
        System.out.println("init....");
    }

    /**
     * doFilter是Filter的核心过滤方法
     *
     * request:内部封装的是客户端http请求的内容
     * response:代表响应
     * FilterChain:过滤器链对象
     *
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        System.out.println("quick1 running...");
        // 放行请求
        filterChain.doFilter(servletRequest, servletResponse);
    }

    /**
     *  Filter对象销毁的时候执行destroy方法
     */
    @Override
    public void destroy() {
        System.out.println("destroy....");
    }
}
