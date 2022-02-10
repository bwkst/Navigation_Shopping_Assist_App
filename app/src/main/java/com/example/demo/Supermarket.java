package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Supermarket extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supermarket);

        //Supermarket -> 打开相机
        Button MTGTCamera = findViewById(R.id.b_market_take_photo); //定位Button: b_market_take_photo
        //功能未做-不会做

        //Supermarket -> 打开语音输入键盘
        Button MTGTVoiceKeyboard = findViewById(R.id.b_market_voice_input); //定位Button: b_market_voice_input
        //功能未做-不会做

        //Supermarket -> Go To Page: MainActivity
        Button MTGTMainPage = findViewById(R.id.b_market_back); //定位Button: b_market_back
        MTGTMainPage.setOnClickListener(v -> {
            Intent intent=new Intent();
            intent.setClass(Supermarket.this,MainActivity.class); //跳转至MainActivity
            startActivity(intent);
        });

        //Supermarket -> 取当前位置+目的地位置输入 -> 提交后台 -> Go To Page: ConfirmMarket
        Button MTGTConfirmMallPage = findViewById(R.id.b_market_search); //定位Button: b_market_search
        //功能未做: 取当前位置+目的地位置输入 -> 提交后台
        MTGTConfirmMallPage.setOnClickListener(v -> {
            Intent intent=new Intent();
            intent.setClass(Supermarket.this,ConfirmMarket.class); //跳转至ConfirmMarket
            startActivity(intent);
        });

        //Supermarket -> Go To Page: Setting
        Button MTGTSettingPage = findViewById(R.id.b_market_setting); //定位Button: b_market_setting
        MTGTSettingPage.setOnClickListener(v -> {
            Intent intent=new Intent();
            intent.setClass(Supermarket.this,SettingAndHelp.class); //跳转至SettingAndHelp
            startActivity(intent);
        });

    }
}