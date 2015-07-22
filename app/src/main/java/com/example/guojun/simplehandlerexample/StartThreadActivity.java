package com.example.guojun.simplehandlerexample;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.TextView;


public class StartThreadActivity extends Activity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_thread);
        countdown();
    }

    private void countdown() {
        final int count = 20;
        textView = (TextView) findViewById(R.id.textView2);
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {

                for (int i = count; i >= 0; i--) {
                    final int value = i;
                    Log.i("StartThreadActivity","Countdown="+i);

                   new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            // update the context of TextView  of the activity directly.
                            textView.setText(String.valueOf(value));
                        }
                    });

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        t.start();

    }
}
