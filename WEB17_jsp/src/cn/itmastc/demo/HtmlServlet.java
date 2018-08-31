package cn.itmastc.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 20:58 2018/8/31
 * @Modified By:
 */
@WebServlet(name = "HtmlServlet", urlPatterns = {"/htmlServlet"})
public class HtmlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();

        // 动态的响应html页面
        writer.write("<!DOCTYPE html>");
        writer.write("<html lang=\"en\">");
        writer.write("<head>");
        writer.write("<meta charset=\'UTF-8\'>");
        writer.write("<title>Title</title>");
        writer.write("</head>");
        writer.write("<body>");
        writer.write("<h1>php是世界上最好的语言...</h1>");
        writer.write("</body>");
        writer.write("</html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
