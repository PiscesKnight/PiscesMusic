package com.example.lintai.musicradio.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lintai.musicradio.R;
import com.youth.banner.Banner;

/**
 * Created by LinTai on 2016/8/31.
 */
public class IndexFragment extends Fragment {

    private Banner banner;
    private String[] images = new String[]{ "http://pic.xiami.net/images/common/uploadpic/26/14726094262291.jpg@1e_1c_0i_1o_100Q_1080w_472h.webp","http://pic.xiami.net/images/common/uploadpic/79/14726093791429.jpg@1e_1c_0i_1o_100Q_1080w_472h.webp","http://pic.xiami.net/images/common/uploadpic/75/14726094753749.jpg@1e_1c_0i_1o_100Q_1080w_472h.webp","http://pic.xiami.net/images/common/uploadpic/25/14725187255978.jpg@1e_1c_0i_1o_100Q_1080w_472h.webp","http://pic.xiami.net/images/common/uploadpic/82/14725256825764.jpg@1e_1c_0i_1o_100Q_1080w_472h.webp"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.index_fragment,container,false);

        init(view);
        return view;
    }

    private void init(View view){
        banner = (Banner) view.findViewById(R.id.banner);
        banner.setImages(images);
        banner.setDelayTime(3000);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("IndexFragment","onCreate");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("IndexFragment","onResume");

    }


}
