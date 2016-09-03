package com.example.lintai.musicradio.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.lintai.musicradio.R;
import com.example.lintai.musicradio.adapter.RankingAdapter;
import com.example.lintai.musicradio.entity.RankingDB;
import com.example.lintai.musicradio.entity.RankingEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LinTai on 2016/8/31.
 */
public class RankingFragment extends Fragment {

    private ListView listView;
    private RankingAdapter rankingAdapter;

    private List<RankingDB> data=null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.ranking_fragment,container,false);

        initData();

        initView(view);
        return view;
    }

    private void initView(View view){
        listView = (ListView) view.findViewById(R.id.ranking_listview);

        rankingAdapter = new RankingAdapter(getActivity(),R.layout.ranking_list_item,data);
        listView.setAdapter(rankingAdapter);
    }

    //    初始化数据
    private void initData(){
        data = new ArrayList<>();

       RankingDB rankingDB = new RankingDB();
        data.add(rankingDB);
        for (int i =0;i<10;i++) {
            rankingDB.setLogo("http://img.xiami.net/images/appv5/rank_list/ranking_list_alimusic_realtime_billboard.png");
            rankingDB.setTitle("阿里音乐周排行");
            data.add(rankingDB);
//            for (int j = 0; j <= 4; j++) {
//
//              //  rankingDB.setSongs(songses);
//
//            }

        }
    }

    private void Data(){

    }
}
