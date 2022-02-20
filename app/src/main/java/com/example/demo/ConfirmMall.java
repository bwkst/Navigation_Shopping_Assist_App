package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ConfirmMall extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_mall);
        getSupportActionBar().hide();

        //Confirm Mall -> 取确认结果1 -> 提交后台 -> Go To Page: OutputMall
        Button CMLGTOutputMallPage_1 = findViewById(R.id.b_confirm_mall_1); //定位Button: b_confirm_mall_1
        //功能未做: 取确认结果1 -> 提交后台
        CMLGTOutputMallPage_1.setOnClickListener(v -> {
            Intent intent=new Intent();
            intent.setClass(ConfirmMall.this,OutputMall.class); //跳转至OutputMall
            startActivity(intent);
        });

        //Confirm Mall -> 取确认结果2 -> 提交后台 -> Go To Page: OutputMall
        Button CMLGTOutputMallPage_2 = findViewById(R.id.b_confirm_mall_2); //定位Button: b_confirm_mall_2
        //功能未做: 取确认结果1 -> 提交后台
        CMLGTOutputMallPage_2.setOnClickListener(v -> {
            Intent intent=new Intent();
            intent.setClass(ConfirmMall.this,OutputMall.class); //跳转至OutputMall
            startActivity(intent);
        });

        //Confirm Mall -> Go To Page: ShoppingMall
        Button CMLGTShoppingMallPage = findViewById(R.id.b_cml_back); //定位Button: b_cml_back
        CMLGTShoppingMallPage.setOnClickListener(v -> {
            Intent intent=new Intent();
            intent.setClass(ConfirmMall.this,ShoppingMall.class); //跳转至ShoppingMall
            startActivity(intent);
        });

        //Confirm Mall -> Go To Page: Setting
        Button CMLGTSettingPage = findViewById(R.id.b_cml_setting); //定位Button: b_cml_setting
        CMLGTSettingPage.setOnClickListener(v -> {
            Intent intent=new Intent();
            intent.setClass(ConfirmMall.this,SettingAndHelp.class); //跳转至SettingAndHelp
            startActivity(intent);
        });

    }
}