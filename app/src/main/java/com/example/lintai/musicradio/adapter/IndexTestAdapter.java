package com.example.lintai.musicradio.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.util.SparseArray;
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
public abstract class IndexTestAdapter<T> extends BaseAdapter {

    private static final int TYPE_COUNT = 4;//item类型总数
    private Context context;
    private LayoutInflater inflater;
    private List<Integer> layoutId;

    private List<String> itemType;
    private List<String> dataGetType;


    private List<ViewHolder> viewHodlers;
    private int typeCount;//item类型总数

    private List<T> dataList = new ArrayList<>();//数据集合

    public IndexTestAdapter(Context context, int typeCount, List<Integer> layoutId, List<T> dataList, List<String> itemType, List
                        <String> dataGetType) {
        this.dataList = dataList;
        this.layoutId = layoutId;
        this.context = context;
        this.typeCount = typeCount;
        this.itemType = itemType;
        this.dataGetType = dataGetType;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public T getItem(int i) {
        return dataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        viewHodlers = new ArrayList<>();

        for (int b = 1; b <= typeCount; b++) {
            viewHolder = null;
            int type = getItemViewType(i);
            viewHolder = ViewHolder.get(context,view,viewGroup,layoutId.get(type),i);
//            viewHolder = new ViewHolder(context,viewGroup,layoutId.get(type),i);
            getItemView(viewHolder, getItem(i));
            viewHodlers.add(viewHolder);
        }

        if (view == null) {
            inflater = LayoutInflater.from(context);
            for (int a = 0; a < layoutId.size(); a++) {
                view = inflater.inflate(layoutId.get(a), null);

                view.setTag(viewHodlers.get(a));

            }

        } else {
            for (int b = 0; b < layoutId.size(); b++) {

                viewHolder = viewHodlers.get(b);
                viewHolder = (ViewHolder) view.getTag();

            }
        }


        notifyDataSetChanged();

        return viewHolder.getConvertView();
    }

    @Override
    public int getItemViewType(int position) {

        int type = 0;

        for (int i=0;i<typeCount;i++) {
            if (itemType.get(i).equals(dataGetType.get(position))) {
                return i;
            }else {
                return 100;
            }
        }
        return type;
    }

    @Override
    public int getViewTypeCount() {
        return TYPE_COUNT;
    }

    public abstract void getItemView(ViewHolder viewHolder,T t);

    public void addAll(List<T> elem) {
        dataList.addAll(elem);
        notifyDataSetChanged();
    }

    public void add(T elem) {
        dataList.add(elem);
        notifyDataSetChanged();
    }

    public void remove(T elem) {
        dataList.remove(elem);
        notifyDataSetChanged();
    }

    public void remove(int index) {
        dataList.remove(index);
        notifyDataSetChanged();
    }

    public void replaceAll(List<T> elem) {
        dataList.clear();
        if (elem != null) {
            dataList.addAll(elem);
        }
        notifyDataSetChanged();
    }
}


class ViewHolder {
    private SparseArray<View> mViews;
    private int position;
    private View mConvertView;
    private Context context;

    public ViewHolder(Context context, ViewGroup parent, int layoutId, int position) {
        this.context = context;
        this.position = position;
        this.mViews = new SparseArray<>();
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        mConvertView.setTag(this);
    }

    public static ViewHolder get(Context context, View convertView, ViewGroup parent, int layoutId, int position) {
        if (convertView == null) {
            return new ViewHolder(context, parent, layoutId, position);
        } else {
            ViewHolder holder = (ViewHolder) convertView.getTag();
            holder.position = position;
            return holder;
        }
    }

    public View getConvertView() {
        return mConvertView;
    }

    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);

        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }

        return (T) view;
    }

    /**
     * TextVIew
     *
     * @param viewId
     * @param text   ֵ
     * @return
     */
    public ViewHolder setText(int viewId, String text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    /**
     * ImageView
     *
     * @param viewId
     * @param resourceId
     * @return
     */
    public ViewHolder setImageResource(int viewId, int resourceId) {
        ImageView imageView = getView(viewId);
        imageView.setImageResource(resourceId);
        return this;
    }

    /**
     * ImageView
     *
     * @param viewId
     * @param bitmap
     * @return
     */
    public ViewHolder setImageBitmap(int viewId, Bitmap bitmap) {
        ImageView imageView = getView(viewId);
        imageView.setImageBitmap(bitmap);
        return this;
    }

    /**
     * ImageView
     *
     * @param viewId
     * @param url
     * @return
     */
    public ViewHolder setImageURL(int viewId, String url) {
        ImageView imageView = getView(viewId);
        if (!url.equals("")) {
            Picasso.with(context)
                    .load(url)
                    .placeholder(R.mipmap.aaa)
                    .error(R.mipmap.aaa)
                    .centerCrop()
                    .resize(250, 250)
                    .into(imageView);
        }
        return this;
    }

}

