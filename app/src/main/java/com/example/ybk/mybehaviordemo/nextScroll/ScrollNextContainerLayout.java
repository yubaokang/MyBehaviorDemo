package com.example.ybk.mybehaviordemo.nextScroll;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.View;

import com.example.ybk.mybehaviordemo.utils.L;

/**
 * Created by ybk on 2017/6/12.
 */
public class ScrollNextContainerLayout extends NestedScrollView implements NestedScrollingParent {

    private NestedScrollingParentHelper parentHelper;

//    private ViewDragHelper viewDragHelper;

    public ScrollNextContainerLayout(Context context) {
        this(context, null);
    }

    public ScrollNextContainerLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    private int childTop;
    private int afterTop;

    public ScrollNextContainerLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        parentHelper = new NestedScrollingParentHelper(this);
//        viewDragHelper = ViewDragHelper.create(this, 1.0f, new ViewDragHelper.Callback() {
//            @Override
//            public boolean tryCaptureView(View child, int pointerId) {
//                childTop = child.getTop();
//                return true;
//            }
//            @Override
//            public int clampViewPositionVertical(View child, int top, int dy) {
//                return top;
//            }
//
//            @Override
//            public int clampViewPositionHorizontal(View child, int left, int dx) {
//                return left;
//            }
//
//            @Override
//            public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {
//                afterTop = top;
//                super.onViewPositionChanged(changedView, left, top, dx, dy);
//            }
//
//            @Override
//            public void onViewReleased(View releasedChild, float xvel, float yvel) {
//                L.i("----parent>>>"+xvel + "-----" + yvel);
//                if (Math.abs(afterTop - childTop) > 200) {
//                    viewDragHelper.settleCapturedViewAt(0, 5 * (afterTop - childTop));
//                } else {
//                    viewDragHelper.settleCapturedViewAt(500, 300);
//                }
//                invalidate();
//            }
//        });
    }


//    @Override
//    public void computeScroll() {
//        super.computeScroll();
//        if (viewDragHelper.continueSettling(true)) {
//            invalidate();
//        }
//    }
//
//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        return viewDragHelper.shouldInterceptTouchEvent(ev);
//    }
//
//    @Override
//    public boolean onTouchEvent(MotionEvent ev) {
//        viewDragHelper.processTouchEvent(ev);
//        return true;
//    }

    @Override
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        return true;
    }

    @Override
    public void onNestedScrollAccepted(View child, View target, int axes) {
        parentHelper.onNestedScrollAccepted(child, target, axes);
    }

    @Override
    public void onStopNestedScroll(View child) {
        parentHelper.onStopNestedScroll(child);
    }

    @Override
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
    }

    @Override
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        L.i("=====dx=" + dx + "---dy=" + dy + "---target.top=" + target.getTop());
//        if (target.getTop() >= 0 && dy < 0) {//向下滑动
////            dy = target.getBottom() + dy - getHeight();
//            L.i("--------->>>00dy="+dy);
//            offsetTopAndBottom(dy);
//            consumed[1] += dy;
//        } else if (dy > 0 && getTop() > 0) {//向上滑动
////            dy = dy + target.getTop();
//            L.i("--------->>>11dy="+dy);
//            offsetTopAndBottom(dy);
//            consumed[1] += dy;
//        }
//        offsetTopAndBottom(dy);
//        consumed[1] += dy;
        if (target == child_0) {
            child_1.offsetTopAndBottom(dy);
            child_2.offsetTopAndBottom(dy);
        } else if (target == child_1) {
            child_0.offsetTopAndBottom(dy);
            child_2.offsetTopAndBottom(dy);
        } else if (target == child_2) {
            child_0.offsetTopAndBottom(dy);
            child_1.offsetTopAndBottom(dy);
        }
    }

    private ScrollChildContainerLayout child_0;
    private ScrollChildContainerLayout child_1;
    private ScrollChildContainerLayout child_2;

    public ScrollChildContainerLayout getChild_0() {
        return child_0;
    }

    public void setChild_0(ScrollChildContainerLayout child_0) {
        this.child_0 = child_0;
    }

    public ScrollChildContainerLayout getChild_1() {
        return child_1;
    }

    public void setChild_1(ScrollChildContainerLayout child_1) {
        this.child_1 = child_1;
    }

    public ScrollChildContainerLayout getChild_2() {
        return child_2;
    }

    public void setChild_2(ScrollChildContainerLayout child_2) {
        this.child_2 = child_2;
    }

    @Override
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        return super.onNestedFling(target, velocityX, velocityY, consumed);
    }

    @Override
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        return super.onNestedPreFling(target, velocityX, velocityY);
    }

    @Override
    public int getNestedScrollAxes() {
        return parentHelper.getNestedScrollAxes();
    }
}
