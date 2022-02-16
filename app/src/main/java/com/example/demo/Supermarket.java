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

public class Supermarket extends AppCompatActivity {

    //存放听写分析结果文本
    private final HashMap<String, String> hashMapTexts = new LinkedHashMap<>();
    SpeechRecognizer hearer;  //听写对象
    RecognizerDialog dialog;  //讯飞提示框

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supermarket);

        //Supermarket -> 打开相机
        Button MTGTCamera = findViewById(R.id.b_market_take_photo); //定位Button: b_market_take_photo
        //功能未做-不会做
        MTGTCamera.setOnClickListener(v -> {
            Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(intent);
        });

        //Supermarket -> 打开语音输入键盘
        Button MTGTVoiceKeyboard = findViewById(R.id.b_market_voice_input); //定位Button: b_market_voice_input
        TextView MTGVoiceResult = findViewById(R.id.market_destination_box);//定位TextView：market_destination_box
        /***语音听写功能实现***/
        // 语音配置对象初始化
        SpeechUtility.createUtility(Supermarket.this, SpeechConstant.APPID + "=f66cb08c");
        MTGTVoiceKeyboard.setOnClickListener(v -> {
            // 1.创建SpeechRecognizer对象，第2个参数：本地听写时传InitListener
            hearer = SpeechRecognizer.createRecognizer( Supermarket.this, null);
            // 交互动画
            dialog = new RecognizerDialog(Supermarket.this, null);
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
                    StringBuilder strBuffer = new StringBuilder();
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
                    StringBuilder resultBuffer = new StringBuilder();  //最后结果
                    for (String key : hashMapTexts.keySet()) {
                        resultBuffer.append(hashMapTexts.get(key));
                    }

                    MTGVoiceResult.setText(resultBuffer.toString());

                }

                @Override
                public void onError(SpeechError error) {
                    // TODO 自动生成的方法存根
                    error.getPlainDescription(true);
                }
            });

            dialog.show();  //显示对话框
        });

        //Supermarket -> Go To Page: MainActivity
        Button MTGTMainPage = findViewById(R.id.b_market_back); //定位Button: b_market_back
        MTGTMainPage.setOnClickListener(v -> {
            Intent intent=new Intent();
            intent.setClass(Supermarket.this,MainActivity.class); //跳转至MainActivity
            startActivity(intent);
        });

        //Supermarket -> 取当前位置+目的地位置输入 -> 提交后台 -> Go To Page: ConfirmMarket
        Button MTGTConfirmMallPage = findViewById(R.id.b_market_search); //定位Button: b_market_search
        //功能未做: 取当前位置+目的地位置输入 -> 提交后台
        MTGTConfirmMallPage.setOnClickListener(v -> {
            Intent intent=new Intent();
            intent.setClass(Supermarket.this,ConfirmMarket.class); //跳转至ConfirmMarket
            startActivity(intent);
        });

        //Supermarket -> Go To Page: Setting
        Button MTGTSettingPage = findViewById(R.id.b_market_setting); //定位Button: b_market_setting
        MTGTSettingPage.setOnClickListener(v -> {
            Intent intent=new Intent();
            intent.setClass(Supermarket.this,SettingAndHelp.class); //跳转至SettingAndHelp
            startActivity(intent);
        });

    }
}