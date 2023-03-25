package com.example.cityguideapp.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.cityguideapp.R;

public class RetalierStartupScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAGS_CHANGED, WindowManager.LayoutParams.FLAGS_CHANGED);
        setContentView(R.layout.activity_retalier_startup_screen);
    }

    public  void callLoginScreen(View view)
    {
        startActivity(new Intent(RetalierStartupScreen.this,Login.class));
    }



}