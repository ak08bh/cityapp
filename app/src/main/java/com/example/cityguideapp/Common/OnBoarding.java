package com.example.cityguideapp.Common;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cityguideapp.HelperClasses.SliderAdapter;
import com.example.cityguideapp.R;
import com.example.cityguideapp.User.UserDashboard;

public class OnBoarding extends AppCompatActivity
{

    ViewPager2 viewPager;
    Button lets_get_started;
    ImageView btn_next;
    Animation animation;
    LinearLayout SliderDots;
    int currentPos;
    SliderAdapter sliderAdapter;
    TextView[] dots;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_on_boarding);


        viewPager=findViewById(R.id.slider);
        lets_get_started=findViewById(R.id.lets_get_started);
        btn_next=findViewById(R.id.btn_next);
        SliderDots=findViewById(R.id.SliderDots);

        sliderAdapter=new SliderAdapter(this);


        viewPager.setAdapter(sliderAdapter);

        addDots(0);

        viewPager.registerOnPageChangeCallback(pageChangeCallback);

    }

    public void skip(View view)
    {
      startActivity(new Intent(this, UserDashboard.class));
      finish();
    }

    public  void  next(View view)
    {
        viewPager.setCurrentItem(currentPos+1);
    }

    private void addDots(int position)
    {
        dots= new TextView[4];

        SliderDots.removeAllViews();
        for(int i=0;i< dots.length;i++)
        {
          dots[i]= new TextView(this);
          dots[i].setText(Html.fromHtml("&#8226"));
          dots[i].setTextSize(35);

          SliderDots.addView(dots[i]);
        }

        if(dots.length>0)
        {
            dots[position].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    ViewPager2.OnPageChangeCallback pageChangeCallback= new ViewPager2.OnPageChangeCallback() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            super.onPageScrolled(position, positionOffset, positionOffsetPixels);
        }

        @Override
        public void onPageSelected(int position) {
            super.onPageSelected(position);

            currentPos=position;

            addDots(position);

            if(position==0)
            {
             lets_get_started.setVisibility(View.INVISIBLE);
            }
            else if(position==1)
            {
                lets_get_started.setVisibility(View.INVISIBLE);

            }
            else if(position==2)
            {
                lets_get_started.setVisibility(View.INVISIBLE);

            }
            else
            {
                animation= AnimationUtils.loadAnimation(OnBoarding.this,R.anim.bottom_anim);
                lets_get_started.setAnimation(animation);
                lets_get_started.setVisibility(View.VISIBLE);

            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            super.onPageScrollStateChanged(state);
        }
    };

}