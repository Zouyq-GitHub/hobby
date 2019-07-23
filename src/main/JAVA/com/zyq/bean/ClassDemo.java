package com.zyq.bean;

/**
 * 班级实体类
 */
public class ClassDemo {

    private int id;
    private String c_Form;

    public ClassDemo(int id, String c_Form) {
        this.id = id;
        this.c_Form = c_Form;
    }

    @Override
    public String toString() {
        return "ClassDemo{" +
                "id=" + id +
                ", c_Form='" + c_Form + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getC_Form() {
        return c_Form;
    }

    public void setC_Form(String c_Form) {
        this.c_Form = c_Form;
    }

    public ClassDemo() {

    }
}
