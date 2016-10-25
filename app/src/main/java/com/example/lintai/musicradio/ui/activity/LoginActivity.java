package com.example.lintai.musicradio.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lintai.musicradio.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @Bind(R.id.btn_phone)
    Button btnPhone;
    @Bind(R.id.btn_register)
    Button btnRegister;
    @Bind(R.id.tourist_trial)
    TextView touristTrial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.btn_phone, R.id.btn_register, R.id.tourist_trial})
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.btn_phone:
                 intent = new Intent(LoginActivity.this, LoginPhoneActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_register:
                 intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.tourist_trial:
                 intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}
