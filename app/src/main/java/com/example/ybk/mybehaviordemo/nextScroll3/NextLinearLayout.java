package com.example.ybk.mybehaviordemo.nextScroll3;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by yubao on 2017/8/26.
 */
public class NextLinearLayout extends LinearLayout {
    public NextLinearLayout(Context context) {
        this(context, null);
    }

    public NextLinearLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NextLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void measureChild(View child, int parentWidthMeasureSpec, int parentHeightMeasureSpec) {
        super.measureChild(child, parentWidthMeasureSpec, Math.max(child.getMeasuredHeight(), getMeasuredHeight()));
    }

    private ViewGroup pageOne;
    private ViewGroup pageTwo;

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        pageOne = (ViewGroup) getChildAt(0);
        pageTwo = (ViewGroup) getChildAt(1);
    }

    private ViewDragHelper dragHelper;
    int childTop;
    private int after_top;

    public void init() {
        dragHelper = ViewDragHelper.create(this, 1.0f, new ViewDragHelper.Callback() {
            @Override
            public boolean tryCaptureView(View child, int pointerId) {
                childTop = child.getTop();
                boolean aa = pageOne == child && ((NextNestedLayout) getParent()).getScrollY() >= pageOne.getMeasuredHeight() - ((NextNestedLayout) getParent()).getMeasuredHeight();
                return aa;
//                return true;
            }

            @Override
            public int clampViewPositionHorizontal(View child, int left, int dx) {
                return 0;
            }

            @Override
            public int clampViewPositionVertical(View child, int top, int dy) {
                return top;
            }

            @Override
            public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {
                after_top = top;
                super.onViewPositionChanged(changedView, left, top, dx, dy);
            }

            @Override
            public void onViewReleased(View releasedChild, float xvel, float yvel) {
                if (Math.abs(after_top - childTop) > 200) {//恢复
                    dragHelper.settleCapturedViewAt(0, pageOne.getMeasuredHeight());
                } else {//下一页
                    dragHelper.settleCapturedViewAt(0, pageOne.getMeasuredHeight() + ((NextNestedLayout) getParent()).getMeasuredHeight());
                }
                invalidate();
//                postInvalidate();
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        dragHelper.processTouchEvent(event);
        return true;
    }

    @Override
    public void computeScroll() {
        if (dragHelper.continueSettling(true)) {
            invalidate();
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return dragHelper.shouldInterceptTouchEvent(ev);
    }
}
