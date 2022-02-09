package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Go To Page: ShoppingMall
        Button GTMallPage = (Button) findViewById(R.id.b_mall); //定位Button: b_mall
        GTMallPage.setOnClickListener(v -> {
            Intent intent=new Intent();
            intent.setClass(MainActivity.this,ShoppingMall.class); //跳转至ShoppingMall
            startActivity(intent);
        });

        //Go To Page: Supermarket
        Button GTMarketPage = (Button) findViewById(R.id.b_market); //定位Button: b_market
        GTMarketPage.setOnClickListener(v -> {
            Intent intent=new Intent();
            intent.setClass(MainActivity.this,Supermarket.class); //跳转至Supermarket
            startActivity(intent);
        });

        //Go To Page: Product
        Button GTProductPage = (Button) findViewById(R.id.b_product); //定位Button: b_product
        GTProductPage.setOnClickListener(v -> {
            Intent intent=new Intent();
            intent.setClass(MainActivity.this,Product.class); //跳转至Product
            startActivity(intent);
        });

        //Go To Page: Setting
        Button GTSettingPage = (Button) findViewById(R.id.b_setting); //定位Button: b_setting
        GTSettingPage.setOnClickListener(v -> {
            Intent intent=new Intent();
            intent.setClass(MainActivity.this,SettingAndHelp.class); //跳转至SettingAndHelp
            startActivity(intent);
        });
    }
}