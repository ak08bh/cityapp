package com.example.cityguideapp.User;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.cityguideapp.R;

public class AllCategory extends AppCompatActivity {

    ImageView back_pressed;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_category);

        back_pressed =findViewById(R.id.back_pressed);

        back_pressed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AllCategory.super.onBackPressed();
            }
        });

    }
}