package cn.mastc.web.servlet;

import cn.mastc.domain.User;
import cn.mastc.service.UserService;
import cn.mastc.utils.CommonsUtils;
import cn.mastc.utils.MailUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
            // 自己指定一个类型转换器(将String转成Date)
            ConvertUtils.register(new Converter() {
                @Override
                public Object convert(Class aClass, Object o) {
                    // 将String转成Date
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    Date parse = null;
                    try {
                        parse = format.parse(o.toString());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    return parse;
                }
            }, Date.class);

            // 映射封装
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
        String activeCode = CommonsUtils.getUUID();
        user.setCode(activeCode);


        // 将user传递给service层
        UserService service = new UserService();
        boolean isRegisterSuccess = service.regist(user);

        // 是否注册成功
        if (isRegisterSuccess) {
            // 发送激活邮件
            String emailMsg = "恭喜您注册成功,请点击下面的连接进行账户激活" +
                    "<a href='http://localhost:8080/Shop/active?activeCode"+activeCode+"'>" +
                    "http://localhost:8080/Shop/active?activeCode="+activeCode+"</a>";
            try {
                MailUtils.sendMail(user.getEmail(),emailMsg);
            } catch (MessagingException e) {
                e.printStackTrace();
            }

            // 跳转到注册成功页面
            response.sendRedirect(request.getContextPath() + "/registerSuccess.jsp");
        } else {
            // 跳转到失败的提示页面
            response.sendRedirect(request.getContextPath() + "/registerFail.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
