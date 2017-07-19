package com.example.ybk.mybehaviordemo.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * http://hencoder.com/ui-1-1/
 * Created by ybk on 2017/7/13.
 */
public class MyView extends View {
    private Paint paint = new Paint(1);

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private RectF rectF = new RectF(200, 400, 600, 500);

    //点集
    private float[] points = {50, 50, 100, 100, 150, 150, 200, 200};

    private RectF rectArc = new RectF(200, 500, 500, 650);
    private RectF rectArc1 = new RectF(250, 500, 550, 650);
    private RectF rectArc2 = new RectF(200, 500, 500, 650);

    private Path path = new Path();

    private int endX = 100;
    private int endY = 100;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        paint.setColor(Color.RED);
//        paint.setAntiAlias(true);
//        paint.setStrokeWidth(5);
//        paint.setStyle(Paint.Style.STROKE);
//        canvas.drawCircle(200, 200, 100, paint);
//
//        paint.setColor(Color.BLACK);
//        canvas.drawRect(100, 100, 200, 200, paint);
//
//        paint.setColor(Color.BLUE);
//        paint.setStrokeWidth(50);
//        paint.setStrokeCap(Paint.Cap.ROUND);
////        canvas.drawPoint(200, 200, paint);
//        canvas.drawPoints(points, paint);
//
//        paint.setStyle(Paint.Style.FILL);
//        canvas.drawRoundRect(rectF, 20, 20, paint);
//
//        paint.setColor(Color.DKGRAY);
//        canvas.drawArc(rectArc, -100, 100, true, paint);
//        paint.setColor(Color.BLUE);
//        canvas.drawArc(rectArc, 0, 100, true, paint);
//        paint.setColor(Color.RED);
//        canvas.drawArc(rectArc, 100, 180, true, paint);

//        canvas.drawPath(path,paint);

        paint.setStrokeWidth(endX/3);
        canvas.drawLine(100, 100, endX, endY, paint);
        endX++;
        endY++;
//        requestLayout();
        invalidate();
    }
}
