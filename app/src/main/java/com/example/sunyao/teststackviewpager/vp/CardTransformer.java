package com.example.sunyao.teststackviewpager.vp;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * @author sunyao
 * @Description:
 * @date 2017/11/2 下午5:03
 */
public class CardTransformer implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.4f;
    private static final float MAX_SCALE = 0.6f;
    private static final int Z = 100;


    @Override
    public void transformPage(View page, float position) {

        //位置 0在最上层 左边依次放在左侧下面 右边依次放在右侧下面
        if (position >= 0) {
            page.setTranslationZ(100 + -position);
        } else {
            page.setTranslationZ(100 + position);
        }

        if (position <= -1) {
            page.setClickable(false);
            page.setPivotX(page.getWidth() / 2);
            page.setPivotY(page.getHeight() / 2);
            page.setScaleX(MIN_SCALE);
            page.setScaleY(MIN_SCALE);
            page.setTranslationX(-page.getWidth() * position
                    - 300);

        } else if (position <= 0) {
            page.setPivotX(page.getWidth() / 2);
            page.setPivotY(page.getHeight() / 2);
            page.setScaleX(MIN_SCALE + (MAX_SCALE - MIN_SCALE) * (1 + position));
            page.setScaleY(MIN_SCALE + (MAX_SCALE - MIN_SCALE) * (1 + position));
            page.setTranslationX(-page.getWidth() * position
                    - 300
                    + (1 + position) * page.getWidth() * MIN_SCALE * 0.5f);

        } else if (position <= 1) {
            page.setPivotX(page.getWidth() / 2);
            page.setPivotY(page.getHeight() / 2);
            page.setScaleX(MIN_SCALE + (MAX_SCALE - MIN_SCALE) * (1 - position));
            page.setScaleY(MIN_SCALE + (MAX_SCALE - MIN_SCALE) * (1 - position));
            page.setTranslationX(-page.getWidth() * position
                    + (page.getWidth() * 0.5f) * (1 - MIN_SCALE)
                    - 100
                    - (1 - position) * page.getWidth() * MIN_SCALE * 0.5f);

        } else if (position > 1) {
            page.setClickable(false);
            page.setPivotX(page.getWidth() / 2);
            page.setPivotY(page.getHeight() / 2);
            page.setScaleX(MIN_SCALE);
            page.setScaleY(MIN_SCALE);
            page.setTranslationX(-page.getWidth() * position
                    + (page.getWidth() * 0.5f) * (1 - MIN_SCALE)
                    - 100);
        }
    }
}
