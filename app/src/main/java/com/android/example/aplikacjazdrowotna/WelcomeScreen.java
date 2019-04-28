package com.android.example.aplikacjazdrowotna;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import static java.lang.Thread.sleep;

public class WelcomeScreen extends AppCompatActivity {

    private TextView text_welcome;
    private ImageView welcome_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        text_welcome = findViewById(R.id.text_welcome);
        welcome_logo= findViewById(R.id.welcome_logo);

        Animation anim = AnimationUtils.loadAnimation(this,R.anim.welcome_transition);
        text_welcome.startAnimation(anim);
        welcome_logo.startAnimation(anim);

        final Intent i = new Intent(this, MainActivity.class);
        Thread timer = new Thread(){
        public void run(){
            try{
                sleep(5000);
            } catch (InterruptedException e){
                e.printStackTrace();
            } finally {
                startActivity(i);
                finish();
            }
        }
        }  ;
        timer.start();

    }}
