package cn.mastc.attribute;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 15:53 2018/9/13
 * @Modified By:
 */
public class MyServletContextAttributeListener implements ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        // 放到域中的属性

        // 放到域中的name
        System.out.println(servletContextAttributeEvent.getName());
        // 放到域中的value
        System.out.println(servletContextAttributeEvent.getValue());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        // 删除域中的name
        System.out.println(servletContextAttributeEvent.getName());
        // 删除域中的value
        System.out.println(servletContextAttributeEvent.getValue());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        // 获得修改前的name
        System.out.println(servletContextAttributeEvent.getName());
        // 获得修改前的value
        System.out.println(servletContextAttributeEvent.getValue());
    }
}
