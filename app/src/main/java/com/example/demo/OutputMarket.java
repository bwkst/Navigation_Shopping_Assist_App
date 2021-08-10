package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OutputMarket extends AppCompatActivity {

    private Button OMTGTMainPage; //Output Market -> Go To Page: MainActivity
    private Button OMTGTSettingPage; //Output Market -> Go To Page: Setting

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output_market);

        OMTGTMainPage = (Button)findViewById(R.id.b_end_market); //定位Button: b_end_market
        OMTGTMainPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(OutputMarket.this,MainActivity.class); //跳转至MainActivity
                startActivity(intent);
            }
        });

        OMTGTSettingPage = (Button)findViewById(R.id.b_omt_setting); //定位Button: b_omt_setting
        OMTGTSettingPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(OutputMarket.this,SettingAndHelp.class); //跳转至SettingAndHelp
                startActivity(intent);
            }
        });

    }

}