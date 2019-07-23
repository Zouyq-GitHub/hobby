package com.zyq.fliter;

/**
 * @author 邹雨樵
 * @date 2019/7/15
 * @since 1.0.0
 */
public class Interview {


    public void demo() {
        System.out.println("1");
    }
}


class Demo01 extends Interview {
    @Override
    public void demo() {
        System.out.println("2");
    }

    public void demo01() {
        System.out.println();
    }
}