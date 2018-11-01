package cn.mastc.injection;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 19:00 2018/11/1
 * @Modified By:
 */
public class CollectionBean {

    // 数组类型注入
    private Object[] arr;
    // list/set 类型注入
    private List list;
    // map类型注入
    private Map map;
    // properties类型注入
    private Properties prop;

    @Override
    public String toString() {
        return "CollectionBean{" +
                "arr=" + Arrays.toString(arr) +
                ", list=" + list +
                ", map=" + map +
                ", prop=" + prop +
                '}';
    }

    public Object[] getArr() {
        return arr;
    }

    public void setArr(Object[] arr) {
        this.arr = arr;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Properties getProp() {
        return prop;
    }

    public void setProp(Properties prop) {
        this.prop = prop;
    }
}
