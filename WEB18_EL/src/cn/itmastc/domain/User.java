package cn.itmastc.domain;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 17:57 2018/9/3
 * @Modified By:
 */
public class User {

    private int id;
    private String name;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
