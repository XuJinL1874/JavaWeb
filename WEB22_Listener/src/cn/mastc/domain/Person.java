package cn.mastc.domain;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 16:26 2018/9/13
 * @Modified By:
 */
public class Person implements HttpSessionBindingListener {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 绑定的方法
    @Override
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("person被绑定了");
    }

    // 解绑的方法
    @Override
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("person被解绑了");
    }
}
