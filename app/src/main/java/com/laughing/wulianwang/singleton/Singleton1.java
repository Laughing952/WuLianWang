package com.laughing.wulianwang.singleton;

/**
 * 饿汉模式 - 避免了多线程的同步问题
 * 作者：Laughing on 2018/6/25 09:47
 * 邮箱：719240226@qq.com
 */
public class Singleton1 {
    private static Singleton1 instance = new Singleton1();

    private Singleton1() {

    }

    public static Singleton1 getInstance() {
        return instance;
    }

}
