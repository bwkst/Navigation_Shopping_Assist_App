package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OutputMall extends AppCompatActivity {

    private Button OMLGTMainPage; //Output Mall -> Go To Page: MainActivity
    private Button OMLGTSettingPage; //Output Mall -> Go To Page: Setting

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output_mall);

        OMLGTMainPage = (Button)findViewById(R.id.b_end_mall); //定位Button: b_end_mall
        OMLGTMainPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(OutputMall.this,MainActivity.class); //跳转至MainActivity
                startActivity(intent);
            }
        });

        OMLGTSettingPage = (Button)findViewById(R.id.b_oml_setting); //定位Button: b_oml_setting
        OMLGTSettingPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(OutputMall.this,SettingAndHelp.class); //跳转至SettingAndHelp
                startActivity(intent);
            }
        });

    }
}