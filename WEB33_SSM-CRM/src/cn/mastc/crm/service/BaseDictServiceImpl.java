package cn.mastc.crm.service;

import cn.mastc.crm.mapper.BaseDictDao;
import cn.mastc.crm.pojo.BaseDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author X_JinL
 * @version 1.0.0
 * @ClassName BaseDictServiceImpl.java
 * @Description
 * @createTime 2018/11/29 19:07
 */
@Service
//@Transactional
public class BaseDictServiceImpl implements BaseDictService {

    @Autowired
    private BaseDictDao baseDictDao;

    @Override
    public List<BaseDict> selectBaseDictListByCode(String code) {
        return baseDictDao.selectBaseDictListByCode(code);
    }

}
