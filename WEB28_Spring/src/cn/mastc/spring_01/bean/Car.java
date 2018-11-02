package cn.mastc.spring_01.bean;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 15:26 2018/11/1
 * @Modified By:
 */
public class Car {

    private String name;
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
