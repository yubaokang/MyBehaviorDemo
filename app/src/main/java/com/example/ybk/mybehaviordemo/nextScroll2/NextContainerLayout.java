package com.example.ybk.mybehaviordemo.nextScroll2;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by ybk on 2017/8/25.
 */
public class NextContainerLayout extends LinearLayout implements NestedScrollingParent {
    public NextContainerLayout(@NonNull Context context) {
        this(context, null);
    }

    public NextContainerLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NextContainerLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {

    }

    /**
     * 子View调用NestedScrollingChild.startNestedScroll方法后，该方法会被调用
     *
     * @param child            包含触发嵌套滚动的view的对象
     * @param target           触发嵌套滚动的view  (在这里如果不涉及多层嵌套的话,child和target)是相同的
     * @param nestedScrollAxes 滚动方向
     * @return 是否响应子控件的滚动
     */
    @Override
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        return (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_CANCEL:
                break;
            default:
                break;
        }
        return super.onTouchEvent(ev);
    }

    /**
     * NestedScrollingParent.onStartNestedScroll 返回为true的时候回调该方法
     * --->
     * ---> 可以在这里做一些初始化的事情
     *
     * @param child  包含触发嵌套滚动的view的对象
     * @param target 触发嵌套滚动的view  (在这里如果不涉及多层嵌套的话,child和target)是相同的
     * @param axes   滚动方向
     */
    @Override
    public void onNestedScrollAccepted(View child, View target, int axes) {
        super.onNestedScrollAccepted(child, target, axes);
    }

    /**
     * 嵌套滑动：预滑动
     * <p>
     * 当子view调用子View调用NestedScrollingChild.dispatchNestedPreScroll方法是,会调用该方法.
     * <p>
     * 该方法会传入内部View移动的dx，dy；
     * 如果需要消耗一定的dx,dy，就通过最后面参数int[] consumed进行制定；
     * 例如：需要消耗一半的dy,就可以写成consumed[1]=dy/2；
     * <p>
     * a:在当前的这个控件需求下--->>
     * a1:如果是上滑且顶部控件未完全隐藏，则消耗掉dy，即consumed[1]=dy;
     * a2:如果是下滑且内部View已经无法继续下滑(到顶了)，则消耗掉dy,即consumed[1]=dy
     * 消耗掉的意识是自己去执行scrollBy，实际上就是我们的StickNavLayout滑动
     *
     * @param target   触发嵌套滚动的view
     * @param dx       表示target本次滚动产生的x方向的滚动总距离
     * @param dy       表示target本次滚动产生的y方向的滚动总距离
     * @param consumed 表示父布局要消费的滚动距离,consumed[0]和consumed[1]分别表示父布局在x和y方向上消费的距离.
     */
    @Override
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
//        super.onNestedPreScroll(target, dx, dy, consumed);
        //getScrollY() 记录滑动的距离
        if (!ViewCompat.canScrollVertically(target,1)){
            scrollBy(0,dy);
            consumed[1]=dy;
        }
//        if (dy > 0) {//向上滑动
//            if (getScrollY() < mTopViewHeight) {//已经滑动的y距离小于上面View的距离，则还需要消费距离
//                scrollBy(0, dy);
//                consumed[1] = dy;
//            }
//        } else {//向下滚动
//            if (getScrollY() >= 0 && !ViewCompat.canScrollVertically(target, -1)) {//方向参数  -1：顶部是否可以滚动，1：底部是否可以滚动
//                scrollBy(0, dy);
//                consumed[1] = dy;
//            }
//        }
    }

    /**
     * 当子View调用了dispatchNestedScroll方法是，会调用该方法
     *
     * @param target       触发嵌套滚动的View
     * @param dxConsumed   表示target已经消费的x距离
     * @param dyConsumed   表示target已经消费的y距离
     * @param dxUnconsumed 表示x方向剩下的距离
     * @param dyUnconsumed 表示y方向剩下的距离
     */
    @Override
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
    }

    //你可以捕获对内部View的fling事件，如果return true则表示拦截掉内部View的事件。
    @Override
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
//        return super.onNestedPreFling(target, velocityX, velocityY);
        return false;
    }

    /**
     * @param target    触发嵌套滚动的View
     * @param velocityX x方向fling的速度   px/s,像素每秒
     * @param velocityY y方向fling的速度   px/s,像素每秒
     * @param consumed
     * @return
     */
    @Override
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
//        Log.d(TAG, "onNestedFling() called with:velocityX = [" + velocityX + "], velocityY = [" + velocityY + "], consumed = [" + consumed + "]");
//        //如果是recyclerView 根据判断第一个元素是哪个位置可以判断是否消耗
//        //这里判断如果第一个元素的位置是大于TOP_CHILD_FLING_THRESHOLD的
//        //认为已经被消耗，在animateScroll里不会对velocityY<0时做处理
//        if (target instanceof RecyclerView && velocityY < 0) {
//            final RecyclerView recyclerView = (RecyclerView) target;
//            final View firstChild = recyclerView.getChildAt(0);
//            final int childAdapterPosition = recyclerView.getChildAdapterPosition(firstChild);
//            consumed = childAdapterPosition > TOP_CHILD_FLING_THRESHOLD;
//        }
//        if (!consumed) {
//            animateScroll(velocityY, computeDuration(0), consumed);
//        } else {
//            animateScroll(velocityY, computeDuration(velocityY), consumed);
//        }
        return super.onNestedFling(target, velocityX, velocityY, consumed);
    }

    @Override
    public int getNestedScrollAxes() {
        return super.getNestedScrollAxes();
    }

    /**
     * 根据速度计算滚动动画持续时间
     *
     * @param velocityY
     * @return
     */
    private int computeDuration(float velocityY) {
        final int distance = 0;
//        if (velocityY > 0) {
//            distance = Math.abs(mTop.getHeight() - getScrollY());
//        } else {
//            distance = Math.abs(mTop.getHeight() - (mTop.getHeight() - getScrollY()));
//        }
        final int duration;
        velocityY = Math.abs(velocityY);
        if (velocityY > 0) {
            duration = 3 * Math.round(1000 * (distance / velocityY));
        } else {
            final float distanceRatio = (float) distance / getHeight();
            duration = (int) ((distanceRatio + 1) * 150);
        }
        return duration;
    }

    private ValueAnimator mOffsetAnimator;

    private void animateScroll(float velocityY, final int duration, boolean consumed) {
        final int currentOffset = getScrollY();
//        final int topHeight = mTop.getHeight();
        final int topHeight = 100;
        if (mOffsetAnimator == null) {
            mOffsetAnimator = new ValueAnimator();
//            mOffsetAnimator.setInterpolator(mInterpolator);
            mOffsetAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    if (animation.getAnimatedValue() instanceof Integer) {
                        scrollTo(0, (Integer) animation.getAnimatedValue());
                    }
                }
            });
        } else {
            mOffsetAnimator.cancel();
        }
        mOffsetAnimator.setDuration(Math.min(duration, 600));

        if (velocityY >= 0) {
            mOffsetAnimator.setIntValues(currentOffset, topHeight);
            mOffsetAnimator.start();
        } else {
            //如果子View没有消耗down事件 那么就让自身滑倒0位置
            if (!consumed) {
                mOffsetAnimator.setIntValues(currentOffset, 0);
                mOffsetAnimator.start();
            }

        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        getChildAt(0).measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
//        //设置ViewPager的高度
//        ViewGroup.LayoutParams params = mViewPager.getLayoutParams();
//        params.height = getMeasuredHeight() - mNav.getMeasuredHeight();
//        //设置当前布局的高度，mTop，mNav，mViewPager三者的高度总和
//        setMeasuredDimension(getMeasuredWidth(), mTop.getMeasuredHeight() + mNav.getMeasuredHeight() + mViewPager.getMeasuredHeight());
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
//        mTopViewHeight = mTop.getMeasuredHeight();
    }

    @Override
    public void scrollTo(int x, int y) {
//        Log.d(TAG, "scrollTo() called with: x = [" + x + "], y = [" + y + "]");
//        if (y < 0) {
//            y = 0;
//        }
//        if (y > mTopViewHeight) {
//            y = mTopViewHeight;
//        }
//        if (y != getScrollY()) {
//            super.scrollTo(x, y);
//        }
    }

    @Override
    public void computeScroll() {
//        if (mScroller.computeScrollOffset()) {
//            scrollTo(0, mScroller.getCurrY());
//            invalidate();
//        }
    }
}
