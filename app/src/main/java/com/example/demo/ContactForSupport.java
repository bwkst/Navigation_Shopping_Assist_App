package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ContactForSupport extends AppCompatActivity {

    private TextView textView1;
    private TextView textView2;

    private String mailAdress = "test@gmail.com";//收信邮箱，虚拟
    private String phone = "13322224444";//虚拟电话

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_for_support);
        getSupportActionBar().hide();

        //发送邮件
        textView1 = (TextView) findViewById(R.id.text_mail_contact);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mailto:goodboy@163.com
                Uri uri = Uri.parse("mailto:"+mailAdress);
                Intent data = new Intent(Intent.ACTION_SENDTO);
                data.setData(uri);
                startActivity(Intent.createChooser(data,"请选择邮件类应用"));
                /**另一种实现方法
                * data.setData(Uri.parse("mailto:zong002230@gmail.com"));
                * data.putExtra(Intent.EXTRA_CC, "");
                * data.putExtra(Intent.EXTRA_SUBJECT, "");
                * data.putExtra(Intent.EXTRA_TEXT, "");
                * startActivity(data);
                 **/
            }
        });

        //跳转到拨号页面
        textView2 = (TextView) findViewById(R.id.text_call_contact);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.DIAL");
                Uri uri = Uri.parse("tel:" + phone);
                intent.setData(uri);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
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