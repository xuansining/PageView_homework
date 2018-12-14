package com.example.pageview_homework;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private LinearLayout mLinearLayout;
    int[] imageResStr=new int[]{R.drawable.page1,R.drawable.page2,R.drawable.page3,R.drawable.page4
    ,R.drawable.page5,R.drawable.page6,R.drawable.page6,R.drawable.page7,R.drawable.page8};
   ImageView[] mIndicatorImages;
   private List<View> ImageList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLinearLayout=(LinearLayout) findViewById(R.id.indicator_layout);
        mViewPager=(ViewPager)findViewById(R.id.viewpager);
        intitDate();
        mViewPager.setAdapter(new PagerAdapter() {


            @Override
            public int getCount() {
                return ImageList.size();
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
              container.removeView(ImageList.get(position));
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                container.addView(ImageList.get(position));
                return ImageList.get(position);
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
                return view==o;
            }
        });
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                for(int u=0;u<mIndicatorImages.length;u++){
                    mIndicatorImages[u].setBackgroundResource(R.drawable.yuandian9);
                    if (u!=i){
                        mIndicatorImages[u].setBackgroundResource(R.drawable.yuandian10);
                    }
                }

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private void intitDate() {
         mIndicatorImages=new ImageView[8];
         ImageList=new ArrayList<>(8);
         for (int i=0;i<8;i++){

             View view=LayoutInflater.from(this).inflate(R.layout.item,null);
             ImageView imageOrder=(ImageView) view.findViewById(R.id.guide_image);
             imageOrder.setBackgroundResource(imageResStr[i]);
             ImageList.add(view);
             mIndicatorImages[i]=new ImageView(this);
             if (i==0){

                 mIndicatorImages[i].setBackgroundResource(R.drawable.yuandian9);
             }else{
                 mIndicatorImages[i].setBackgroundResource(R.drawable.yuandian10);
                 LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(-2,-2);
                 params.setMargins(2,0,0,0);
                 mIndicatorImages[i].setLayoutParams(params);
             }
             mLinearLayout.addView(mIndicatorImages[i]);
         }

    }
}
