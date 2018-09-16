package cn.mastc.mail;

import javax.mail.MessagingException;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 16:18 2018/9/16
 * @Modified By:
 */
public class SendMailTest {

    public static void main(String[] args) throws MessagingException {

        MailUtils.sendMail("lucy@itheima32.com","测试邮件", "只是一封测试邮件");

    }

}
