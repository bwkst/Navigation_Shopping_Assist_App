package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button GTMallPage; //Go To Page: ShoppingMall
    private Button GTMarketPage; //Go To Page: Supermarket
    private Button GTProductPage; //Go To Page: Product
    private Button GTSettingPage; //Go To Page: Setting

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GTMallPage = (Button)findViewById(R.id.b_mall); //定位Button: b_mall
        GTMallPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,ShoppingMall.class); //跳转至ShoppingMall
                startActivity(intent);
            }
        });

        GTMarketPage = (Button)findViewById(R.id.b_market); //定位Button: b_market
        GTMarketPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,Supermarket.class); //跳转至Supermarket
                startActivity(intent);
            }
        });

        GTProductPage = (Button)findViewById(R.id.b_product); //定位Button: b_product
        GTProductPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,Product.class); //跳转至Product
                startActivity(intent);
            }
        });

        GTSettingPage = (Button)findViewById(R.id.b_setting); //定位Button: b_setting
        GTSettingPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,SettingAndHelp.class); //跳转至SettingAndHelp
                startActivity(intent);
            }
        });
    }
}