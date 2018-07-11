package com.laughing.wulianwang.singleton;

/**
 * 双重检查模式（DCL） - （高并发环境下有缺陷，开销大）
 * 作者：Laughing on 2018/6/25 09:47
 * 邮箱：719240226@qq.com
 */
public class Singleton4 {
    private volatile static Singleton4 instance;

    private Singleton4() {

    }

    public static Singleton4 getInstance() {
        if (instance == null) {
            synchronized (Singleton4.class) {
                if (instance == null) {
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }

}
