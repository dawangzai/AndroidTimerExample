package com.wangzai.androidtimerexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.wangzai.androidtimerexample.storerushpurchase.StoreRushPurchaseActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findView();
    }

    private void findView() {
        findViewById(R.id.llExamples);
        findViewById(R.id.tvStoreRushPurchase).setOnClickListener(this);
        findViewById(R.id.tvCircle).setOnClickListener(this);
        findViewById(R.id.tvCaptcha).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvStoreRushPurchase:
                Intent storeRushPurchaseIntent = new Intent(this, StoreRushPurchaseActivity.class);
                startActivity(storeRushPurchaseIntent);
                break;
            case R.id.tvCircle:
                Intent circleIntent = new Intent(this, CircleActivity.class);
                startActivity(circleIntent);
                break;
            case R.id.tvCaptcha:
                Intent captchaIntent = new Intent(this, CaptchaActivity.class);
                startActivity(captchaIntent);
                break;
        }
    }
}
