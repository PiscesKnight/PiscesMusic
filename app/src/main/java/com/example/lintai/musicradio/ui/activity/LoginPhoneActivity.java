package com.example.lintai.musicradio.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lintai.musicradio.R;

/**
 * Created by LinTai on 2016/8/29.
 */
public class LoginPhoneActivity extends Activity{

    private ImageView backBtn;
    private TextView titleTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_phone);
        initView();
    }


    private void initView(){
       backBtn= (ImageView) findViewById(R.id.title_view).findViewById(R.id.btn_back);
        titleTv = (TextView) findViewById(R.id.title_view).findViewById(R.id.title_tv);

        titleTv.setText(getString(R.string.title_phoneLoagin));

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}

