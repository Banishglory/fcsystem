package com.xc.fcsystem.utils;

public class FusionConstant {


    /**
     * 是否是调试阶段
     */
    public static final boolean isDebug = true;
    /**
     * 默认密码
     */
    public static final String DefultPwd = "123456";

    /**
     * 用户姓名
     */
    public static final String SESSION_USER_NAME = "sessionUserName";
    /**
     * 登录姓名
     */
    public static final String SESSION_USER_ACCOUNT = "sessionUserCode";
    /**
     * 用户ID
     */
    public static final String SESSION_USER_ID = "sessionUserId";
    /**
     * 部门Id
     */
    public static final String SESSION_DEP_ID = "sessionDepId";
    /**
     * 登录账号
     */




    /**
     * 是否被删除状态
     *
     * @Title: FusionMessage.java
     * @version V1.0
     */
    public interface IsDelete {
        /**
         * 已经被删除
         */
        final int HAS_DELETE = 1;
        /**
         * 未删除
         */
        final int NOT_DELETE = 0;
    }
    /**
     * 项目跟踪立项状态
     *
     * @Title: FusionMessage.java
     * @version V1.0
     */


    public interface IsBuild {
        /**
         * 立项已审批通过
         */
        final int HAS_BUILD = 1;
        /**
         * 立项未审批
         */
        final int NOT_BUILD = 0;
        /**
         * 立项审批驳回
         */
        final int REJECT_BUILD = 2;
    }
    /**
     * 项目跟踪提交审批状态
     *
     * @Title: FusionMessage.java
     * @version V1.0
     */


    public interface IsCheck {
        /**
         * 提交已审核通过
         */
        final int HAS_CHECK = 1;
        /**
         * 提交未审核
         */
        final int NOT_CHECK = 0;
        /**
         * 提交已审核驳回
         */
        final int REJECT_CHECK = 2;
    }

}
