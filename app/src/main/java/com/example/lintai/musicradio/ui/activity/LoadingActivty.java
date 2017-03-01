package com.example.lintai.musicradio.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.lintai.musicradio.R;

/**
 * Created by JinBao on 2017/2/13.
 */

public class LoadingActivty extends Activity {

    //延迟三秒
    private static final long SPLASH_DELAY_MILLIS=1600;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startMainActivity();
            }
        },SPLASH_DELAY_MILLIS );
    }

    private void startMainActivity() {
        Intent intent = new Intent(LoadingActivty.this,MainActivity.class);
        startActivity(intent);
        this.finish();
    }
}
