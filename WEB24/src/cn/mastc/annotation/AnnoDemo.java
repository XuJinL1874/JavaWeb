package cn.mastc.annotation;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: X_JinL
 * @Description: JDK1.5注解
 * @Date: Created in 12:10 2018/10/1
 * @Modified By:
 */
// 压制所有警告
@SuppressWarnings("all")
public class AnnoDemo {
    public static void main(String[] args) {

        List list = new ArrayList();

        show();

    }

    // 定义方法过时
    @Deprecated
    public static void show() {

    }

    public static void show(String xx){

    }

    // 帮助开发人员检查是否覆盖父类的方法正确
    @Override
    public String toString() {
        return super.toString();
    }
}
