package com.example.ybk.mybehaviordemo.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 雷达扫描
 */
public class MyView2 extends View {
    private Paint paint = new Paint(1);

    public MyView2(Context context) {
        super(context);
    }

    public MyView2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private Shader shader = new SweepGradient(300, 300, Color.parseColor("#e91e63"), Color.parseColor("#aa1e63"));
    private int rotate = 0;
    private Matrix matrix = new Matrix();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        matrix.setRotate(rotate, 300, 300);
        shader.setLocalMatrix(matrix);
        paint.setShader(shader);
        paint.setDither(true);
        canvas.drawCircle(300, 300, 150, paint);
        if (rotate >= 360) {
            rotate = rotate % 360;
        }
        rotate += 3;
        invalidate();
    }
}
