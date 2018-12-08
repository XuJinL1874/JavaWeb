package cn.mastc.service.impl;

import cn.mastc.mapper.PicMapper;
import cn.mastc.pojo.Pic;
import cn.mastc.service.PicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author X_JinL
 * @version 1.0.0
 * @ClassName PicServiceImpl.java
 * @Description
 * @createTime 2018/12/8 14:48
 */
@Service
public class PicServiceImpl implements PicService {

    @Resource
    private PicMapper picMapper;

    @Override
    public List<Pic> show() {
        return picMapper.selAll();
    }

}
