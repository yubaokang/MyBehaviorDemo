package com.example.ybk.mybehaviordemo.nextScroll2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by ybk on 2017/8/25.
 */

public class NextChildView extends NestedScrollView {
    public NextChildView(Context context) {
        this(context, null);
    }

    public NextChildView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NextChildView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //获得父View
        NextContainerLayout parent = (NextContainerLayout) getParent();
        //高度设置为: 父View的高度或者当前控件的高度的较大值
        setMeasuredDimension(widthMeasureSpec, Math.max(parent.getMeasuredHeight(), getMeasuredHeight()));
    }
}
