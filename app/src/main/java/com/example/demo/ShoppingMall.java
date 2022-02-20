package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.iflytek.cloud.RecognizerResult;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechRecognizer;
import com.iflytek.cloud.SpeechUtility;
import com.iflytek.cloud.ui.RecognizerDialog;
import com.iflytek.cloud.ui.RecognizerDialogListener;

import androidx.appcompat.app.AppCompatActivity;

public class ShoppingMall extends AppCompatActivity {

    //存放听写分析结果文本
    private HashMap<String, String> hashMapTexts = new LinkedHashMap<>();
    SpeechRecognizer hearer;  //听写对象
    RecognizerDialog dialog;  //讯飞提示框

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_mall);
        getSupportActionBar().hide();

        //ShoppingMall -> 打开相机
        Button MLGTCamera = findViewById(R.id.b_mall_take_photo); //定位Button: b_mall_take_photo
        //功能未做-不会做
        MLGTCamera.setOnClickListener(v -> {
            Intent intent=new Intent();
            intent.setClass(ShoppingMall.this,Map.class); //跳转至Map
            startActivity(intent);
        });

        //ShoppingMall -> 打开语音输入键盘
        Button MLGTVoiceKeyboard = findViewById(R.id.b_mall_voice_input); //定位Button: b_mall_voice_input
        TextView MLGVoiceResult = findViewById(R.id.mall_destination_box);//定位TextView：mall_destination_box
        /**语音听写功能实现**/
        // 语音配置对象初始化
        SpeechUtility.createUtility(ShoppingMall.this, SpeechConstant.APPID + "=f66cb08c");
        MLGTVoiceKeyboard.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1.创建SpeechRecognizer对象，第2个参数：本地听写时传InitListener
                hearer = SpeechRecognizer.createRecognizer( ShoppingMall.this, null);
                // 交互动画
                dialog = new RecognizerDialog(ShoppingMall.this, null);
                // 2.设置听写参数，详见《科大讯飞MSC API手册(Android)》SpeechConstant类
                hearer.setParameter(SpeechConstant.DOMAIN, "iat"); // domain:域名
                hearer.setParameter(SpeechConstant.LANGUAGE, "zh_cn");
                hearer.setParameter(SpeechConstant.ACCENT, "mandarin"); // mandarin:普通话
                hearer.setParameter(SpeechConstant.ASR_PTT, "0");//无标点

                //3.开始听写
                dialog.setListener(new RecognizerDialogListener() {  //设置对话框

                    @Override
                    public void onResult(RecognizerResult results, boolean isLast) {
                        // TODO 自动生成的方法存根
                        Log.d("Result", results.getResultString());
                        //(1) 解析 json 数据<< 一个一个分析文本 >>
                        StringBuffer strBuffer = new StringBuffer();
                        try {
                            JSONTokener tokener = new JSONTokener(results.getResultString());
                            Log.i("TAG", "Test"+results.getResultString());
                            Log.i("TAG", "Test"+results.toString());
                            JSONObject joResult = new JSONObject(tokener);

                            JSONArray words = joResult.getJSONArray("ws");
                            for (int i = 0; i < words.length(); i++) {
                                // 转写结果词，默认使用第一个结果
                                JSONArray items = words.getJSONObject(i).getJSONArray("cw");
                                JSONObject obj = items.getJSONObject(0);
                                strBuffer.append(obj.getString("w"));

                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
//            		String text = strBuffer.toString();
                        // (2)读取json结果中的sn字段
                        String sn = null;

                        try {
                            JSONObject resultJson = new JSONObject(results.getResultString());
                            sn = resultJson.optString("sn");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        //(3) 解析语音文本<< 将文本叠加成语音分析结果  >>
                        hashMapTexts.put(sn, strBuffer.toString());
                        StringBuffer resultBuffer = new StringBuffer();  //最后结果
                        for (String key : hashMapTexts.keySet()) {
                            resultBuffer.append(hashMapTexts.get(key));
                        }

                        MLGVoiceResult.setText(resultBuffer.toString());

                    }

                    @Override
                    public void onError(SpeechError error) {
                        // TODO 自动生成的方法存根
                        error.getPlainDescription(true);
                    }
                });

                dialog.show();  //显示对话框
            }
        });

        //ShoppingMall -> Go To Page: MainActivity
        Button MLGTMainPage = findViewById(R.id.b_mall_back); //定位Button: b_mall_back
        MLGTMainPage.setOnClickListener(v -> {
            Intent intent=new Intent();
            intent.setClass(ShoppingMall.this,MainActivity.class); //跳转至MainActivity
            startActivity(intent);
        });

        //ShoppingMall -> 取当前位置+目的地位置输入 -> 提交后台 -> Go To Page: ConfirmMall
        Button MLGTConfirmMallPage = findViewById(R.id.b_mall_search); //定位Button: b_mall_search
        //功能未做: 取当前位置+目的地位置输入 -> 提交后台
        MLGTConfirmMallPage.setOnClickListener(v -> {
            Intent intent=new Intent();
            intent.setClass(ShoppingMall.this,ConfirmMall.class); //跳转至ConfirmMall
            startActivity(intent);
        });

        //ShoppingMall -> Go To Page: Setting
        Button MLGTSettingPage = findViewById(R.id.b_mall_setting); //定位Button: b_mall_setting
        MLGTSettingPage.setOnClickListener(v -> {
            Intent intent=new Intent();
            intent.setClass(ShoppingMall.this,SettingAndHelp.class); //跳转至SettingAndHelp
            startActivity(intent);
        });

    }
}