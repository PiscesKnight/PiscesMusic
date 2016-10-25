package com.example.lintai.musicradio.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.lintai.musicradio.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by JinBao on 2016/10/19.
 */

public class SearchActivity extends Activity {

    @Bind(R.id.back_btn)
    ImageView backBtn;
    @Bind(R.id.music_search)
    ImageView musicSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back_btn, R.id.music_search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_btn:
                finish();
                break;
            case R.id.music_search:
                break;
        }
    }
}
