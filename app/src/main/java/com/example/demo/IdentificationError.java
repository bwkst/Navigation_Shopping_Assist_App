package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class IdentificationError extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identification_error);

        //跳转到?页面
        Button SettingBack2 = findViewById(R.id.b_setting_back2); //定位Button: b_setting_back2
        SettingBack2.setOnClickListener(v -> {
            Intent intent=new Intent();
            intent.setClass(IdentificationError.this,SettingAndHelp.class); //跳转至SettingAndHelp
            startActivity(intent);
        });
    }
}