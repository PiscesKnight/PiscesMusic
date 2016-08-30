package com.example.lintai.musicradio;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by LinTai on 2016/8/30.
 */
public class MainActivity extends Activity implements View.OnClickListener{

    private DrawerLayout mDrawerLayout;
    private NavigationView navigationView;//菜单抽屉
    private View headerView;

    private ImageView userBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_main);
        initView();
    }

    private void initView(){
        mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_main_drawer);
        navigationView = (NavigationView) findViewById(R.id.nv_main_navigation);

        userBtn = (ImageView) findViewById(R.id.user_btn);


        //获取抽屉头文件View
        headerView = navigationView.getHeaderView(0);
        setupDrawerContent(navigationView);
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

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.user_btn://用户菜单
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
        }
    }
}
