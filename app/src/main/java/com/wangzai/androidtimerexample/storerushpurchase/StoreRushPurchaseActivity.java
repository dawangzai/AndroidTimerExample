package com.wangzai.androidtimerexample.storerushpurchase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import com.wangzai.androidtimerexample.R;

/**
 * Created by wangzai on 2017/5/17.
 */

public class StoreRushPurchaseActivity extends AppCompatActivity implements View.OnClickListener {
    private SnapUpTimer sut;
    private EditText etDuration;
    private ImageView ivStart;
    private ImageView ivStop;
    private ViewSwitcher vsStart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_rush_purchase);

        findView();
    }

    private void findView() {
        sut = (SnapUpTimer) findViewById(R.id.sut);
        etDuration = (EditText) findViewById(R.id.etDuration);
        ivStart = (ImageView) findViewById(R.id.ivStart);
        ivStart.setOnClickListener(this);
        vsStart = (ViewSwitcher) findViewById(R.id.vsStart);
        ivStop = (ImageView) findViewById(R.id.ivStop);
        ivStop.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ivStart) {
            vsStart.setDisplayedChild(1);
            String str = "";
            str = etDuration.getText().toString().trim();
            if (str.equals("")) {
                startTimer(10);
            } else {
                startTimer(Long.valueOf(str));
            }
            etDuration.setVisibility(View.INVISIBLE);
        } else if (v.getId() == R.id.ivStop) {
            vsStart.setDisplayedChild(0);
            sut.cancle();
            etDuration.setVisibility(View.VISIBLE);
        }
    }

    private void startTimer(long duration) {

        sut.start(duration * 1000, 1000, new SnapUpTimer.OnTimerStartListener() {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                vsStart.setDisplayedChild(0);
                etDuration.setVisibility(View.VISIBLE);
            }
        });
    }
}
