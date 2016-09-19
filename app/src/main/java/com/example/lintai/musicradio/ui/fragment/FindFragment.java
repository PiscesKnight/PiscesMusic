package com.example.lintai.musicradio.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.lintai.musicradio.R;
import com.example.lintai.musicradio.adapter.DemoAdapter;
import com.example.lintai.musicradio.adapter.FindAdapter;
import com.example.lintai.musicradio.entity.FindEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by LinTai on 2016/9/6.
 */
public class FindFragment extends Fragment {

    @Bind(R.id.find_listview)
    ListView findListview;

    private FindAdapter adapter;
    private List<Integer> layoutId;
    private List<String> itemType;
    private List<String> dataGetType;
    private List<FindEntity.DataBean.ListBean> data = null;
    private FindEntity.DataBean.ListBean listBean = new FindEntity.DataBean.ListBean();
    private FindEntity.DataBean.ListBean listBean2 = new FindEntity.DataBean.ListBean();
    private FindEntity.DataBean.ListBean listBean3 = new FindEntity.DataBean.ListBean();
    private FindEntity.DataBean.ListBean listBean4 = new FindEntity.DataBean.ListBean();
    private FindEntity.DataBean.ListBean listBean5 = new FindEntity.DataBean.ListBean();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.find_fragment, container, false);

        ButterKnife.bind(FindFragment.this, view);

        initView();
        return view;
    }

    private void initView() {
        data = new ArrayList<>();

        FindEntity.DataBean.ListBean.CollectBean collectBean = new FindEntity.DataBean.ListBean.CollectBean();
        collectBean.setCollect_logo("http://pic.xiami.net/images/collect/530/30/149204530_1456643954_YCWx.jpg@1e_1c_0i_1o_100Q_1080w_742h.webp");
        collectBean.setPlay_count(12345);
        collectBean.setAuthor_name("木头吉娜  创作的精选集");
        collectBean.setCollect_name("性感，与长相无关的【女生篇】");
        collectBean.setDescription("我心中，定义的性感：与长相无关，与声音有关；与曲风无关，与唱腔有关；与歌词无关，与吐字有关；——还和前两辑一样，在意的只是那些个声音所带来的感觉，和是否为热单无关；闲着没事非要来咬文嚼字的，");
        listBean.setCollect(collectBean);
        listBean.setType("6_normal");
        listBean2.setType("8_normal");
        listBean3.setType("9_normal");
        listBean4.setType("5_normal");
        listBean5.setCollect(collectBean);
        listBean5.setType("6_normal");
        data.add(listBean);
        data.add(listBean2);
        data.add(listBean3);
        data.add(listBean4);
        data.add(listBean5);
        layoutId = new ArrayList<>();
        itemType = new ArrayList<>();
        dataGetType = new ArrayList<>();
        layoutId.add(R.layout.find_listview_1);
        layoutId.add(R.layout.find_listview_2);
        layoutId.add(R.layout.find_listview_3);
        layoutId.add(R.layout.find_listview_4);

        itemType.add("6_normal");
        itemType.add("9_normal");
        itemType.add("8_normal");
        itemType.add("5_normal");

        for (int i = 0;i<data.size();i++) {
            dataGetType.add(data.get(i).getType());
        }

        adapter = new FindAdapter(getActivity(),data);
        findListview.setAdapter(adapter);


        fixListViewHeight(findListview);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    /**
     * 重新计算Listview的每一个Item高度
     * @param listView
     */
    public void fixListViewHeight(ListView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        ListAdapter listAdapter = listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }
        for (int index = 0, len = listAdapter.getCount(); index < len; index++) {
            View listViewItem = listAdapter.getView(index , null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += listViewItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // listView.getDividerHeight()获取子项间分隔符的高度
        // params.height设置ListView完全显示需要的高度
        params.height = totalHeight+ (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }
}
