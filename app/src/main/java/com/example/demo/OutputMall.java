package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class OutputMall extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output_mall);

        //Output Mall -> Go To Page: MainActivity
        Button OMLGTMainPage = findViewById(R.id.b_end_mall); //定位Button: b_end_mall
        OMLGTMainPage.setOnClickListener(v -> {
            Intent intent=new Intent();
            intent.setClass(OutputMall.this,MainActivity.class); //跳转至MainActivity
            startActivity(intent);
        });

        //Output Mall -> Go To Page: Setting
        Button OMLGTSettingPage = findViewById(R.id.b_oml_setting); //定位Button: b_oml_setting
        OMLGTSettingPage.setOnClickListener(v -> {
            Intent intent=new Intent();
            intent.setClass(OutputMall.this,SettingAndHelp.class); //跳转至SettingAndHelp
            startActivity(intent);
        });

    }
}