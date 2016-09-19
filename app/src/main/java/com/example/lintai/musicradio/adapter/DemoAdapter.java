package com.example.lintai.musicradio.adapter;

import android.content.Context;

import com.example.lintai.musicradio.R;
import com.example.lintai.musicradio.entity.FindEntity;

import java.util.List;

/**
 * Created by LinTai on 2016/9/13.
 */
public class DemoAdapter extends IndexTestAdapter<FindEntity.DataBean.ListBean> {


    public DemoAdapter(Context context, int typeCount, List<Integer> layoutId, List<FindEntity.DataBean.ListBean> dataList, List<String> itemType, List<String> dataGetType) {
        super(context, typeCount, layoutId, dataList, itemType, dataGetType);
    }

    @Override
    public void getItemView(ViewHolder viewHolder, FindEntity.DataBean.ListBean collectBean) {
        viewHolder.setText(R.id.find_play_count,collectBean.getCollect().getPlay_count()+"万")
        .setImageURL(R.id.find_imageview,collectBean.getCollect().getCollect_logo())
        .setText(R.id.find_title,collectBean.getCollect().getCollect_name())
        .setText(R.id.find_author,collectBean.getCollect().getAuthor_name())
        .setText(R.id.find_content,collectBean.getCollect().getDescription());
    }
}
