package com.example.lintai.musicradio.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 泰子 on 2015/10/17.
 */
public class FragmentAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mFragments = new ArrayList<>();
    private List<String> mFragemntTitles = new ArrayList<>();
    private List<Integer> mFragmentIcon = new ArrayList<>();

    private Context context;

    public FragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addIconFragment(Fragment fragments, int imageId) {
        mFragmentIcon.add(imageId);
        mFragments.add(fragments);
    }

    public void addTitleFragemnt(Fragment fragments, String titles) {
        mFragemntTitles.add(titles);
        mFragments.add(fragments);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        CharSequence charSequence = null;

        if (mFragmentIcon.size() > 0) {
            Drawable image = context.getResources().getDrawable(mFragmentIcon.get(position));
            if (position != 0) {//第一个不透明
                image.setAlpha(80);
            }
            image.setBounds(0, 0, (int) (image.getIntrinsicWidth() / 2.5), (int) (image.getIntrinsicHeight() / 2.5));
            SpannableString sb = new SpannableString(" ");
            ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
            sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            charSequence = sb;
        }
        if (mFragemntTitles.size() > 0) {
            charSequence = mFragemntTitles.get(position);
        }
        return charSequence;

    }


}
