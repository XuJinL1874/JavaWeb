package cn.itmastc.login;

import cn.itmastc.domain.User;
import cn.itmastc.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 13:41 2018/8/26
 * @Modified By:
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // username=zhangsan&password=123
        // 1.获得用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 2.从数据库中验证该用户名和密码是否正确
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user where username=? and password=?";
        User user = null;
        try {
            user = runner.query(sql, new BeanHandler<User>(User.class), username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 3.根据显示的结果给用户不同显示信息
        if (user != null) {
            // 用户登录成功
            response.getWriter().write(user.toString());
        } else {
            // 用户登录失败
            response.getWriter().write("sorry your username or password wrong!!!");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
