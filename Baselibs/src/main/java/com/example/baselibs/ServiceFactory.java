package com.example.baselibs;

public class ServiceFactory {
    //1.接口对象(不可以实例化new)
    private LoginService loginService;
    //2.无参构造方法(私有，不让外界获得ServiceFactory对象)
    private ServiceFactory(){}
    //通过静态内部类来构造一个单例类ServiceFactory
    //由于ServiceFactory包含这登录信息这种重要的唯一信息，所以全局可以只有一个ServiceFactory
    public static ServiceFactory getInstance(){
        return  Inner.serviceFactory;
    }
    private static class Inner{
        private static ServiceFactory serviceFactory = new ServiceFactory();
    }
    //3.获取对应数据的实现类以及上传实现类
    public void setLoginService(LoginService loginService){
        this.loginService = loginService;
    }
    public LoginService getLoginService(){
        //如果login组件并没有上传实现类
        if(loginService == null){
            return new EmptyService();
        }else{
            return loginService;
        }
    }
}
