package com.wangzai.androidtimerexample.storerushpurchase;

import android.content.Context;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wangzai.androidtimerexample.R;

import java.util.Date;

/**
 * Created by wangzai on 2017/5/11.
 */
public class SnapUpTimer extends LinearLayout {
    private CountDownTimer mCountDownTimer;
    private TextView tvHourTen;
    private TextView tvMinTen;
    private TextView tvSecTen;

    public SnapUpTimer(Context context) {
        super(context);

        initView(context);
    }

    public SnapUpTimer(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public interface OnTimerStartListener {
        void onTick(long millisUntilFinished);

        void onFinish();
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_snap_up_timer, this);
        tvHourTen = (TextView) findViewById(R.id.tvHourTen);
        tvMinTen = (TextView) findViewById(R.id.tvMinTen);
        tvSecTen = (TextView) findViewById(R.id.tvSecTen);
    }

    public void start(final long millisInFuture, final long countDownInterval, final OnTimerStartListener timerStartListener) {
        setTime(millisInFuture);
        mCountDownTimer = new CountDownTimer(millisInFuture, countDownInterval) {

            @Override
            public void onTick(long millisUntilFinished) {
                Log.i("SnapUpTime", "onTick");

                setTime(millisUntilFinished);
                timerStartListener.onTick(millisUntilFinished);
            }

            @Override
            public void onFinish() {
                Log.i("SnapUpTime", "onFinish");
                setTime(0);
                timerStartListener.onFinish();
            }
        }.start();
    }

    public void cancle() {
        mCountDownTimer.cancel();
        setTime(0);
    }

    private void setTime(long millisUntilFinished) {
        long sec = millisUntilFinished / 1000;

        long showHours = sec / 60 / 60;
        long showMin = sec / 60 % 60;
        long showSec = sec % 60;
        tvHourTen.setText(String.format("%02d", showHours));
        tvMinTen.setText(String.format("%02d", showMin));
        tvSecTen.setText(String.format("%02d", showSec));
    }


}
