package cn.mastc.mybatis.pojo;

import java.io.Serializable;
import java.util.List;

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
    List<Integer> idList;
    Integer[] ids;

    public List<Integer> getIdList() {
        return idList;
    }

    public void setIdList(List<Integer> idList) {
        this.idList = idList;
    }

    public Integer[] getIds() {
        return ids;
    }

    public void setIds(Integer[] ids) {
        this.ids = ids;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
