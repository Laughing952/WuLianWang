package com.laughing.wulianwang.singleton;

/**
 * 静态内部类单例模式 - （线程安全）
 * 作者：Laughing on 2018/6/25 09:47
 * 邮箱：719240226@qq.com
 */
public class Singleton5 {

    private Singleton5() {

    }

    public static Singleton5 getInstance() {
        return SingletonHolder.sInstance;
    }

    public static class SingletonHolder {
        private static final Singleton5 sInstance = new Singleton5();
    }

}
