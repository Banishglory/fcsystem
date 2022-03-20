package com.xc.fcsystem.entity.user;

import com.xc.fcsystem.entity.BaseResBean;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @作者: cayuyu
 * @描述：默认描述
 * @创建时间:
 * @修改人：
 * @修改时间：
 * @修改描述：默认描述
 */
public class UserResBean extends BaseResBean {
    private int id;

    private int user_id;

    private String user_name;

    private String user_psd;

    private String user_desc;

    private int user_role;

    private int user_flag;

    public UserResBean() {
    }

    public UserResBean(int id, int user_id, String user_name, String user_psd, String user_desc, int user_role, int user_flag) {
        this.id = id;
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_psd = user_psd;
        this.user_desc = user_desc;
        this.user_role = user_role;
        this.user_flag = user_flag;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_psd() {
        return user_psd;
    }

    public void setUser_psd(String user_psd) {
        this.user_psd = user_psd;
    }

    public String getUser_desc() {
        return user_desc;
    }

    public void setUser_desc(String user_desc) {
        this.user_desc = user_desc;
    }

    public int getUser_role() {
        return user_role;
    }

    public void setUser_role(int user_role) {
        this.user_role = user_role;
    }

    public int getUser_flag() {
        return user_flag;
    }

    public void setUser_flag(int user_flag) {
        this.user_flag = user_flag;
    }
}
