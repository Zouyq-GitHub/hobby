package com.zyq.service;

import com.zyq.bean.ClassDemo;
import com.zyq.bean.ClassName;
import com.zyq.bean.Page;
import com.zyq.dao.*;

import java.sql.SQLException;
import java.util.List;

/**
 * 班级业务层
 */
public class ClassService {
    //Dao层
    private ClassDao classDao = new ClassDao();
    //实体类
    private ClassDemo classDemo = new ClassDemo();
    //
    private ClassName className = new ClassName();

    //添加班级功能
    public boolean AddClass(ClassName className) {
        boolean isok = classDao.addRoot(className);
        return isok;
    }

    //模糊查询
    public List<ClassName> getClassList(String classNames, String ClassStatus, Page page) {
        className.setC_Name(classNames);

        if (ClassStatus != null && !"".equals(ClassStatus)) {
            int Classssstatus = Integer.parseInt(ClassStatus);
            if (Classssstatus > 0 && Classssstatus < 3) {
                className.setC_Status(Classssstatus);
            } else {
                className.setC_Status(0);
            }
        } else {
            className.setC_Status(0);
        }
        return classDao.getClassList(className, page);
    }

    //查询个数
    public int getClassCount(String classNames, String ClassStatus) {
        if (classNames != null && !"".equals(classNames)) {
            className.setC_Name(classNames);
        }
        if (ClassStatus != null && !"".equals(ClassStatus)) {
            int Classstatus = Integer.parseInt(ClassStatus);
            if (Classstatus > 0 && Classstatus < 3) {
                className.setC_Status(Classstatus);
            } else {
                className.setC_Status(0);
            }
        } else {
            className.setC_Status(0);
        }
        return classDao.getClassCount(className);
    }

    //根据ID查询
    public ClassName getClassById(String id) {
        if (id != null && !"".equals(id)) {
            return classDao.getClassById(Integer.parseInt(id));
        }
        return null;
    }

    //班级修改
    public boolean updateClass(ClassName className) {
        return classDao.updateClassById(className);
    }

    //毕业状态集合
    public List<ClassName> getStatusClassList(String classNames, String classStatus, Page page) {
        if (classNames != null && !"".equals(classNames)) {
            className.setC_Name(classNames);
        }
        if (classStatus != null && !"".equals(classStatus)) {
            int Classstatus = Integer.parseInt(classStatus);
            if (Classstatus > 0 && Classstatus < 3) {
                className.setC_Status(Classstatus);
            } else {
                className.setC_Status(0);
            }
        } else {
            className.setC_Status(0);
        }
        return classDao.getStatusClassList(className, page);
    }

    //添加新的班级类型
    public Boolean ClassFormAdd(String classForm) {
        return classDao.ClassFormAdd(classForm);
    }


    //根据ID删除班级类型
    public boolean dropClassById(String id) {
        if (null != id && !"".equals(id)) {
            return classDao.deleteClassById(Integer.parseInt(id));
        }
        return false;
    }

    //根据查询班级的类型
    public List<ClassDemo> getByidClassForm(String cform, String sexString, String classNames, String classNumb, Page page) {
        ClassDemo classDemo = new ClassDemo();
        if (cform != null && !"".equals(cform)) {
            classDemo.setC_Form(cform);
        } else {
            classDemo.setC_Form("J1111");
        }
        return classDao.getByidClassForm(classDemo, page);
    }
}