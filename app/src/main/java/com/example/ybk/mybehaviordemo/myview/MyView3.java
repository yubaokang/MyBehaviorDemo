package com.example.ybk.mybehaviordemo.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * http://hencoder.com/ui-1-1/
 * Created by ybk on 2017/7/13.
 */
public class MyView3 extends View {
    public MyView3(Context context) {
        super(context);
    }

    public MyView3(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView3(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private Paint paint = new Paint();

    private int x1 = 100;
    private int x2 = 150;
    private int x3 = 200;

    private int y1 = 600;
    private int y2 = 300;
    private int y3 = 600;
    private boolean y1Up = true;
    private boolean y2Up = false;
    private boolean y3Up = true;

    private int step = 10;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setAntiAlias(true);

        paint.setStrokeWidth(10);
        paint.setColor(Color.BLACK);
        canvas.drawPoint(150, 450, paint);
        canvas.drawPoint(125, 450, paint);
        canvas.drawPoint(175, 450, paint);

        paint.setStrokeWidth(15);
        paint.setColor(Color.RED);
        canvas.drawPoint(x1, y1, paint);
        canvas.drawPoint(x2, y2, paint);
        canvas.drawPoint(x3, y3, paint);

        paint.setStrokeWidth(2);
        canvas.drawLine(x1, y1, x2, y2, paint);
        canvas.drawLine(x2, y2, x3, y3, paint);

        if (y1Up) {
            y1 += step;
            if (y1 >= 600) {
                y1Up = false;
            }
        } else {
            y1 -= step;
            if (y1 <= 300) {
                y1Up = true;
            }
        }

        if (y2Up) {
            y2 += step;
            if (y2 >= 600) {
                y2Up = false;
            }
        } else {
            y2 -= step;
            if (y2 <= 300) {
                y2Up = true;
            }
        }

        if (y3Up) {
            y3 += step;
            if (y3 >= 600) {
                y3Up = false;
            }
        } else {
            y3 -= step;
            if (y3 <= 300) {
                y3Up = true;
            }
        }
        if (isStarted)
            invalidate();
    }

    public boolean isStarted;

    public void start() {
        isStarted = true;
        invalidate();
    }

    public void stop() {
        isStarted = false;
        invalidate();
    }
}
