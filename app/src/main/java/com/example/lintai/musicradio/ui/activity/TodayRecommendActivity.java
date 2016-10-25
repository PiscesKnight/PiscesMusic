package com.example.lintai.musicradio.ui.activity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lintai.musicradio.R;
import com.example.lintai.musicradio.utils.view.ListViewForScrollView;
import com.example.lintai.musicradio.utils.view.util.FastBlur;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 首页-今日推荐
 * Created by JinBao on 2016/10/22.
 */

public class TodayRecommendActivity extends AppCompatActivity {

    //    @Bind(R.id.tv_version)
//    TextView tvVersion;
    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @Bind(R.id.main_content)
    CoordinatorLayout mainContent;
    @Bind(R.id.appbar)
    AppBarLayout appbar;
    @Bind(R.id.backdrop)
    ImageView imageView;
    @Bind(R.id.today_recommend_listview)
    ListViewForScrollView todayRecommendListview;
    @Bind(R.id.old_img)
    ImageView oldImg;
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    private Bitmap mBitmap, overlay;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        setContentView(R.layout.toolbar);
        ButterKnife.bind(this);
        init();
    }

    private CollapsingToolbarLayoutState state;

    @OnClick(R.id.old_img)
    public void onClick() {
    }

    private enum CollapsingToolbarLayoutState {
        EXPANDED,
        COLLAPSED,
        INTERNEDIATE
    }

    private void init() {
        setToolbar();
        setAppBarLayout();
        setView();
        setModel();

    }

    private void setToolbar(){
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setAppBarLayout() {

        appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

                if (verticalOffset == 0) {
                    if (state != CollapsingToolbarLayoutState.EXPANDED) {
                        state = CollapsingToolbarLayoutState.EXPANDED;//修改状态标记为展开
                        collapsingToolbar.setTitle("");//设置title为EXPANDED
                    }
                } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
                    if (state != CollapsingToolbarLayoutState.COLLAPSED) {
                        collapsingToolbar.setTitle("今日推荐");//设置title显示
                        // playButton.setVisibility(View.VISIBLE);//隐藏播放按钮
                        state = CollapsingToolbarLayoutState.COLLAPSED;//修改状态标记为折叠
                    }
                } else {
                    if (state != CollapsingToolbarLayoutState.INTERNEDIATE) {
                        if (state == CollapsingToolbarLayoutState.COLLAPSED) {
                            //   playButton.setVisibility(View.GONE);//由折叠变为中间状态时隐藏播放按钮
                        }
                        collapsingToolbar.setTitle("");//设置title
                        state = CollapsingToolbarLayoutState.INTERNEDIATE;//修改状态标记为中间
                    }
                }
            }
        });
    }


    /**
     * @return 返回值：
     * @作者：Gxy
     * @creat on 2016/1/16 14:19
     * @用途：设置模糊图片的长和宽
     * @params 参数说明：
     */
    private void setView() {
        ViewGroup.LayoutParams params = imageView.getLayoutParams();
        params.height = 310*(int)getResources().getDisplayMetrics().density;
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        imageView.setLayoutParams(params);
    }

    /**
     * @return 返回值：
     * @作者：Gxy
     * @creat on 2016/1/16 14:27
     * @用途： 通过计算，然后模糊图片，网上搜的，看不明白！
     * @params 参数说明：
     */
    private void setModel() {
        if (null != overlay) {
            imageView.setImageBitmap(overlay);
        }
        //将old_image对象转化为bitmap对象
        oldImg.buildDrawingCache();
        mBitmap = oldImg.getDrawingCache();
        mBitmap = ((BitmapDrawable) oldImg.getDrawable()).getBitmap();
        //下面这两个数字是控制模糊度的，可以自定义，测试了1-15之间的数字，自己感觉合适就行！
        float scaleFactor = 10;
        float radius = 6;
        int width = mBitmap.getWidth();
        int height = mBitmap.getHeight();
        overlay = Bitmap.createBitmap((int) (width / scaleFactor), (int) (height / scaleFactor), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(overlay);
        canvas.scale(1 / scaleFactor, 1 / scaleFactor);
        Paint paint = new Paint();
        paint.setFlags(Paint.FILTER_BITMAP_FLAG);
        canvas.drawBitmap(mBitmap, 0, 0, paint);
        overlay = FastBlur.doBlur(overlay, (int) radius, true);
        imageView.setImageBitmap(overlay);
    }

}
