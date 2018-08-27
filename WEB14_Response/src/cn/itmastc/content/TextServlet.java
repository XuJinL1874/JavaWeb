package cn.itmastc.content;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 13:35 2018/8/27
 * @Modified By:
 */
public class TextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 设置response查询的码表
        // response.setCharacterEncoding("UTF-8");

        // 通过一个头Content-Type 告知客户端使用何种码表
        // response.setHeader("Content-Type", "text/html;charset=UTF-8");

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = response.getWriter();
        writer.write("你好");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
