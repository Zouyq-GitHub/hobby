package com.zyq.bean;

import lombok.Data;

/**
 * @author 邹雨樵
 * @date 2019/6/13
 * @since 1.0.0
 */
@Data
public class Page {

    /**
     * 当前页数
     */
    private int page;

    /**
     * 每页显示条数
     */
    private int number;



}