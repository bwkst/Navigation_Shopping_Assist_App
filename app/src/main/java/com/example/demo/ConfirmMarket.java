package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ConfirmMarket extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_market);
    //    getSupportActionBar().hide();

        //Confirm Market -> 取确认结果1 -> 提交后台 -> Go To Page: OutputMarket
        Button CMTGTOutputMarketPage_1 = findViewById(R.id.b_confirm_market_1); //定位Button: b_confirm_market_1
        //功能未做: 取确认结果1 -> 提交后台
        CMTGTOutputMarketPage_1.setOnClickListener(v -> {
            Intent intent=new Intent();
            intent.setClass(ConfirmMarket.this,OutputMarket.class); //跳转至OutputMarket
            startActivity(intent);
        });

        //Confirm Market -> 取确认结果2 -> 提交后台 -> Go To Page: OutputMarket
        Button CMTGTOutputMarketPage_2 = findViewById(R.id.b_confirm_market_2); //定位Button: b_confirm_market_2
        //功能未做: 取确认结果2 -> 提交后台
        CMTGTOutputMarketPage_2.setOnClickListener(v -> {
            Intent intent=new Intent();
            intent.setClass(ConfirmMarket.this,OutputMarket.class); //跳转至OutputMarket
            startActivity(intent);
        });

        //Confirm Market -> Go To Page: Supermarket
        Button CMTGTSupermarketPage = findViewById(R.id.b_cmt_back); //定位Button: b_cmt_back
        CMTGTSupermarketPage.setOnClickListener(v -> {
            Intent intent=new Intent();
            intent.setClass(ConfirmMarket.this,Supermarket.class); //跳转至Supermarket
            startActivity(intent);
        });

        //Confirm Market -> Go To Page: Setting
        Button CMTGTSettingPage = findViewById(R.id.b_cmt_setting); //定位Button: b_cmt_setting
        CMTGTSettingPage.setOnClickListener(v -> {
            Intent intent=new Intent();
            intent.setClass(ConfirmMarket.this,SettingAndHelp.class); //跳转至SettingAndHelp
            startActivity(intent);
        });

    }
}