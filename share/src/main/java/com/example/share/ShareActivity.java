package com.example.share;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.baselibs.ServiceFactory;

@Route(path="/share/share1")
public class ShareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        Button share_btn = findViewById(R.id.Share_button);
        share_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ServiceFactory.getInstance().getLoginService().isLogin()){
                    //如果已经存在实现类，且已经登录(true)
                    Toast.makeText(getApplicationContext(),"分享成功!",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"分享失败!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}