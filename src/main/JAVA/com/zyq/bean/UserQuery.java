package com.zyq.bean;

import lombok.Data;

/**
 * 用户模糊查询参数
 * @author 邹雨樵
 * @date 2019/6/17
 * @since 1.0.0
 */
@Data
public class UserQuery {

    /**
     * 学生名称
     */
    private String studyName;

    /**
     * 学生性别
     */
    private String userSex;

    /**
     * 班级名称
     */
    private String className;

    /**
     * 班级编号
     */
    private String classNumb;
}