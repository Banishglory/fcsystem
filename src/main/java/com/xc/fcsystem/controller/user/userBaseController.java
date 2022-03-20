package com.xc.fcsystem.controller.user;

import com.xc.fcsystem.entity.BaseResBean;
import com.xc.fcsystem.entity.user.UserLoginReq;
import com.xc.fcsystem.entity.user.UserResBean;
import com.xc.fcsystem.service.user.UserBaseService;
import com.xc.fcsystem.utils.FusionConstant;
import com.xc.fcsystem.utils.FusionMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @作者: cayuyu
 * @描述：默认描述
 * @创建时间:
 * @修改人：
 * @修改时间：
 * @修改描述：默认描述
 */

@Controller
@RequestMapping("/user/base")
public class userBaseController {

    @Autowired
    private UserBaseService service;

    /**
     * 日志管理
     */
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    @ResponseBody
    public BaseResBean userLogin(HttpServletRequest request, HttpSession session, HttpServletResponse response,
                            @Valid @RequestBody UserLoginReq inparam, BindingResult result, Model model) {

        BaseResBean res = null;
        System.out.println("控制层："+inparam);

        try {

            if (result.hasErrors()) {
                return res;
            }

            res = new BaseResBean();
//初始化为异常状态
            res.setState(FusionMessage.BaseState.STATE_FAIL);
//            获取登录用户的信息
            res = service.getUserInfo(inparam);
//如果为获取到信息则返回状态为空，获取到则取到相关数据并放入session域中
            if (null == res) {
                res = new BaseResBean(FusionMessage.BaseState.STATE_EMPTY);
            } else {

                if ((res.getCode() == FusionMessage.BaseState.STATE_SUCCESS.getCode())) {
//                取到数据
                    UserResBean userDep = (UserResBean) res;
//                用户id  用户名  登录名
                    session.setAttribute(FusionConstant.SESSION_USER_ID, userDep.getUser_id());
                    session.setAttribute(FusionConstant.SESSION_USER_NAME, userDep.getUser_name());

//            token暂略
            /*
                String token = JwtUtil.getToken(acct.getAcCode());
                System.out.println(token);
                response.setHeader("token", token);
                res.setToken(token);
                session.setAttribute("token", token);
             */
                }

            }
        } catch (Exception e) {

            logger.error("getUserInfo->exception", e);
        }

        return res;
    }


}
