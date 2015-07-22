package com.example.guojun.simplehandlerexample;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import java.util.Date;


public class HandlerWorkWithMessageActivity extends Activity {


    private boolean runTask = true;
    private static Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_work_with_message);
        mHandler = new MyHandler(HandlerWorkWithMessageActivity.this);
    }


    static class MyHandler extends Handler {
        private final HandlerWorkWithMessageActivity theActivity;

        public MyHandler(HandlerWorkWithMessageActivity activity) {
            super();
            theActivity = activity;
        }

        @Override
        public void handleMessage(Message msg) {

            TextView textView = (TextView) theActivity
                    .findViewById(R.id.messageTextView);
            String theMsgFromTask = msg.getData().getString("messageFromTask");
            textView.setText(theMsgFromTask);

            super.handleMessage(msg);
        }

    }

    private class MyTask implements Runnable {

        @Override
        public void run() {

            while (runTask) {
                String messageStr = new Date().toString();
                Bundle bundle = new Bundle();
                bundle.putString("messageFromTask", messageStr);

                Message message = new Message();
                //Message	message = mHandler.obtainMessage();
                message.setData(bundle);

                mHandler.sendMessage(message);
                //message.sendToTarget();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    public void onStartTimer(View v) {
        runTask = true;
        Thread t = new Thread(new MyTask());
        t.start();

    }

    public void onStopTimer(View v) {

        runTask = false;
    }
}
