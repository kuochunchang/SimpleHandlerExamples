package com.example.guojun.simplehandlerexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void onStartExample1(View v){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, StartThreadActivity.class);
        startActivity(intent);
    }

    public void onStartExample2(View v){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, HandlerWorkWithMessageActivity.class);
        startActivity(intent);
    }

}
