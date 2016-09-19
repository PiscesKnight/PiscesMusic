package com.example.lintai.musicradio.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.lintai.musicradio.R;
import com.example.lintai.musicradio.adapter.IndexAdapter;
import com.example.lintai.musicradio.entity.IndexEntity;
import com.example.lintai.musicradio.utils.view.util.FixListViewHeight;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by LinTai on 2016/8/31.
 */
public class IndexFragment extends Fragment {

    @Bind(R.id.index_listview)
    ListView indexListview;

    private IndexAdapter adapter;
    private Banner banner;
    private String[] images = new String[]{"http://pic.xiami.net/images/common/uploadpic/26/14726094262291.jpg@1e_1c_0i_1o_100Q_1080w_472h.webp", "http://pic.xiami.net/images/common/uploadpic/79/14726093791429.jpg@1e_1c_0i_1o_100Q_1080w_472h.webp", "http://pic.xiami.net/images/common/uploadpic/75/14726094753749.jpg@1e_1c_0i_1o_100Q_1080w_472h.webp", "http://pic.xiami.net/images/common/uploadpic/25/14725187255978.jpg@1e_1c_0i_1o_100Q_1080w_472h.webp", "http://pic.xiami.net/images/common/uploadpic/82/14725256825764.jpg@1e_1c_0i_1o_100Q_1080w_472h.webp"};

    private List<IndexEntity.DataBean.ListBean> data = new ArrayList<>();

    private IndexEntity.DataBean.ListBean listBean = new IndexEntity.DataBean.ListBean();
    private IndexEntity.DataBean.ListBean listBean2 = new IndexEntity.DataBean.ListBean();
    private IndexEntity.DataBean.ListBean listBean3 = new IndexEntity.DataBean.ListBean();
    private IndexEntity.DataBean.ListBean listBean4 = new IndexEntity.DataBean.ListBean();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.index_fragment, container, false);

        ButterKnife.bind(IndexFragment.this, view);
        init(view);
        initData();
        return view;
    }

    private void init(View view) {
        banner = (Banner) view.findViewById(R.id.banner);
        banner.setImages(images);
        banner.setDelayTime(3000);
    }

    private void initData() {
        IndexEntity.DataBean.ListBean.SongsBean songsBean = new IndexEntity.DataBean.ListBean.SongsBean();
        songsBean.setAlbum_logo("http://pic.xiami.net/images/album/img99/175346199/12340264801470039916.jpg@1e_1c_0i_1o_100Q_335w_335h.webp");
        songsBean.setArtist_name("TFBOYS");
        songsBean.setSong_name("明天，你好");
        songsBean.setSingers("王俊凯；王源");
        IndexEntity.DataBean.ListBean.SongsBean songsBean2 = new IndexEntity.DataBean.ListBean.SongsBean();
        songsBean2.setAlbum_logo("http://pic.xiami.net/images/album/img58/7158/1350537981436428083.jpg@1e_1c_0i_1o_100Q_335w_335h.webp");
        songsBean2.setArtist_name("原声带");
        songsBean2.setSong_name("栀子花开");
        songsBean2.setSingers("何炅;angela");
        IndexEntity.DataBean.ListBean.SongsBean songsBean3 = new IndexEntity.DataBean.ListBean.SongsBean();
        songsBean3.setAlbum_logo("http://pic.xiami.net/images/album/img28/2328/125591366018062.jpg@1e_1c_0i_1o_100Q_335w_335h.webp");
        songsBean3.setArtist_name("许美静");
        songsBean3.setSong_name("阳光总在风雨后");
        songsBean3.setSingers("许美静");

        List<IndexEntity.DataBean.ListBean.SongsBean> dataSongs = new ArrayList<>();
        dataSongs.add(songsBean);
        dataSongs.add(songsBean2);
        dataSongs.add(songsBean3);
        listBean.setType("19_normal");
        listBean.setSongs(dataSongs);
        listBean2.setType("10_operation");
        listBean3.setType("12_operation");
        listBean4.setType("24_operation");
        data.add(listBean);
        data.add(listBean2);
        data.add(listBean3);
        data.add(listBean4);

        adapter =new IndexAdapter(getActivity(),data);
        indexListview.setAdapter(adapter);

        FixListViewHeight.fixListViewHeight(indexListview);
        indexListview.setFocusable(false);//解决listview定位不在顶部
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("IndexFragment", "onCreate");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("IndexFragment", "onResume");

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
