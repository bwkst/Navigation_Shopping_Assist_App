package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Supermarket extends AppCompatActivity {

    private Button MTGTCamera; //Supermarket -> 打开相机
    private Button MTGTVoiceKeyboard; //Supermarket -> 打开语音输入键盘
    private Button MTGTMainPage; //Supermarket -> Go To Page: MainActivity
    private Button MTGTConfirmMallPage; //Supermarket -> 取当前位置+目的地位置输入 -> 提交后台 -> Go To Page: ConfirmMarket
    private Button MTGTSettingPage; //Supermarket -> Go To Page: Setting

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supermarket);

        MTGTCamera = (Button)findViewById(R.id.b_market_take_photo); //定位Button: b_market_take_photo
        //功能未做-不会做

        MTGTVoiceKeyboard = (Button)findViewById(R.id.b_market_voice_input); //定位Button: b_market_voice_input
        //功能未做-不会做

        MTGTMainPage = (Button)findViewById(R.id.b_market_back); //定位Button: b_market_back
        MTGTMainPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(Supermarket.this,MainActivity.class); //跳转至MainActivity
                startActivity(intent);
            }
        });

        MTGTConfirmMallPage = (Button)findViewById(R.id.b_market_search); //定位Button: b_market_search
        //功能未做: 取当前位置+目的地位置输入 -> 提交后台
        MTGTConfirmMallPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(Supermarket.this,ConfirmMarket.class); //跳转至ConfirmMarket
                startActivity(intent);
            }
        });

        MTGTSettingPage = (Button)findViewById(R.id.b_market_setting); //定位Button: b_market_setting
        MTGTSettingPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(Supermarket.this,SettingAndHelp.class); //跳转至SettingAndHelp
                startActivity(intent);
            }
        });

    }
}