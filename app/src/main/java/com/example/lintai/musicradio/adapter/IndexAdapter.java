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
import com.example.lintai.musicradio.entity.IndexEntity;
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

    private List<IndexEntity.DataBean.ListBean> dataList = new ArrayList<IndexEntity.DataBean.ListBean>();//数据集合

    public IndexAdapter(Context context, List<IndexEntity.DataBean.ListBean> dataList) {
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
        IndexItemOneViewHolder itemOneViewHolder = null;
        IndexItemTwoViewHodler itemTwoViewHodler = null;
        IndexItemThreeViewHodler itemThreeViewHodler = null;
        IndexItemFourViewHodler itemFourViewHodler = null;

        int type = getItemViewType(i);

        if(view==null){
            inflater = LayoutInflater.from(context);
            switch (type){
                case TYPE_ONE:
                    view = inflater.inflate(R.layout.index_listview_1,null);
                    itemOneViewHolder = new IndexItemOneViewHolder();
                    itemOneViewHolder.imageView = (ImageView) view.findViewById(R.id.index_recommend_img);
                    itemOneViewHolder.imageView2 = (ImageView) view.findViewById(R.id.index_recommend_img2);
                    itemOneViewHolder.imageView3 = (ImageView) view.findViewById(R.id.index_recommend_img3);
                    itemOneViewHolder.songsName = (TextView) view.findViewById(R.id.index_recommend_tv);
                    itemOneViewHolder.songsName2 = (TextView) view.findViewById(R.id.index_recommend_tv2);
                    itemOneViewHolder.songsName3 = (TextView) view.findViewById(R.id.index_recommend_tv3);

                    view.setTag(itemOneViewHolder);
                    break;
                case TYPE_TWO:
                    view = inflater.inflate(R.layout.index_listview_2,null);

                    view.setTag(itemTwoViewHodler);
                    break;
                case TYPE_THERR:
                    view = inflater.inflate(R.layout.index_listview_3,null);

                    view.setTag(itemThreeViewHodler);
                    break;
                case TYPE_FOUR:
                    view = inflater.inflate(R.layout.index_listview_4,null);

                    view.setTag(itemFourViewHodler);
                    break;
                default:
                    break;
            }
        }
        else {
            switch (type){
                case TYPE_ONE:
                    itemOneViewHolder = (IndexItemOneViewHolder) view.getTag();
                    break;
                case TYPE_TWO:
                    itemTwoViewHodler = (IndexItemTwoViewHodler) view.getTag();
                    break;
                case TYPE_THERR:
                    itemThreeViewHodler = (IndexItemThreeViewHodler) view.getTag();
                    break;
                case TYPE_FOUR:
                    itemFourViewHodler = (IndexItemFourViewHodler) view.getTag();
                    break;
            }
        }

        //设置资源
        switch (type){
            case TYPE_ONE:

                itemOneViewHolder.setImageURL(context,dataList.get(i).getSongs().get(0).getAlbum_logo());
                itemOneViewHolder.imageView.setImageURI(Uri.parse(dataList.get(i).getSongs().get(0).getAlbum_logo()));
                itemOneViewHolder.songsName.setText(dataList.get(i).getSongs().get(0).getSong_name());
                itemOneViewHolder.setImageURL2(context,dataList.get(i).getSongs().get(1).getAlbum_logo());
                itemOneViewHolder.songsName2.setText(dataList.get(i).getSongs().get(1).getSong_name());
                itemOneViewHolder.setImageURL3(context,dataList.get(i).getSongs().get(2).getAlbum_logo());
                itemOneViewHolder.songsName3.setText(dataList.get(i).getSongs().get(2).getSong_name());

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
        if ("19_normal".equals(dataList.get(position).getType())) {
            return TYPE_ONE;
        } else if ("10_operation".equals(dataList.get(position).getType())) {
            return TYPE_TWO;
        } else if ("12_operation".equals(dataList.get(position).getType())) {
            return TYPE_THERR;
        } else if ("24_operation".equals(dataList.get(position).getType())) {
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

class IndexItemOneViewHolder {
    TextView songsName;//播放数
    ImageView imageView;//图片
    TextView songsName2;//播放数
    ImageView imageView2;//图片
    TextView songsName3;//播放数
    ImageView imageView3;//图片

    List<ImageView> imageViews;

    public IndexItemOneViewHolder setImageURL(Context context,String url){
        if (!url.equals("")) {
            Picasso.with(context)
                    .load(url)
                    .placeholder(R.mipmap.aaa)
                    .error(R.mipmap.aaa)
                    .into(imageView);
        }
        return this;
    }
    public IndexItemOneViewHolder setImageURL2(Context context,String url){
        if (!url.equals("")) {
            Picasso.with(context)
                    .load(url)
                    .placeholder(R.mipmap.aaa)
                    .error(R.mipmap.aaa)
                    .into(imageView2);
        }
        return this;
    }
    public IndexItemOneViewHolder setImageURL3(Context context,String url){
        if (!url.equals("")) {
            Picasso.with(context)
                    .load(url)
                    .placeholder(R.mipmap.aaa)
                    .error(R.mipmap.aaa)
                    .into(imageView3);
        }
        return this;
    }
}

class IndexItemTwoViewHodler {
    TextView title;//标题
    ImageView songLogo;//封面
    TextView songName;//歌名
    TextView singer;//歌手

}

class IndexItemThreeViewHodler {
    TextView playCount;//播放数
    ImageView songLogo;//封面
    TextView songName;//歌名
    TextView singger;//歌手
    TextView lebel;//标签
}

class IndexItemFourViewHodler {
    TextView playCount;//播放数
    ImageView songLogo;//封面
    TextView songName;//歌名
    TextView singger;//歌手
    TextView lebel;//标签
}
