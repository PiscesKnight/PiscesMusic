package com.example.lintai.musicradio.adapter;

import android.content.Context;

import com.example.lintai.musicradio.R;
import com.example.lintai.musicradio.entity.MyMusicEntity;

import java.util.List;

/**
 * Created by LinTai on 2016/9/4.
 */
public class MyMusicAdapter extends SimpleBaseAdapter<MyMusicEntity> {
    public MyMusicAdapter(Context context, int layoutId, List<MyMusicEntity> data) {
        super(context, layoutId, data);
    }

    @Override
    public void getItemView(ViewHolder holder, MyMusicEntity myMusicEntity) {
        holder.setImageURL(R.id.mymusic_img,myMusicEntity.getListImg())
                .setText(R.id.mymusic_title,myMusicEntity.getListName())
                .setText(R.id.mymusic_content,myMusicEntity.getListContent());
    }
}
