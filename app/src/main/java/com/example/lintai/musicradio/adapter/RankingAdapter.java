package com.example.lintai.musicradio.adapter;

import android.content.Context;

import com.example.lintai.musicradio.R;
import com.example.lintai.musicradio.entity.RankingDB;
import com.example.lintai.musicradio.entity.RankingEntity;

import java.util.List;

/**
 * Created by LinTai on 2016/9/1.
 */
public class RankingAdapter extends SimpleBaseAdapter<RankingDB> {
    public RankingAdapter(Context context, int layoutId, List data) {
        super(context, layoutId, data);
    }

    @Override
    public void getItemView(ViewHolder holder, RankingDB data) {

        holder.setText(R.id.ranking_title, data.getTitle())
                .setImageURL(R.id.ranking_img, data.getLogo());
//                .setText(R.id.ranking_item1, data.getSongs().get(0).getSongName())
//                .setText(R.id.ranking_item1,  data.getSongs().get(1).getSongName())
//                .setText(R.id.ranking_item1, data.getSongs().get(2).getSongName())
//                .setText(R.id.ranking_item1,  data.getSongs().get(3).getSongName());
    }
}
