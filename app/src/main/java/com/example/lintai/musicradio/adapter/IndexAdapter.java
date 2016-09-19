package com.example.lintai.musicradio.adapter;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lintai.musicradio.R;
import com.example.lintai.musicradio.entity.FindEntity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LinTai on 2016/9/8.
 */
public class IndexAdapter extends BaseAdapter {

    private static final int TYPE_COUNT = 4;//item类型总数
    private static final int TYPE_ONE = 1;//大图片item
    private static final int TYPE_TWO = 2;//试听榜
    private static final int TYPE_THERR = 3;//热门歌曲
    private static final int TYPE_FOUR = 4;//单曲歌手
    private Context context;
    private LayoutInflater inflater = null;

    private List<FindEntity.DataBean.ListBean> dataList = new ArrayList<FindEntity.DataBean.ListBean>();//数据集合

    public IndexAdapter(Context context, List<FindEntity.DataBean.ListBean> dataList) {
        super();
        this.dataList = dataList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return dataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ItemOneViewHolder itemOneViewHolder = null;
        ItemTwoViewHodler itemTwoViewHodler = null;
        ItemThreeViewHodler itemThreeViewHodler = null;
        ItemFourViewHodler itemFourViewHodler = null;

        int type = getItemViewType(i);

        if(view==null){
            inflater = LayoutInflater.from(context);
            switch (type){
                case TYPE_ONE:
                    view = inflater.inflate(R.layout.find_listview_1,null);
                    itemOneViewHolder = new ItemOneViewHolder();
                    itemOneViewHolder.palyCount = (TextView) view.findViewById(R.id.find_play_count);
                    itemOneViewHolder.imageView = (ImageView) view.findViewById(R.id.find_imageview);
                    itemOneViewHolder.title = (TextView) view.findViewById(R.id.find_title);
                    itemOneViewHolder.author = (TextView) view.findViewById(R.id.find_author);
                    itemOneViewHolder.content = (TextView) view.findViewById(R.id.find_content);

                    view.setTag(itemOneViewHolder);
                    break;
                case TYPE_TWO:
                    view = inflater.inflate(R.layout.find_listview_2,null);

                    view.setTag(itemTwoViewHodler);
                    break;
                case TYPE_THERR:
                    view = inflater.inflate(R.layout.find_listview_3,null);

                    view.setTag(itemThreeViewHodler);
                    break;
                case TYPE_FOUR:
                    view = inflater.inflate(R.layout.find_listview_4,null);

                    view.setTag(itemFourViewHodler);
                    break;
                default:
                    break;
            }
        }
        else {
            switch (type){
                case TYPE_ONE:
                    itemOneViewHolder = (ItemOneViewHolder) view.getTag();
                    break;
                case TYPE_TWO:
                    itemTwoViewHodler = (ItemTwoViewHodler) view.getTag();
                    break;
                case TYPE_THERR:
                    itemThreeViewHodler = (ItemThreeViewHodler) view.getTag();
                    break;
                case TYPE_FOUR:
                    itemFourViewHodler = (ItemFourViewHodler) view.getTag();
                    break;
            }
        }

        //设置资源
        switch (type){
            case TYPE_ONE:
                itemOneViewHolder.palyCount.setText(dataList.get(i).getCollect().getPlay_count()+"万");
                itemOneViewHolder.setImageURL(context,dataList.get(i).getCollect().getCollect_logo());
                itemOneViewHolder.title.setText(dataList.get(i).getCollect().getCollect_name());
                itemOneViewHolder.author.setText(dataList.get(i).getCollect().getAuthor_name());
                itemOneViewHolder.content.setText(dataList.get(i).getCollect().getDescription());
                break;
            case TYPE_TWO:
                break;
            case TYPE_THERR:
                break;
            case TYPE_FOUR:
                break;
        }

        notifyDataSetChanged();

        return view;
    }

    @Override
    public int getItemViewType(int position) {
        if ("6_normal".equals(dataList.get(position).getType())) {
            return TYPE_ONE;
        } else if ("9_normal".equals(dataList.get(position).getType())) {
            return TYPE_TWO;
        } else if ("8_normal".equals(dataList.get(position).getType())) {
            return TYPE_THERR;
        } else if ("5_normal".equals(dataList.get(position).getType())) {
            return TYPE_FOUR;
        } else {
            return 100;
        }
    }

    @Override
    public int getViewTypeCount() {
        return TYPE_COUNT;
    }
}

//class ItemOneViewHolder {
//    TextView palyCount;//播放数
//    ImageView imageView;//图片
//
//    public ItemOneViewHolder setImageURL(Context context,String url){
//
//        if (!url.equals("")) {
//            Picasso.with(context)
//                    .load(url)
//                    .placeholder(R.mipmap.aaa)
//                    .error(R.mipmap.aaa)
//                    .into(imageView);
//        }
//        return this;
//    }
//
//
//
//    TextView title;//标题
//    TextView author;//作者
//    TextView content;//内容
//}
//
//class ItemTwoViewHodler {
//    TextView title;//标题
//    ImageView songLogo;//封面
//    TextView songName;//歌名
//    TextView singer;//歌手
//
//}
//
//class ItemThreeViewHodler {
//    TextView playCount;//播放数
//    ImageView songLogo;//封面
//    TextView songName;//歌名
//    TextView singger;//歌手
//    TextView lebel;//标签
//}
//
//class ItemFourViewHodler {
//    TextView playCount;//播放数
//    ImageView songLogo;//封面
//    TextView songName;//歌名
//    TextView singger;//歌手
//    TextView lebel;//标签
//}
