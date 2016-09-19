package com.example.lintai.musicradio.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lintai.musicradio.R;

/**
 * Created by LinTai on 2016/8/29.
 */
public class RegisterActivity extends Activity {

    private ImageView backBtn;
    private TextView titleTv;
    private Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        initView();
    }

    private void initView(){
        backBtn= (ImageView) findViewById(R.id.title_view).findViewById(R.id.btn_back);
        titleTv = (TextView) findViewById(R.id.title_view).findViewById(R.id.title_tv);
        nextBtn = (Button) findViewById(R.id.next_btn);

        titleTv.setText(getString(R.string.title_phoneRegister));

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RegisterActivity.this,"没有下一步呐！！",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
