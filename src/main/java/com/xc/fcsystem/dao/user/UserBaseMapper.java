package com.xc.fcsystem.dao.user;

import com.xc.fcsystem.entity.user.UserResBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * @作者: cayuyu
 * @描述：默认描述
 * @创建时间:
 * @修改人：
 * @修改时间：
 * @修改描述：默认描述
 */

@Mapper
public interface UserBaseMapper {

//    登录查询用户信息根据用户名
    UserResBean selectUserInfoByAccount(Map<String,Object> params);

}
