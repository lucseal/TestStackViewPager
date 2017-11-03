package com.example.sunyao.teststackviewpager.vp;

import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * @author sunyao
 * @Description:
 * @date 2017/10/26 下午3:14
 */
public class StackPagerAdapter extends PagerAdapter {
    private List<TextView> mList;

    public StackPagerAdapter(List<TextView> list) {
        mList = list;
    }


    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = mList.get(position);
        Log.d("page", "instantiateItem: " + position);
        container.addView(view);
        return view;
    }

    public View getItem(int position) {
        return mList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mList.get(position));
    }


}
