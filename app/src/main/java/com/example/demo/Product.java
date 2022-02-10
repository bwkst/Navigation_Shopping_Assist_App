package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Product extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        //Product -> Go To Page: MainActivity
        Button PGTMainPage = findViewById(R.id.b_product_back); //定位Button: b_product_back
        PGTMainPage.setOnClickListener(v -> {
            Intent intent=new Intent();
            intent.setClass(Product.this,MainActivity.class); //跳转至MainActivity
            startActivity(intent);
        });

        //Product -> Go To Page: Setting
        Button PGTSettingPage = findViewById(R.id.b_product_setting); //定位Button: b_product_setting
        PGTSettingPage.setOnClickListener(v -> {
            Intent intent=new Intent();
            intent.setClass(Product.this,SettingAndHelp.class); //跳转至SettingAndHelp
            startActivity(intent);
        });

    }
}