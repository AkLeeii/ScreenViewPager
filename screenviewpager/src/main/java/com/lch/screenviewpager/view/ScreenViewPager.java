package com.lch.screenviewpager.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by lch on 2017/5/8.
 */
public class ScreenViewPager extends ViewPager {
    public ScreenViewPager(Context context) {
        super(context);
        initialize();
    }

    public ScreenViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    private void initialize() {
        setChildrenDrawingOrderEnabled(true);
        setOffscreenPageLimit(5);
        setPageTransformer(true, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View page, float position) {
                float pageWidth = page.getWidth();
                float v = Math.abs(position);
                float v1 = 0.2f * (v * v);
                page.setAlpha(1f);
                if (position > 2) {
                    page.setAlpha(0);
                } else if (position > 1) {
                    page.setScaleX(0.8f);
                    page.setScaleY(0.8f);
                    page.setAlpha(Math.abs(2 - position));
                    page.setTranslationX(-v / 2 * pageWidth);
                } else if (position >= 0) {
                    page.setScaleX(1 - v1);
                    page.setScaleY(1 - v1);
                    page.setTranslationX(-v / 2 * pageWidth);
                } else if (position >= -1) {
                    page.setScaleX(1 - v1);
                    page.setScaleY(1 - v1);
                    page.setTranslationX(v / 2 * pageWidth);
                } else {
                    page.setScaleX(0.8f);
                    page.setScaleY(0.8f);
                    page.setAlpha(2 - Math.abs(position));
                    page.setTranslationX(v / 2 * pageWidth);
                }
            }
        });
    }

    @Override
    protected int getChildDrawingOrder(int childCount, int i) {
        int count = super.getChildDrawingOrder(childCount, i);
//        首先i不是第0个
        if (i == 0) {
            count = 0;
        } else {
//        如果是选中的view，就先绘制最后一个view
            if (i == getCurrentItem()) {
                count = childCount - 1;
            }
//        如果是最后一个view，就绘制选中的view
            if (i == childCount - 1) {
                count = getCurrentItem();
            }
        }
        return count;
    }
}
