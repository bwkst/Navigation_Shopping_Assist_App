package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Product extends AppCompatActivity {

    private Button PGTMainPage; //Product -> Go To Page: MainActivity
    private Button PGTSettingPage; //Product -> Go To Page: Setting

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        PGTMainPage = (Button)findViewById(R.id.b_product_back); //定位Button: b_product_back
        PGTMainPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(Product.this,MainActivity.class); //跳转至MainActivity
                startActivity(intent);
            }
        });

        PGTSettingPage = (Button)findViewById(R.id.b_product_setting); //定位Button: b_product_setting
        PGTSettingPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(Product.this,SettingAndHelp.class); //跳转至SettingAndHelp
                startActivity(intent);
            }
        });

    }
}