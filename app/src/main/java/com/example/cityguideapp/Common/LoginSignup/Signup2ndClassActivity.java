package com.example.cityguideapp.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cityguideapp.R;

public class Signup2ndClassActivity extends AppCompatActivity {

    ImageView backBtn;
    Button login,next;
    TextView titleText;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2nd_class);

        backBtn=findViewById(R.id.signup_back_btn);
        login=findViewById(R.id.signup_login_btn);
        next=findViewById(R.id.signup_next_btn);
        titleText=findViewById(R.id.signup_title_text);
    }

    public  void callNextSignupScreen(View view)
    {
        Intent intent=new Intent(Signup2ndClassActivity.this,Signup3rdClassActivity.class);

        Pair[] pairs= new Pair[4];

        pairs[0]=new Pair<View,String>(backBtn,"transition_back_arrow_btn");
        pairs[1]=new Pair<View,String>(titleText,"transition_title_next");
        pairs[2]=new Pair<View,String>(next,"transition_next_btn");
        pairs[3]=new Pair<View,String>(login,"transition_login_btn");

        ActivityOptions activityOptions=ActivityOptions.makeSceneTransitionAnimation(Signup2ndClassActivity.this,pairs);
        startActivity(intent);
    }

}