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

public class SignUp extends AppCompatActivity
{

    ImageView backBtn;
    TextView title;
    Button nextBtn,loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        backBtn=findViewById(R.id.signup_back_btn);
        title=findViewById(R.id.signup_title_text);
        nextBtn=findViewById(R.id.signup_next_btn);
        loginBtn=findViewById(R.id.signup_login_btn);

    }

    public  void callNextSignupScreen(View view)
    {
        Intent intent=new Intent(SignUp.this,Signup2ndClassActivity.class);

        Pair[] pairs= new Pair[4];

        pairs[0]=new Pair<View,String>(backBtn,"transition_back_arrow_btn");
        pairs[1]=new Pair<View,String>(title,"transition_title_next");
        pairs[2]=new Pair<View,String>(nextBtn,"transition_next_btn");
        pairs[3]=new Pair<View,String>(loginBtn,"transition_login_btn");

        ActivityOptions activityOptions=ActivityOptions.makeSceneTransitionAnimation(SignUp.this,pairs);
        startActivity(intent);
    }


}