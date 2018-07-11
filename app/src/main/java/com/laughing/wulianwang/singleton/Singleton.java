package com.laughing.wulianwang.singleton;

public class Singleton {

    private Singleton() {

    }

    public static Singleton getInstance() {
        return SingletonHolder.sInstance;
    }

    public static class SingletonHolder {
        private static final Singleton sInstance = new Singleton();
    }

}