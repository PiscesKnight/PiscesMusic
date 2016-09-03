package com.example.lintai.musicradio.adapter;

import android.content.Context;

import com.example.lintai.musicradio.R;
import com.example.lintai.musicradio.entity.OmnibusEntity;

import java.util.List;

/**
 * Created by LinTai on 2016/9/2.
 */
public class OmnibusAdapter extends SimpleBaseAdapter<OmnibusEntity.DataBean.CollectsBean> {
    public OmnibusAdapter(Context context, int layoutId, List<OmnibusEntity.DataBean.CollectsBean> data) {
        super(context, layoutId, data);
    }

    @Override
    public void getItemView(ViewHolder holder, OmnibusEntity.DataBean.CollectsBean collectsBean) {
            holder.setImageURL(R.id.omnibus_img,collectsBean.getCollect_logo())
            .setText(R.id.omnibus_play_count,collectsBean.getPlay_count()+"万")
            .setText(R.id.omnibus_username,collectsBean.getUser_name())
            .setText(R.id.omnibus_name,collectsBean.getCollect_name());
    }
}
