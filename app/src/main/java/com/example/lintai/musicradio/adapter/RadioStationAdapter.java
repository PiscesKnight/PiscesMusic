package com.example.lintai.musicradio.adapter;

import android.content.Context;

import com.example.lintai.musicradio.R;
import com.example.lintai.musicradio.entity.RadioStationEntity;

import java.util.List;

/**
 * Created by LinTai on 2016/9/4.
 */
public class RadioStationAdapter extends SimpleBaseAdapter<RadioStationEntity.DataBean.RadiosBean> {
    public RadioStationAdapter(Context context, int layoutId, List<RadioStationEntity.DataBean.RadiosBean> data) {
        super(context, layoutId, data);
    }

    @Override
    public void getItemView(ViewHolder holder, RadioStationEntity.DataBean.RadiosBean radiosBean) {
        holder.setImageURL(R.id.radiostation_img,radiosBean.getRadio_logo())
                .setText(R.id.radiostation_play_count,"当前热度:"+radiosBean.getPlay_count())
                .setText(R.id.radiostation_name,radiosBean.getRadio_name());

    }
}
