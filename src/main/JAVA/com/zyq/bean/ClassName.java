package com.zyq.bean;

/**
 * 班级名称类
 */
public class ClassName {
    private  int id;
    private String c_Name;
    private int c_Status;


    public ClassName(int id, String c_Name, int c_Status) {
        this.id = id;
        this.c_Name = c_Name;
        this.c_Status = c_Status;
    }


    public ClassName() {

    }

    @Override
    public String toString() {
        return "ClassName{" +
                "id=" + id +
                ", c_Name='" + c_Name + '\'' +
                ", c_Status=" + c_Status +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getC_Name() {
        return c_Name;
    }

    public void setC_Name(String c_Name) {
        this.c_Name = c_Name;
    }

    public int getC_Status() {
        return c_Status;
    }

    public void setC_Status(int c_Status) {
        this.c_Status = c_Status;
    }
}
