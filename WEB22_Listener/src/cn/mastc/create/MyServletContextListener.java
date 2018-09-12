package cn.mastc.create;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 19:45 2018/9/12
 * @Modified By:
 */
public class MyServletContextListener implements ServletContextListener {

    // 监听context域对象的创建
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        // 就是被监听的对象----servletContext
        // ServletContext servletContext = servletContextEvent.getServletContext();
        // getSource获得被监听的对象----是通用的方法
        // ServletContext source = (ServletContext) servletContextEvent.getSource();
        System.out.println("context创建...");

        // 开启一个计息任务调度-----每天晚上十二点计息一次
        Timer timer = new Timer();
       /* // timer.scheduleAtFixedRate(task, firstTime, period);
        // task:任务 firstTime:第一次执行时间 period:间隔执行时间
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("银行计息了...");
            }
        }, new Date(), 5000);*/

        // 修改成银行真实计息业务
        // 1.起始时间:定义成晚上12点
        // 2.间隔时间:二十四小时

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        // String currentTime = "2018-09-13 00:00:00";
        String currentTime = "2018-09-12 20:51:00";
        Date parse = null;
        try {
            parse = format.parse(currentTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("银行计息了...");
            }
        }, parse, 24*60*60*1000);
    }

    // 监听context域对象的销毁
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("context销毁...");
    }
}
