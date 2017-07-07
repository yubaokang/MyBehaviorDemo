package com.example.ybk.mybehaviordemo.view;

import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.View;

import com.example.ybk.mybehaviordemo.utils.L;

/**
 * Created by ybk on 2017/6/11.
 */

public class MyNestedScrollView extends NestedScrollView {

    public static final String TAG = "MyNestedScrollView";

    public MyNestedScrollView(Context context) {
        super(context);
    }

    public MyNestedScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyNestedScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    ////////////////////////////////////////////////////////////////    ////////////////////////////////////////////////////////////////
    @Override
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        L.i("----------1>>>onStartNestedScrollaaaa");
        return super.onStartNestedScroll(child, target, nestedScrollAxes);
    }

    @Override
    public void onNestedScrollAccepted(View child, View target, int nestedScrollAxes) {
        L.i("----------1>>>onNestedScrollAccepted");
        super.onNestedScrollAccepted(child, target, nestedScrollAxes);
    }

    @Override
    public void onStopNestedScroll(View target) {
        L.i("----------1>>>onStopNestedScroll");
        super.onStopNestedScroll(target);
    }

    @Override
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        L.i("----------1>>>onNestedScroll");
        super.onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
    }

    @Override
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        L.i("----------1>>>onNestedPreScroll");
        super.onNestedPreScroll(target, dx, dy, consumed);
    }

    @Override
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        L.i("----------1>>>onNestedFling");
        return super.onNestedFling(target, velocityX, velocityY, consumed);
    }

    @Override
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        L.i("----------1>>>onNestedPreFling");
        return super.onNestedPreFling(target, velocityX, velocityY);
    }

    @Override
    public int getNestedScrollAxes() {
        L.i("----------1>>>getNestedScrollAxes");
        return super.getNestedScrollAxes();
    }
    ////////////////////////////////////////////////////////////////    ////////////////////////////////////////////////////////////////

    ////////////////////////////////////////////////////////////////    ////////////////////////////////////////////////////////////////
    @Override
    public void setNestedScrollingEnabled(boolean enabled) {
        L.i2("----------2>>>setNestedScrollingEnabled");
        super.setNestedScrollingEnabled(enabled);
    }

    @Override
    public boolean isNestedScrollingEnabled() {
        L.i2("----------2>>>isNestedScrollingEnabled");
        return super.isNestedScrollingEnabled();
    }

    @Override
    public boolean startNestedScroll(int axes) {
        L.i2("----------2>>>startNestedScroll");
        return super.startNestedScroll(axes);
    }

    @Override
    public void stopNestedScroll() {
        L.i2("----------2>>>stopNestedScroll");
        super.stopNestedScroll();
    }

    @Override
    public boolean hasNestedScrollingParent() {
        L.i2("----------2>>>hasNestedScrollingParent");
        return super.hasNestedScrollingParent();
    }

    @Override
    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow) {
        L.i2("----------2>>>dispatchNestedScroll");
        return super.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow);
    }

    /**
     * @param dx 表示子view此次滑动期间将要消耗的水平方法的距离
     * @param dy 表示子view此次滑动期间将要消耗的垂直方法的距离
     * @param consumed 一个两个长度的数组，这个数组传递给父view，如果父view要先行滑动，将会把消耗的距离通过此数据返回给子view
     * @param offsetInWindow 父view先完成一个滑动后子view在窗口中的偏移值
     * @return
     */
    @Override
    public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow) {
        L.i2("----------2>>>dispatchNestedPreScroll");
        return super.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow);
    }

    @Override
    public boolean dispatchNestedFling(float velocityX, float velocityY, boolean consumed) {
        L.i2("----------2>>>dispatchNestedFling");
        return super.dispatchNestedFling(velocityX, velocityY, consumed);
    }

    @Override
    public boolean dispatchNestedPreFling(float velocityX, float velocityY) {
        L.i2("----------2>>>dispatchNestedPreFling");
        return super.dispatchNestedPreFling(velocityX, velocityY);
    }
}
