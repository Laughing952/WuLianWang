package com.laughing.wulianwang.singleton;

/**
 * 懒汉模式 - （线程安全:同步开销大）
 * 作者：Laughing on 2018/6/25 09:47
 * 邮箱：719240226@qq.com
 */
public class Singleton3 {
    private static Singleton3 instance;

    private Singleton3() {

    }

    public static synchronized Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }

}
