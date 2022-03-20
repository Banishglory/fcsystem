package com.xc.fcsystem.entity;

import com.xc.fcsystem.utils.FusionMessage;

/**
 * @作者: cayuyu
 * @描述：默认描述
 * @创建时间:
 * @修改人：
 * @修改时间：
 * @修改描述：默认描述
 */
public class BaseResBean {

    private int code;

    private String msg;

    public BaseResBean() {

//        初始化状态
        setState(FusionMessage.BaseState.STATE_SUCCESS);

    }

    public BaseResBean(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseResBean(FusionMessage.State state) {

        setState(state);

    }
    //getter、setter
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }



    //    设置状态
    public void setState(FusionMessage.State state){
        if (state != null) {
            this.code = state.getCode();
            this.msg = state.getMsg();

        }

    }
}
