package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class OutputMarket extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output_market);
        getSupportActionBar().hide();

        //Output Market -> Go To Page: MainActivity
        Button OMTGTMainPage = findViewById(R.id.b_end_market); //定位Button: b_end_market
        OMTGTMainPage.setOnClickListener(v -> {
            Intent intent=new Intent();
            intent.setClass(OutputMarket.this,MainActivity.class); //跳转至MainActivity
            startActivity(intent);
        });

        //Output Market -> Go To Page: Setting
        Button OMTGTSettingPage = findViewById(R.id.b_omt_setting); //定位Button: b_omt_setting
        OMTGTSettingPage.setOnClickListener(v -> {
            Intent intent=new Intent();
            intent.setClass(OutputMarket.this,SettingAndHelp.class); //跳转至SettingAndHelp
            startActivity(intent);
        });

    }

}