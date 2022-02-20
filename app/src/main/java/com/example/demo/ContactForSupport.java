package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class ContactForSupport extends AppCompatActivity {

    private final String mailAddress = "test@gmail.com";//收信邮箱，虚拟
    private final String phone = "13322224444";//虚拟电话

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_for_support);
        Objects.requireNonNull(getSupportActionBar()).hide();

        //发送邮件
        TextView textView1 = findViewById(R.id.text_mail_contact);
        textView1.setOnClickListener(v -> {
            //mailto:goodboy@163.com
            Uri uri = Uri.parse("mailto:"+mailAddress);
            Intent data = new Intent(Intent.ACTION_SENDTO);
            data.setData(uri);
            startActivity(Intent.createChooser(data,"请选择邮件类应用"));
        });

        //跳转到拨号页面
        TextView textView2 = findViewById(R.id.text_call_contact);
        textView2.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.DIAL");
            Uri uri = Uri.parse("tel:" + phone);
            intent.setData(uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        });

        //跳转到?页面
        Button SettingBack3 = findViewById(R.id.b_setting_back3); //定位Button: b_setting_back2
        SettingBack3.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClass(ContactForSupport.this, SettingAndHelp.class); //跳转至SettingAndHelp
            startActivity(intent);
        });
    }
}