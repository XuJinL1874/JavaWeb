package cn.mastc.mapper;

import cn.mastc.pojo.Pic;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author X_JinL
 * @version 1.0.0
 * @ClassName PicMapper.java
 * @Description
 * @createTime 2018/12/8 14:44
 */
public interface PicMapper {

    @Select("select * from pic")
    List<Pic> selAll();

}
