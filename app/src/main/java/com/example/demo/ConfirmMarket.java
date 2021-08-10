package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ConfirmMarket extends AppCompatActivity {

    private Button CMTGTOutputMarketPage_1; //Confirm Market -> 取确认结果1 -> 提交后台 -> Go To Page: OutputMarket
    private Button CMTGTOutputMarketPage_2; //Confirm Market -> 取确认结果2 -> 提交后台 -> Go To Page: OutputMarket
    private Button CMTGTSupermarketPage; //Confirm Market -> Go To Page: Supermarket
    private Button CMTGTSettingPage; //Confirm Market -> Go To Page: Setting

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_market);

        CMTGTOutputMarketPage_1 = (Button)findViewById(R.id.b_confirm_market_1); //定位Button: b_confirm_market_1
        //功能未做: 取确认结果1 -> 提交后台
        CMTGTOutputMarketPage_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(ConfirmMarket.this,OutputMarket.class); //跳转至OutputMarket
                startActivity(intent);
            }
        });

        CMTGTOutputMarketPage_2 = (Button)findViewById(R.id.b_confirm_market_2); //定位Button: b_confirm_market_2
        //功能未做: 取确认结果1 -> 提交后台
        CMTGTOutputMarketPage_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(ConfirmMarket.this,OutputMarket.class); //跳转至OutputMarket
                startActivity(intent);
            }
        });

        CMTGTSupermarketPage = (Button)findViewById(R.id.b_cmt_back); //定位Button: b_cmt_back
        CMTGTSupermarketPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(ConfirmMarket.this,Supermarket.class); //跳转至Supermarket
                startActivity(intent);
            }
        });

        CMTGTSettingPage = (Button)findViewById(R.id.b_cmt_setting); //定位Button: b_cmt_setting
        CMTGTSettingPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(ConfirmMarket.this,SettingAndHelp.class); //跳转至SettingAndHelp
                startActivity(intent);
            }
        });

    }
}