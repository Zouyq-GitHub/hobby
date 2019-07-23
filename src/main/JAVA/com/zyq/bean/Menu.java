package com.zyq.bean;


/**
 * 不同用户的列表类
 */
public class Menu {
    private int id;
    private String m_name;
    private String m_url;
    private int m_firstid;

    public Menu(int id, String m_name, String m_url, int m_firstid) {
        this.id = id;
        this.m_name = m_name;
        this.m_url = m_url;
        this.m_firstid = m_firstid;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", m_name='" + m_name + '\'' +
                ", m_url='" + m_url + '\'' +
                ", m_firstid=" + m_firstid +
                '}';
    }

    public Menu() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public String getM_url() {
        return m_url;
    }

    public void setM_url(String m_url) {
        this.m_url = m_url;
    }

    public int getM_firstid() {
        return m_firstid;
    }

    public void setM_firstid(int m_firstid) {
        this.m_firstid = m_firstid;
    }
}
