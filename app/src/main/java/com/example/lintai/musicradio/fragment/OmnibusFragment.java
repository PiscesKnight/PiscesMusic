package com.example.lintai.musicradio.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.lintai.musicradio.R;
import com.example.lintai.musicradio.adapter.OmnibusAdapter;
import com.example.lintai.musicradio.entity.OmnibusEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by LinTai on 2016/8/31.
 */
public class OmnibusFragment extends Fragment {

    @Bind(R.id.omnibus_gridview)
    GridView omnibusGridview;
    private List<OmnibusEntity.DataBean.CollectsBean> data = null;

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

         view = inflater.inflate(R.layout.omnibus_fragment, container, false);
        ButterKnife.bind(OmnibusFragment.this,view);
        init();

        return view;
    }

    private void init() {
        data = new ArrayList<>();

        OmnibusEntity.DataBean.CollectsBean entity = new OmnibusEntity.DataBean.CollectsBean();
        for (int i = 0; i <= 10; i++) {
            entity.setCollect_logo("http://pic.xiami.net/images/collect/591/91/8575591_1322359739.jpg@1e_1c_0i_1o_100Q_324w_324h.webp");
            entity.setCollect_name("50首让人安静的钢琴曲");
            entity.setPlay_count(getTenThousand(7721459));
            entity.setUser_name("来自猩猩的王子");

            data.add(entity);
        }

        OmnibusAdapter adapter = new OmnibusAdapter(getActivity(), R.layout.omnibus_gridview_item, data);
        omnibusGridview.setAdapter(adapter);
    }


    /**
     * 获取点击数，转换为单位为万
     *
     * @param play_count
     * @return
     */
    private int getTenThousand(int play_count) {
        int count = 0;
        if (play_count >= 10000) {
            count = (int) (play_count / 10000);
        }

        return count;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
