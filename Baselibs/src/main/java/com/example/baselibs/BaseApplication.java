package com.example.baselibs;

import android.app.Application;

public abstract class BaseApplication extends Application {
    public abstract void init(Application application); //开始当前组件调用的方法
    public abstract void initover(Application application); //其他要调用的方法
}