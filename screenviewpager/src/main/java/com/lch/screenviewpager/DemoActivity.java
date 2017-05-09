package com.lch.screenviewpager;

import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class DemoActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private LinearLayout linearLayout;
    private List<Integer> pics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //这里是为了让Viewpager左右两侧也可以滑动viewpager
        linearLayout = (LinearLayout) findViewById(R.id.linearlayout);
        linearLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return viewPager.dispatchTouchEvent(event);
            }
        });
        //end
        //viewpager的数据
        pics = new ArrayList<>();
        pics.add(R.mipmap.p1);
        pics.add(R.mipmap.p2);
        pics.add(R.mipmap.p3);
        pics.add(R.mipmap.p4);
        pics.add(R.mipmap.p5);
        //end
        //设置viewpager的适配器
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new PagerAdapter() {
            private SparseArray<ImageView> imageViews = new SparseArray<>();

            @Override
            public int getCount() {
//              return Integer.MAX_VALUE;
                return pics.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, final int position) {
                ImageView view = new ImageView(DemoActivity.this);
                view.setScaleType(ImageView.ScaleType.CENTER_CROP);
                view.setBackgroundColor(Color.WHITE);
                view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                view.setImageResource(pics.get(position % pics.size()));
                container.addView(view);
//              Glide.with(context).load(pics.get(position % pics.size())).centerCrop().into(view);
                imageViews.put(position, view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
                imageViews.remove(position);
            }
        });
        //end
    }
}
