package com.example.lintai.musicradio.ui.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.lintai.musicradio.R;
import com.example.lintai.musicradio.adapter.FragmentAdapter;
import com.example.lintai.musicradio.ui.fragment.FindFragment;
import com.example.lintai.musicradio.ui.fragment.MusicIndexFragment;
import com.example.lintai.musicradio.ui.fragment.MyMusicFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by LinTai on 2016/9/6.
 */
public class MainActivity extends AppCompatActivity {

    @Bind(R.id.user_btn)
    ImageView userBtn;
    @Bind(R.id.tab_layout)
    TabLayout tabLayout;
    @Bind(R.id.music_search)
    ImageView musicSearch;
    @Bind(R.id.nv_main_navigation)
    NavigationView nvMainNavigation;
    @Bind(R.id.dl_main_drawer)
    DrawerLayout dlMainDrawer;
    @Bind(R.id.mian_viewpager)
    ViewPager mianViewpager;

    private View headerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {

        //获取抽屉头文件View
        headerView = nvMainNavigation.getHeaderView(0);
        setupDrawerContent(nvMainNavigation);

        if (mianViewpager != null) {
            setViewPager(mianViewpager);
        }
        tabLayout.setupWithViewPager(mianViewpager);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //选中
                switch (tab.getPosition()) {
                    case 0:
                        tab.setText(setTabIcon(R.mipmap.index1, false));
                        break;
                    case 1:
                        tab.setText(setTabIcon(R.mipmap.music1, false));
                        break;
                    case 2:
                        tab.setText(setTabIcon(R.mipmap.user1, false));
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //未选中
                switch (tab.getPosition()) {
                    case 0:
                        tab.setText(setTabIcon(R.mipmap.index, true));
                        break;
                    case 1:
                        tab.setText(setTabIcon(R.mipmap.music, true));
                        break;
                    case 2:
                        tab.setText(setTabIcon(R.mipmap.user, true));
                        break;
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //再次选中
                switch (tab.getPosition()) {
                    case 0:
                        tab.setText(setTabIcon(R.mipmap.index1, false));
                        break;
                    case 1:
                        tab.setText(setTabIcon(R.mipmap.music1, false));
                        break;
                    case 2:
                        tab.setText(setTabIcon(R.mipmap.user1, false));
                        break;
                }
            }
        });

    }


    /**
     * 设置Tab的图片
     *
     * @param resId
     * @param isAplpha 是否透明
     * @return
     */
    private CharSequence setTabIcon(int resId, boolean isAplpha) {
        Drawable image = getResources().getDrawable(resId);
        if (isAplpha) {
            image.setAlpha(80);
        }
        image.setBounds(0, 0, (int) (image.getIntrinsicWidth() / 2.5), (int) (image.getIntrinsicHeight() / 2.5));
        SpannableString sb = new SpannableString(" ");
        ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return sb;
    }


    /**
     * 开启抽屉菜单
     *
     * @param navigationView
     */
    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        switch (menuItem.getItemId()) {
                            case R.id.nav_home://我的收藏

                                break;
                            case R.id.nav_home2://我的分享
                                break;
                            case R.id.nav_home3:
                                break;
                            case R.id.nav_home4:
                                new AlertDialog.Builder(MainActivity.this).setTitle("提示")
                                        .setMessage("确定要退出吗？")
                                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                finish();
                                            }
                                        }).setNegativeButton("返回", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                }).show();
                                break;
                        }
                        dlMainDrawer.closeDrawers();
                        return true;
                    }
                }
        );
    }


    /**
     * 设置ViewPager内容数据
     *
     * @param viewPager
     */
    private void setViewPager(ViewPager viewPager) {
        FragmentAdapter adapter = new FragmentAdapter(getApplicationContext(), getSupportFragmentManager());
        adapter.addIconFragment(new MusicIndexFragment(), R.mipmap.index);
        adapter.addIconFragment(new MyMusicFragment(), R.mipmap.music);
        adapter.addIconFragment(new FindFragment(), R.mipmap.user);
        viewPager.setAdapter(adapter);

    }

    @OnClick({R.id.user_btn, R.id.music_search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.user_btn:
                dlMainDrawer.openDrawer(GravityCompat.START);
                break;
            case R.id.music_search:
                Intent intent = new Intent(this, SearchActivity.class);
                startActivity(intent);
                break;
        }
    }
}
