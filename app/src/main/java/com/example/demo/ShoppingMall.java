package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ShoppingMall extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_mall);

        //ShoppingMall -> 打开相机
        Button MLGTCamera = findViewById(R.id.b_mall_take_photo); //定位Button: b_mall_take_photo
        //功能未做-不会做
        MLGTCamera.setOnClickListener(v -> {
            Intent intent=new Intent();
            intent.setClass(ShoppingMall.this,Map.class); //跳转至Map
            startActivity(intent);
        });

        //ShoppingMall -> 打开语音输入键盘
        Button MLGTVoiceKeyboard = findViewById(R.id.b_mall_voice_input); //定位Button: b_mall_voice_input
        //功能未做-不会做

        //ShoppingMall -> Go To Page: MainActivity
        Button MLGTMainPage = findViewById(R.id.b_mall_back); //定位Button: b_mall_back
        MLGTMainPage.setOnClickListener(v -> {
            Intent intent=new Intent();
            intent.setClass(ShoppingMall.this,MainActivity.class); //跳转至MainActivity
            startActivity(intent);
        });

        //ShoppingMall -> 取当前位置+目的地位置输入 -> 提交后台 -> Go To Page: ConfirmMall
        Button MLGTConfirmMallPage = findViewById(R.id.b_mall_search); //定位Button: b_mall_search
        //功能未做: 取当前位置+目的地位置输入 -> 提交后台
        MLGTConfirmMallPage.setOnClickListener(v -> {
            Intent intent=new Intent();
            intent.setClass(ShoppingMall.this,ConfirmMall.class); //跳转至ConfirmMall
            startActivity(intent);
        });

        //ShoppingMall -> Go To Page: Setting
        Button MLGTSettingPage = findViewById(R.id.b_mall_setting); //定位Button: b_mall_setting
        MLGTSettingPage.setOnClickListener(v -> {
            Intent intent=new Intent();
            intent.setClass(ShoppingMall.this,SettingAndHelp.class); //跳转至SettingAndHelp
            startActivity(intent);
        });

    }
}