package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SettingAndHelp extends AppCompatActivity {

    private Button SlowSpeed; //选中后 -> 语速为慢
    private Button MidSpeed; //选中后 -> 语速为中
    private Button FastSpeed; //选中后 -> 语速为快
    private Button WomanVoiceOutput; //选中后 -> 语音为标准女声
    private Button ManVoiceOutput; //选中后 -> 语音为标准男声
    private Button FailToRead; //选中后 -> 调出“摄像头权限” (?)
    private Button Suggestion; //跳转到?页面
    private Button CustomerService; //跳转到?页面
    private Button Update; //检查更新
    private Button Back; //目前：返回主页面 期望：返回到跳转到此页面的页面（标记？）

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_and_help);

        SlowSpeed = (Button)findViewById(R.id.b_slow); //定位Button: b_slow
        //功能未做-不会做

        MidSpeed = (Button)findViewById(R.id.b_mid); //定位Button: b_mid
        //功能未做-不会做

        FastSpeed = (Button)findViewById(R.id.b_fast); //定位Button: b_fast
        //功能未做-不会做

        WomanVoiceOutput = (Button)findViewById(R.id.b_woman); //定位Button: b_woman
        //功能未做-不会做

        ManVoiceOutput = (Button)findViewById(R.id.b_man); //定位Button: b_man
        //功能未做-不会做

        FailToRead = (Button)findViewById(R.id.b_fail_to_read); //定位Button: b_fail_to_read
        //功能未做-不会做

        Suggestion = (Button)findViewById(R.id.b_suggestion); //定位Button: b_suggestion
        //功能未做-不会做

        CustomerService = (Button)findViewById(R.id.b_customer_service); //定位Button: b_customer_service
        //功能未做-不会做

        Update = (Button)findViewById(R.id.b_update); //定位Button: b_update
        //功能未做-不会做

        Back = (Button)findViewById(R.id.b_setting_back); //定位Button: b_setting_back
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(SettingAndHelp.this,MainActivity.class); //跳转至MainActivity
                startActivity(intent);
            }
        });

    }

}