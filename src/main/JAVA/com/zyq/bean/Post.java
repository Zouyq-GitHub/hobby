package com.zyq.bean;

/**
 * 角色对象
 */

public class Post {
    private int id;
    //角色名称
    private String u_name;



    public Post() {

    }

    public Post(int id, String u_name) {
        this.id = id;
        this.u_name = u_name;
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
}