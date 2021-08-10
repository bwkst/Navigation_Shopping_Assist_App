package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ConfirmMall extends AppCompatActivity {

    private Button CMLGTOutputMallPage_1; //Confirm Mall -> 取确认结果1 -> 提交后台 -> Go To Page: OutputMall
    private Button CMLGTOutputMallPage_2; //Confirm Mall -> 取确认结果2 -> 提交后台 -> Go To Page: OutputMall
    private Button CMLGTShoppingMallPage; //Confirm Mall -> Go To Page: ShoppingMall
    private Button CMLGTSettingPage; //Confirm Mall -> Go To Page: Setting

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_mall);

        CMLGTOutputMallPage_1 = (Button)findViewById(R.id.b_confirm_mall_1); //定位Button: b_confirm_mall_1
        //功能未做: 取确认结果1 -> 提交后台
        CMLGTOutputMallPage_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(ConfirmMall.this,OutputMall.class); //跳转至OutputMall
                startActivity(intent);
            }
        });

        CMLGTOutputMallPage_2 = (Button)findViewById(R.id.b_confirm_mall_2); //定位Button: b_confirm_mall_2
        //功能未做: 取确认结果1 -> 提交后台
        CMLGTOutputMallPage_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(ConfirmMall.this,OutputMall.class); //跳转至OutputMall
                startActivity(intent);
            }
        });

        CMLGTShoppingMallPage = (Button)findViewById(R.id.b_cml_back); //定位Button: b_cml_back
        CMLGTShoppingMallPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(ConfirmMall.this,ShoppingMall.class); //跳转至ShoppingMall
                startActivity(intent);
            }
        });

        CMLGTSettingPage = (Button)findViewById(R.id.b_cml_setting); //定位Button: b_cml_setting
        CMLGTSettingPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(ConfirmMall.this,SettingAndHelp.class); //跳转至SettingAndHelp
                startActivity(intent);
            }
        });

    }
}