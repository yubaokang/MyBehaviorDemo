package com.example.ybk.mybehaviordemo.eventDemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;

import com.example.ybk.mybehaviordemo.R;

public class EventDemoActivity extends AppCompatActivity {
    private static final String TAG = "------EventDemoActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_demo);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(TAG, "dispatchTouchEvent");
        //        return true;
        //        return false;
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "onTouchEvent");
        //        return true;
        //        return false;
        return super.onTouchEvent(event);
    }

    @Override
    protected void onUserLeaveHint() {
        Log.d(TAG, "onTouchEvent");
        super.onUserLeaveHint();
    }
}
