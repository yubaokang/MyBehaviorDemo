package com.example.ybk.mybehaviordemo.eventDemo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by yubao on 2017/8/28.
 */

public class EventDemoLayout extends LinearLayout {
    private static final String TAG = "------EventDemoLayout";

    public EventDemoLayout(Context context) {
        super(context);
    }

    public EventDemoLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public EventDemoLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(TAG, "dispatchTouchEvent");
//        return false;
        //        return false;
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d(TAG, "onInterceptTouchEvent");
        //        return true;
        //        return false;
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "onTouchEvent");
        //        return true;
        //        return false;
        return super.onTouchEvent(event);
    }
}
