package com.example.cityguideapp.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cityguideapp.R;
import com.example.cityguideapp.User.UserDashboard;

public class SplashScreen extends AppCompatActivity
{

 private  static  int SPLASH_TIMER=5000;
    ImageView background_image;
    TextView power_by_line;
    SharedPreferences sharedPreferences;
    Animation sideAnim, bottomAnim;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);


        background_image=findViewById(R.id.background_image);
        power_by_line=findViewById(R.id.power_by_line);


        sideAnim= AnimationUtils.loadAnimation(this,R.anim.side_anim);
        bottomAnim= AnimationUtils.loadAnimation(this,R.anim.bottom_anim);


        background_image.setAnimation(sideAnim);
        power_by_line.setAnimation(bottomAnim);


        new Handler().postDelayed(new Runnable()
        {

            @Override
            public void run() {

                sharedPreferences= getSharedPreferences("onBoarding",MODE_PRIVATE);
                boolean isFirstTime= sharedPreferences.getBoolean("firstTime",true);

                if(isFirstTime)
                {

                    SharedPreferences.Editor editor= sharedPreferences.edit();
                    editor.putBoolean("firstTime",false);
                    editor.commit();

                    Intent intent =new Intent(SplashScreen.this, OnBoarding.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Intent intent =new Intent(SplashScreen.this, UserDashboard.class);
                    startActivity(intent);
                    finish();
                }


            }
        },SPLASH_TIMER);


    }
}