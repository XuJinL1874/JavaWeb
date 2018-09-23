package cn.mastc.classloader;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 19:48 2018/9/19
 * @Modified By:
 */
public class Demo {
    public static void main(String[] args) {
        // 获得Demo字节码文件的类加载器

        // 获得Demo的字节码对象
        Class clazz = Demo.class;

        // 获得类加载器
        ClassLoader classLoader = clazz.getClassLoader();

        // 获得classes(src)下的任何资源
        // getResource 的参数路径相对classes(src)
        String path = classLoader.getResource("jdbc.properties").getPath();
        // classLoader.getResourceAsStream("");
        System.out.println(path);
    }
}
