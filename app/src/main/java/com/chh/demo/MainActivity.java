package com.chh.demo;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private CountdownView mCountdownView;
    private LinearLayout mSkipView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCountdownView = (CountdownView) findViewById(R.id.count_down_view);
        mSkipView = (LinearLayout) findViewById(R.id.ll_skip);
        mCountdownView.setCountNum(5);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               mCountdownView.start();
            }
        }, 3000);
        mCountdownView.setOnCountdownListener(new CountdownView.OnCountdownListener() {
            @Override
            public void onFinish() {
                Toast.makeText(MainActivity.this, "倒计时完成了", Toast.LENGTH_LONG).show();

            }
        });
        mSkipView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "点击了跳过", Toast.LENGTH_LONG).show();
            }
        });
    }
}
