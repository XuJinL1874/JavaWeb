package cn.mastc.mybatis.pojo;

import java.io.Serializable;

/**
 * @author X_JinL
 * @version 1.0.0
 * @ClassName QueryVo.java
 * @Description
 * @createTime 2018/11/12 15:04
 */
public class QueryVo implements Serializable {

    private static final long serialVersionUID = 1L;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
