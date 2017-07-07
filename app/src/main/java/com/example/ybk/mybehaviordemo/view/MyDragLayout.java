package com.example.ybk.mybehaviordemo.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import com.example.ybk.mybehaviordemo.utils.L;

/**
 * Created by ybk on 2017/6/12.
 */
public class MyDragLayout extends FrameLayout {

    private ViewDragHelper dragHelper;

    public MyDragLayout(Context context) {
        this(context, null);
    }

    public MyDragLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    private int childLeft;
    private int childTop;

    public MyDragLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        dragHelper = ViewDragHelper.create(this, 1.0f, new ViewDragHelper.Callback() {
            @Override
            public boolean tryCaptureView(View child, int pointerId) {
                childLeft = child.getLeft();
                childTop = child.getTop();
                return true;
            }

            @Override
            public int clampViewPositionHorizontal(View child, int left, int dx) {
                return left;
            }

            @Override
            public int clampViewPositionVertical(View child, int top, int dy) {
                return top;
            }

            @Override
            public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {
                after_left = left;
                after_top = top;
                super.onViewPositionChanged(changedView, left, top, dx, dy);
            }

            @Override
            public void onViewReleased(View releasedChild, float xvel, float yvel) {
                L.i(xvel + "-----" + yvel);
                if (Math.abs(after_top - childTop) > 200 || Math.abs(after_left - childLeft) > 200) {
                    dragHelper.settleCapturedViewAt(5 * (after_top - childTop), 5 * (after_left - childLeft));
                } else {
                    dragHelper.settleCapturedViewAt((int) (0.5 * (parentWidth - releasedChild.getWidth())), (int) (0.5 * (parentHeight - releasedChild.getHeight())));
                }
                invalidate();
            }
        });
    }

    private int after_left;
    private int after_top;

    @Override
    public void computeScroll() {
        if (dragHelper.continueSettling(true)) {
            invalidate();
        }
    }

    private int autoBackViewOriginLeft;
    private int autoBackViewOriginTop;

    private View autoBackView;

    private int parentWidth;
    private int parentHeight;

    public void setAutoBackView(View autoBackView) {
        this.autoBackView = autoBackView;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        parentWidth = getWidth();
        parentHeight = getHeight();
//        autoBackViewOriginLeft = autoBackView.getLeft();
//        autoBackViewOriginTop = autoBackView.getTop();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return dragHelper.shouldInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        dragHelper.processTouchEvent(event);
        return true;
    }
}
