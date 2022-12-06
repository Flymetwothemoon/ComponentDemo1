package com.example.componentdemo;

import android.app.Application;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.baselibs.AppConfig;
import com.example.baselibs.BaseApplication;
public class MainApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            Log.d("hello","1");
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this); // 尽可能早，推荐在Application中初始化ARouter
        init(this);
        initover(this);
    }



    @Override
    public void init(Application application) {
        for(String moduleApp : AppConfig.moduleApps){
            try{
                Class clazz = Class.forName(moduleApp);
                BaseApplication baseApplication = null;
                baseApplication = (BaseApplication) clazz.newInstance();
                baseApplication.init(this);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void initover(Application application) {
        for(String moduleApp : AppConfig.moduleApps){
            try {
                Class clazz = Class.forName(moduleApp);
                BaseApplication baseApplication = null;
                baseApplication = (BaseApplication) clazz.newInstance();
                baseApplication.initover(this);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
