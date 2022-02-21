package com.example.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Product extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        //Product -> 打开相机
        Button PGTCamera = findViewById(R.id.b_product_taking_photo); //定位Button: b_market_take_photo
        //功能未做-不会做
        PGTCamera.setOnClickListener(v -> {
            Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(intent);
        });

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