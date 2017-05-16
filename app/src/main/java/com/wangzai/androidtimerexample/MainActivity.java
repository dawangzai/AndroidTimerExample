package com.wangzai.androidtimerexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private static final String TIMER_STORE_RUSH_PURCHASE = "商城抢购倒计时";
    private static final String TIMER_CIRCLE = "圆圈倒计时";
    private static final String TIMER_CAPTCHA = "验证码倒计时";
    private LinearLayout llExamples;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findView();
        addExamples(TIMER_STORE_RUSH_PURCHASE, TIMER_CIRCLE, TIMER_CAPTCHA);
    }

    private void findView() {
        llExamples = (LinearLayout) findViewById(R.id.llExamples);
    }

    private void addExamples(String... timerNames) {
        for (String timerName : timerNames) {
            CommonLinearLayout commonLinearLayout = new CommonLinearLayout(this);
            commonLinearLayout.setTimerName(timerName);
            llExamples.addView(commonLinearLayout);
        }
    }
}
