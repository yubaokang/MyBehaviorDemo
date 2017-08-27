package com.example.ybk.mybehaviordemo.nextScroll3;

import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;

/**
 * Created by yubao on 2017/8/26.
 */

public class NextNestedLayout extends NestedScrollView {
    public NextNestedLayout(Context context) {
        this(context, null);
    }

    public NextNestedLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NextNestedLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {
        setOnScrollChangeListener(new OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                Log.i("AAA", scrollY + "--" + pageOne.getMeasuredHeight());
                if (scrollY >= pageOne.getMeasuredHeight() - getMeasuredHeight()) {
                    scrollTo(0, pageOne.getMeasuredHeight() - getMeasuredHeight());
                }
            }
        });
    }

    private NextLinearLayout childView;

    private ViewGroup pageOne;
    private ViewGroup pageTwo;

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        childView = (NextLinearLayout) getChildAt(0);
        pageOne = (ViewGroup) childView.getChildAt(0);
        pageTwo = (ViewGroup) childView.getChildAt(1);
    }


}
