package com.example.login;

import android.app.Application;

import com.example.baselibs.BaseApplication;
import com.example.baselibs.ServiceFactory;

public class LoginApplication extends BaseApplication {
    //补充：因为不知道什么时候其他组件就会在ServiceFactory中获得这个类，所以我们上传这个接口实现类要在项目刚刚开始的时候
    //所以就在login的application中实现上传
    @Override
    public void onCreate() {
        super.onCreate();
    }
    //在这里我们完成了application的配置，接下来我们就可以使用反射的方式在app主Moudle的application类中获取Login组件的application类，执行其方法
    @Override
    public void init(Application application) {
        ServiceFactory.getInstance().setLoginService(new AccountService(LoginUtil.isLogin,LoginUtil.password));
    }

    @Override
    public void initover(Application application) {

    }
}
