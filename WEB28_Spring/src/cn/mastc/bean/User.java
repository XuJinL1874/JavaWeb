package cn.mastc.bean;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 15:55 2018/10/30
 * @Modified By:
 */
public class User {

    public User(){
        System.out.println("User对象空参构造方法!!!");
    }

    private String name;
    private String age;
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void init() {
        System.out.println("我是初始化方法!!!");
    }

    public void destory() {
        System.out.println("我是销毁方法!!!");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", car=" + car +
                '}';
    }
}
