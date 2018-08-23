package cn.itmastc.domain;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 14:06 2018/8/23
 * @Modified By:
 */
public class User {
    private int uid;
    private String uname;
    private String upassword;

    public User() {
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }
}
