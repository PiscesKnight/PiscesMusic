package com.example.lintai.musicradio.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lintai.musicradio.R;
import com.example.lintai.musicradio.adapter.MyMusicAdapter;
import com.example.lintai.musicradio.entity.MyMusicEntity;
import com.example.lintai.musicradio.utils.view.ListViewForScrollView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by LinTai on 2016/9/4.
 */
public class MyMusicFragment extends Fragment {

    @Bind(R.id.mymusic_listview)
    ListViewForScrollView mymusicListview;


    private MyMusicAdapter adapter;

    private List<MyMusicEntity> data = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mymusic_fragment, container, false);

        ButterKnife.bind(MyMusicFragment.this, view);
        init();
        return view;

    }

    private void init() {
        data = new ArrayList<>();

        MyMusicEntity myMusicEntity = new MyMusicEntity();

        for (int i = 0; i < 10; i++) {
            myMusicEntity.setListImg("http://pic.xiami.net/images/album/img45/105945/21002735541455039917.jpg");
            myMusicEntity.setListName("我喜欢的音乐");
            myMusicEntity.setListContent("50首");
            data.add(myMusicEntity);

        }

        adapter = new MyMusicAdapter(getActivity(), R.layout.mymusic_listview_item, data);
        mymusicListview.setAdapter(adapter);
        mymusicListview.setFocusable(false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
