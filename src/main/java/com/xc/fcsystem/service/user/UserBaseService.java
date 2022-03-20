package com.xc.fcsystem.service.user;

import com.xc.fcsystem.entity.BaseResBean;
import com.xc.fcsystem.entity.user.UserLoginReq;
import com.xc.fcsystem.entity.user.UserResBean;
import org.springframework.stereotype.Service;

/**
 * @作者: cayuyu
 * @描述：默认描述
 * @创建时间:
 * @修改人：
 * @修改时间：
 * @修改描述：默认描述
 */
public interface UserBaseService {

    public BaseResBean getUserInfo(UserLoginReq req);


}
