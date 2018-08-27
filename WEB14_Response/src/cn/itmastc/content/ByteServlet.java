package cn.itmastc.content;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 14:10 2018/8/27
 * @Modified By:
 */
@WebServlet(name = "ByteServlet", urlPatterns = {"/byte"})
public class ByteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 使用response获得字节输入流
        ServletOutputStream out = response.getOutputStream();
        // 获得服务器上的图片
        String realPath = this.getServletContext().getRealPath("a.jpg");
        InputStream in = new FileInputStream(realPath);
        int len = 0;
        byte[] buffer = new byte[1024];
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }

        in.close();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
