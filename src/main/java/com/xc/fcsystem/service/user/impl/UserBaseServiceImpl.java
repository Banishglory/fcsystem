package com.xc.fcsystem.service.user.impl;

import com.xc.fcsystem.dao.user.UserBaseMapper;
import com.xc.fcsystem.entity.BaseResBean;
import com.xc.fcsystem.entity.user.UserLoginReq;
import com.xc.fcsystem.entity.user.UserResBean;
import com.xc.fcsystem.service.user.UserBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @作者: cayuyu
 * @描述：默认描述
 * @创建时间:
 * @修改人：
 * @修改时间：
 * @修改描述：默认描述
 */
@Service
public class UserBaseServiceImpl implements UserBaseService { @Autowired
   private  UserBaseMapper userBaseMapper;

    @Override
    public BaseResBean getUserInfo(UserLoginReq req) {

        BaseResBean res = null;

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("user_name", req.getuser_name());

//        根据用户名查找用户信息
        UserResBean userResBean=userBaseMapper.selectUserInfoByAccount(params);
        if(userResBean != null){
            System.out.println("1");
        }
            System.out.println("2");

        return null;
    }
}
