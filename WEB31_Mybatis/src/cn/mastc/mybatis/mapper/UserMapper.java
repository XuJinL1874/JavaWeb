package cn.mastc.mybatis.mapper;

import cn.mastc.mybatis.pojo.User;

/**
 * @author X_JinL
 * @version 1.0.0
 * @ClassName UserMapper
 * @Description
 * @createTime 2018/11/11 15:04
 */
public interface UserMapper {

    // 遵循四个原则
    // 1.接口方法名 == User.xml 中 id 名
    // 2.返回值类型与Mapper.xml文件中文件名保持一致
    // 3.方法的入参类型与Mapper.xml中参数的类型一致
    // 4.命名空间绑定此接口


    public User findUserById(Integer id);

}
