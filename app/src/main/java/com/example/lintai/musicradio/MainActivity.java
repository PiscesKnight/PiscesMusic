package com.example.lintai.musicradio;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.lintai.musicradio.adapter.FragmentAdapter;
import com.example.lintai.musicradio.fragment.IndexFragment;
import com.example.lintai.musicradio.fragment.OmnibusFragment;
import com.example.lintai.musicradio.fragment.RadioStationFragment;
import com.example.lintai.musicradio.fragment.RankingFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by LinTai on 2016/8/30.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.user_btn)
    ImageView userBtn;
    @Bind(R.id.tab_layout)
    TabLayout tabLayout;
    @Bind(R.id.viewpager)
    ViewPager viewpager;
    @Bind(R.id.nv_main_navigation)
    NavigationView nvMainNavigation;
    @Bind(R.id.dl_main_drawer)
    DrawerLayout dlMainDrawer;

    private DrawerLayout mDrawerLayout;
    private NavigationView navigationView;//菜单抽屉
    private View headerView;

    private ViewPager viewPager;//切换页面


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_main_drawer);
        navigationView = (NavigationView) findViewById(R.id.nv_main_navigation);

        viewPager = (ViewPager) findViewById(R.id.viewpager);

        //获取抽屉头文件View
        headerView = navigationView.getHeaderView(0);
        setupDrawerContent(navigationView);

        if (viewPager != null) {
            setViewPager(viewPager);
        }
        tabLayout.setupWithViewPager(viewPager);
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
                                //  Intent intent = new Intent(MainActivity.this,MycollectActivity.class);
                                //   startActivity(intent);
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
                        mDrawerLayout.closeDrawers();
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
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());
        adapter.addFragemnt(new IndexFragment(), getResources().getString(R.string.index));
        adapter.addFragemnt(new OmnibusFragment(), getResources().getString(R.string.songs));
        adapter.addFragemnt(new RadioStationFragment(), getResources().getString(R.string.radio_station));
        adapter.addFragemnt(new RankingFragment(), getResources().getString(R.string.ranking));
        viewPager.setAdapter(adapter);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.user_btn://用户菜单
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
        }
    }

    @OnClick(R.id.user_btn)
    public void onClick() {
    }
}
