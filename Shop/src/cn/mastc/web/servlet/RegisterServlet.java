package cn.mastc.web.servlet;

import cn.mastc.domain.User;
import cn.mastc.service.UserService;
import cn.mastc.utils.CommonsUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 15:53 2018/10/8
 * @Modified By:
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        // 获得表单数据
        Map<String, String[]> properties = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, properties);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        // private String uid;
        user.setUid(CommonsUtils.getUUID());
        // private String telephone;
        user.setTelephone(null);
        // private int state;
        user.setState(0);
        // private String code;
        user.setCode(CommonsUtils.getUUID());


        // 将user传递给service层
        UserService service = new UserService();
        boolean isRegisterSuccess = service.regist(user);

        // 是否注册成功
        if (isRegisterSuccess) {
            //
        } else {
            //
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
