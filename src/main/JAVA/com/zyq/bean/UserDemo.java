package com.zyq.bean;

/**
 * 用户数据类
 */

public class UserDemo {
    private int id;
    private String u_name;
    /* private String u_loginName;
     private String u_password;*/
    private String u_class;
    private String u_classnumb;
    private int u_sex;
    private String u_status;
    private int u_roleid;

    public UserDemo(int id, String u_name,  String u_class, String u_classnumb, int u_sex, String u_status, int u_roleid) {
        this.id = id;
        this.u_name = u_name;
        this.u_class = u_class;
        this.u_classnumb = u_classnumb;
        this.u_sex = u_sex;
        this.u_status = u_status;
        this.u_roleid = u_roleid;
    }

    public UserDemo() {

    }

    @Override
    public String toString() {
        return "UserDemo{" +
                "id=" + id +
                ", u_name='" + u_name + '\'' +

                ", u_class='" + u_class + '\'' +
                ", u_classnumb='" + u_classnumb + '\'' +
                ", u_sex=" + u_sex +
                ", u_status='" + u_status + '\'' +
                ", u_roleid=" + u_roleid +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }



    public String getU_class() {
        return u_class;
    }

    public void setU_class(String u_class) {
        this.u_class = u_class;
    }

    public String getU_classnumb() {
        return u_classnumb;
    }

    public void setU_classnumb(String u_classnumb) {
        this.u_classnumb = u_classnumb;
    }

    public int getU_sex() {
        return u_sex;
    }

    public void setU_sex(int u_sex) {
        this.u_sex = u_sex;
    }

    public String getU_status() {
        return u_status;
    }

    public void setU_status(String u_status) {
        this.u_status = u_status;
    }

    public int getU_roleid() {
        return u_roleid;
    }

    public void setU_roleid(int u_roleid) {
        this.u_roleid = u_roleid;
    }
}