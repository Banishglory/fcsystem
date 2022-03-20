package com.xc.fcsystem.utils;

/**
 * @Title:
 * @ClassName: ..java
 * @Description:全局消息状态码常量
 * @Param:
 * @author: cx
 * @date:
 * @version V1.0
 */
public class FusionMessage {

//    状态类
    public static class State{

        private int code;

        private String msg;

//        构造方法


    public State(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

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
    }

    public interface BaseState{

//        成功
        public static final State STATE_SUCCESS = new State(0,"成功");

//        系统异常
        public static final State STATE_FAIL = new State(1001,"系统异常");

//        参数异常
        public static final State STATE_PARAM = new State(1002,"参数异常");

//        session失效
        public static final State STATE_SESSION = new State(1003,"Session失效，请重新登录");

//        无相关权限
        public static final State STATE_NOACCESS = new State(1004,"无相关权限");

//        鉴权失败

        public static final State STATE_AUTH = new State(1005,"获取权限失败");

//        无相关数据
        public static final State STATE_EMPTY = new State(1006,"无相关数据");

//        需要编辑的对象信息不存在
        public static final State STATE_NOT_EXIST = new State(1006,"需要编辑的对象信息不存在");

//        用户不存在
        public static final State USER_NOT_EXIST = new State(1007,"用户不存在");



    }
}
