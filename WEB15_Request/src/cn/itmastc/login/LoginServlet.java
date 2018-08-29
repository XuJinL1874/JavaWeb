package cn.itmastc.login;

import cn.itmastc.register.User;
import cn.itmastc.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 14:51 2018/8/29
 * @Modified By:
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 设置字符编码
        request.setCharacterEncoding("UTF-8");

        // 获得用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 2.调用一个业务方法进行该用户查询
        User login = null;
        try {
            login =  login(username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 3.通过User是否为null判断用户名和密码是否正确
        if (login != null) {
            // 用户名和密码正确
            // 登录成功跳转到网站首页
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } else {
            //用户名或密码错误
            //跳回当前login.jsp
            //使用转发 转发到login.jsp  向request域中存储错误信息
            request.setAttribute("loginInfo", "用户名或密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }

    public User login(String username, String password) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user where username=? and password=?";
        User user = queryRunner.query(sql, new BeanHandler<User>(User.class), username, password);
        return user;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
