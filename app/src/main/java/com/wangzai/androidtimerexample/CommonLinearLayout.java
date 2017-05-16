package com.wangzai.androidtimerexample;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @author：cleverzheng
 * @date：2017/5/10:21:07
 * @email：zhengwang043@gmail.com
 * @description：
 */

public class CommonLinearLayout extends LinearLayout {

    private TextView tvTimeName;

    public CommonLinearLayout(Context context) {
        super(context);
        initView(context);
    }

    public CommonLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_common_linearlayout, null, false);
        tvTimeName = (TextView) view.findViewById(R.id.tvTimeName);

        addView(view);
    }

    public void setTimerName(String name) {
        if (tvTimeName != null && name != null) {
            tvTimeName.setText(name);
        }
    }
}
