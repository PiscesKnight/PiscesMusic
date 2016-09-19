package com.example.lintai.musicradio.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lintai.musicradio.R;
import com.example.lintai.musicradio.adapter.RadioStationAdapter;
import com.example.lintai.musicradio.entity.RadioStationEntity;
import com.example.lintai.musicradio.utils.view.GridViewForScrollView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by LinTai on 2016/8/31.
 */
public class RadioStationFragment extends Fragment {

    private RadioStationAdapter adapter;

    private List<RadioStationEntity.DataBean.RadiosBean> data;

    @Bind(R.id.radio_gridview)
    GridViewForScrollView radioGridview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.radiostation_fragment, container, false);
        ButterKnife.bind(RadioStationFragment.this, view);
        init();
        return view;
    }

    private void init(){
        data = new ArrayList<>();

        RadioStationEntity.DataBean.RadiosBean radiosBean = new RadioStationEntity.DataBean.RadiosBean();

        for (int i = 0;i<10;i++){
            radiosBean.setPlay_count(401056);
            radiosBean.setRadio_logo("http://pic.xiami.net/images/common/uploadpic/67/14276864674129.jpg@1e_1c_0i_1o_100Q_189w_189h.webp");
            radiosBean.setRadio_name("学习工作");
            data.add(radiosBean);
        }


        adapter = new RadioStationAdapter(getActivity(),R.layout.radiostation_gridview_item,data);
        radioGridview.setAdapter(adapter);
        radioGridview.setFocusable(false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
