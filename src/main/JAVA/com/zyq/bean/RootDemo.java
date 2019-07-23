package com.zyq.bean;

/**
 * 管理员的实体类
 */
public class RootDemo {
    private int id;
    private String r_loginName;
    private String r_PassWord;
    private String r_Name;
    private int r_roleid;

    public RootDemo() {

    }

    @Override
    public String toString() {
        return "RootDemo{" +
                "id=" + id +
                ", r_loginName='" + r_loginName + '\'' +
                ", r_PassWord='" + r_PassWord + '\'' +
                ", r_Name='" + r_Name + '\'' +
                ", r_roleid=" + r_roleid +
                '}';
    }

    public RootDemo(int id, String r_loginName, String r_PassWord, String r_Name, int r_roleid) {
        this.id = id;
        this.r_loginName = r_loginName;
        this.r_PassWord = r_PassWord;
        this.r_Name = r_Name;
        this.r_roleid = r_roleid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getR_loginName() {
        return r_loginName;
    }

    public void setR_loginName(String r_loginName) {
        this.r_loginName = r_loginName;
    }

    public String getR_PassWord() {
        return r_PassWord;
    }

    public void setR_PassWord(String r_PassWord) {
        this.r_PassWord = r_PassWord;
    }

    public String getR_Name() {
        return r_Name;
    }

    public void setR_Name(String r_Name) {
        this.r_Name = r_Name;
    }

    public int getR_roleid() {
        return r_roleid;
    }

    public void setR_roleid(int r_roleid) {
        this.r_roleid = r_roleid;
    }
}
