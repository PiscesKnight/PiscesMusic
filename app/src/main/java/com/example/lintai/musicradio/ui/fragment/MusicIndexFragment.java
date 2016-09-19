package com.example.lintai.musicradio.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lintai.musicradio.R;
import com.example.lintai.musicradio.adapter.FragmentAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by LinTai on 2016/8/30.
 */
public class MusicIndexFragment extends Fragment{


    @Bind(R.id.index_tab_layout)
    TabLayout indexTabLayout;
    @Bind(R.id.index_viewpager)
    ViewPager indexViewpager;

    private IndexFragment indexFragment = new IndexFragment();
    private OmnibusFragment omnibusFragment = new OmnibusFragment();
    private RankingFragment rankingFragment = new RankingFragment();
    private RadioStationFragment radioStationFragment = new RadioStationFragment();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.music_index_fragment, container, false);

        ButterKnife.bind(MusicIndexFragment.this, view);

        init();
        return view;
    }


    private void init(){
        if(indexViewpager!=null){
            //indexViewpager.setOffscreenPageLimit(1);//关闭预加载，默认一次只加载一个Fragment
            setViewPager(indexViewpager);
        }
        indexTabLayout.setupWithViewPager(indexViewpager);
    }

    /**
     * 设置ViewPager内容数据
     *
     * @param viewPager
     */
    private void setViewPager(ViewPager viewPager) {
        FragmentAdapter adapter = new FragmentAdapter(
                getChildFragmentManager()
                );
        adapter.addTitleFragemnt(new IndexFragment(), getResources().getString(R.string.index));
        adapter.addTitleFragemnt(new OmnibusFragment(), getResources().getString(R.string.songs));
        adapter.addTitleFragemnt(new RankingFragment(), getResources().getString(R.string.ranking));
        adapter.addTitleFragemnt(new RadioStationFragment(), getResources().getString(R.string.radio_station));
        viewPager.setAdapter(adapter);

    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
