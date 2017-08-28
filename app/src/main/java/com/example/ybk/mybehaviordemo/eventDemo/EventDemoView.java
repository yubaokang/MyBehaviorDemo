package com.example.ybk.mybehaviordemo.eventDemo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by yubao on 2017/8/28.
 */

public class EventDemoView extends AppCompatTextView {
    private static final String TAG = "------EventDemoView";

    public EventDemoView(Context context) {
        super(context);
    }

    public EventDemoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public EventDemoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d(TAG, "dispatchTouchEvent");
        //        return true;
        //        return false;
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "onTouchEvent");
        //        return true;
        //        return false;
        return super.onTouchEvent(event);
    }

}
