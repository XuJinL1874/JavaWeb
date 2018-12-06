package cn.mastc.service.impl;

import cn.mastc.mapper.UsersMapper;
import cn.mastc.pojo.Users;
import cn.mastc.service.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author X_JinL
 * @version 1.0.0
 * @ClassName UsersServiceImpl.java
 * @Description
 * @createTime 2018/12/6 18:12
 */
@Service
public class UsersServiceImpl implements UsersService {

    @Resource
    private UsersMapper usersMapper;

    @Override
    public List<Users> show() {
        return usersMapper.selAll();
    }
}
