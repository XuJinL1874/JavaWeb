package cn.itmastc.line;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 22:25 2018/8/27
 * @Modified By:
 */
@WebServlet(name = "LineServlet", urlPatterns = {"/line"})
public class LineServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获得请求方式
        String method = request.getMethod();
        System.out.println(method);
        // 获得请求的资源相关的内容
        String requestURI = request.getRequestURI();
        StringBuffer requestURL = request.getRequestURL();
        System.out.println("uri:" + requestURI);
        System.out.println("url:" + requestURL);
        // 获得web应用的名称
        String contextPath = request.getContextPath();
        System.out.println("web应用:"+contextPath);
        // 地址后的参数的字符串
        String queryString = request.getQueryString();
        System.out.println(queryString);
        // 获得客户机的信息----获得访问者IP地址
        String remoteAddr = request.getRemoteAddr();
        System.out.println("IP:" + remoteAddr);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
