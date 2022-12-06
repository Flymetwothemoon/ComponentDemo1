package com.example.login;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.baselibs.ServiceFactory;

import org.greenrobot.eventbus.EventBus;

import eventbus.EventMessage;

@Route(path="/login/login1")
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button login_btn = findViewById(R.id.Login_btn);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //2.将状态和用户信息上传到工具类
                LoginUtil.isLogin = true;
                LoginUtil.password = "admin";

                //3.将实现类上传到ServiceFactory  2.5.将工具类中的数据作为参数上传到接口实现类
                ServiceFactory.getInstance().setLoginService(new AccountService(LoginUtil.isLogin,LoginUtil.password));


                //这里是第二个:发送EventBus
                EventBus.getDefault().postSticky(new EventMessage(LoginUtil.password));
                Log.d("Ning","postMessage");
            }
        });
    }
}