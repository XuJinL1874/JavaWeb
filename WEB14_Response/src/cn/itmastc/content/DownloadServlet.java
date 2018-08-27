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
 * @Date: Created in 16:28 2018/8/27
 * @Modified By:
 */
@WebServlet(name = "DownloadServlet", urlPatterns = {"/download"})
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获得要下载的文件的名称
        // a.flv
        String filename = request.getParameter("filename");
        // 要下载的这个文件类型----客户端通过文件MIME类型去区分类型
        response.setContentType(this.getServletContext().getMimeType(filename));
        // 告诉客户端该文件不是直接解析,而是以附件形式打开(下载)
        response.setHeader("Content-Disposition", "attachment;filename="+filename);

        // 获取文件的绝对路径
        String path = this.getServletContext().getRealPath("download/" + filename);
        // 获取该文件的输入流
        InputStream in = new FileInputStream(path);
        // 获得输出流-----通过response获得输出流,用于向客户端写内容
        ServletOutputStream out = response.getOutputStream();
        // 文件拷贝的模板
        int len = 0;
        byte[] buffer = new byte[1024];
        while ((len = in.read()) > 0) {
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
