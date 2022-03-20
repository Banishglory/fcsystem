package com.xc.fcsystem.entity.user;

/**
 * @作者: cayuyu
 * @描述：默认描述
 * @创建时间:
 * @修改人：
 * @修改时间：
 * @修改描述：默认描述
 */
public class UserLoginReq {

    private String user_name;

    private String user_psd;

    public UserLoginReq() {
    }

    public UserLoginReq(String user_name, String user_psd) {
        this.user_name = user_name;
        this.user_psd = user_psd;
    }

    public String getuser_name() {
        return user_name;
    }

    public void setuser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getuser_psd() {
        return user_psd;
    }

    public void setuser_psd(String user_psd) {
        this.user_psd = user_psd;
    }

    @Override
    public String toString() {
        return "UserLoginReq{" +
                "user_name='" + user_name + '\'' +
                ", user_psd='" + user_psd + '\'' +
                '}';
    }
}
