package com.example.sunyao.teststackviewpager.vp;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

/**
 * @author sunyao
 * @Description:
 * @date 2017/10/26 下午3:21
 */
public class StackTransformer implements ViewPager.PageTransformer {
    @Override
    public void transformPage(View page, float position) {
        Log.d("position: ", "transformPage: " + position);

        if (position <= -1f) {
            page.setClickable(false);
            page.setAlpha(0.5f);
            page.setPivotX(page.getWidth() / 2);
            page.setPivotY(page.getHeight() / 2);
            page.setRotationY(-360);
            page.setScaleX((float) Math.pow(0.9f, -position) * 0.5f);
            page.setScaleY((float) Math.pow(0.9f, -position) * 0.5f);
            page.setTranslationX(-page.getWidth() * position - 400);

        } else if (position <= 0.0f) {
            page.setAlpha(1f);
            page.setPivotY(page.getHeight() / 2);
            page.setPivotX(page.getWidth() / 2);
            page.setScaleY(0.9f * (1 + position) * 0.5f);
            page.setScaleX(0.9f * (1 + position) * 0.5f);
            page.setRotationY(360 * position);
            page.setClickable(true);

        } else if (position > 0.0f){
            page.setClickable(false);
            page.setAlpha(0.5f);
            page.setPivotX(page.getWidth() / 2);
            page.setPivotY(page.getHeight() / 2);
            page.setScaleX((float) Math.pow(0.9f, position) * 0.5f);
            page.setScaleY((float) Math.pow(0.9f, position) * 0.5f);
            page.setTranslationX(-page.getWidth() * position
                    + (page.getWidth() * 0.5f) * (1 - (float) Math.pow(0.9f, position))
                    + 20 * position + 400);
        }
    }
}
