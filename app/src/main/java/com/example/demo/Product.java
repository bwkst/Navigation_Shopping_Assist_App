package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import android.app.Activity;
import android.widget.ImageView;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Product extends AppCompatActivity {

    private ImageView PGTPhoto;
    private final String TAG = "tag";
    //需要的权限数组 读/写/相机

    private static final String[] PERMISSIONS_STORAGE = {Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        //跳转相机动态权限
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        initView();

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

    private Uri ImageUri;
    public static final int TAKE_PHOTO = 101;

    private void initView() {
        ImageButton PGTCamera = findViewById(R.id.b_product_taking_photo);
        PGTPhoto = findViewById(R.id.b_product_taking_photo);

        PGTCamera.setOnClickListener(v -> {
            //检查是否已经获得相机的权限
            if (verifyPermissions(Product.this, PERMISSIONS_STORAGE[2]) == 0) {
                Log.i(TAG, "提示是否要授权");
                ActivityCompat.requestPermissions(Product.this, PERMISSIONS_STORAGE, 3);
            } else {
                //已经有权限
                toCamera();  //打开相机
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TAKE_PHOTO) {
            if (resultCode == RESULT_OK) {
                try {
                    //将拍摄的照片显示出来
                    Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(ImageUri));
                    PGTPhoto.setImageBitmap(bitmap);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int verifyPermissions(Activity activity, java.lang.String permission) {
        int Permission = ActivityCompat.checkSelfPermission(activity, permission);
        if (Permission == PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG, "已经同意权限");
            return 1;
        } else {
            Log.i(TAG, "没有同意权限");
            return 0;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG, "用户授权");
            toCamera();
        } else {
            Log.i(TAG, "用户未授权");
        }
    }


    //跳转相机
    private void toCamera() {
        //创建File对象，用于存储拍照后的图片
//        File outputImage = new File(getExternalCacheDir(), "outputImage.jpg");
        File outputImage = new File(getExternalCacheDir(), System.currentTimeMillis() + ".jpg");
        if (outputImage.exists()) {
            outputImage.delete();
        } else {
            try {
                outputImage.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //判断SDK版本高低，ImageUri方法不同
        ImageUri = FileProvider.getUriForFile(Product.this, "com.example.demo.uploadfile4.fileprovider", outputImage);

        //启动相机程序
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra(MediaStore.EXTRA_OUTPUT, ImageUri);
        startActivityForResult(intent, TAKE_PHOTO);
    }
}