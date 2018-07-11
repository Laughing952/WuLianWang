package com.laughing.wulianwang.singleton;

/**
 * 懒汉模式 - （线程不安全:多线程时不能正常工作）
 * 作者：Laughing on 2018/6/25 09:47
 * 邮箱：719240226@qq.com
 */
public class Singleton2 {
    private static Singleton2 instance;

    private Singleton2() {

    }

    public static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
    
}
