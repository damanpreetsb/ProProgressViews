package com.singh.daman.proprogressviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;


/**
 * Created by daman on 29/4/17.
 */

public class DotsZoomProgress extends View {

    Paint paint = new Paint();
    Paint innerPaint = new Paint();
    Paint midPaint = new Paint();
    float animationProgress;
    float animationProgress2;
    float animationProgress3;
    private float inRad;
    private float outRad;
    private int colorArc;
    private int colorArc2;
    private float midRad;
    private int colorArc3;

    private int outerAlpha, midAlpha;

    private float minRad;

    float distance, distance2;

    private float speed;

    boolean zoom = false;
    boolean zoom2 = false;
    boolean zoom3 = false;

    public DotsZoomProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint.setStyle(Paint.Style.FILL);
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
        innerPaint.setStyle(Paint.Style.FILL);
        innerPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        midPaint.setStyle(Paint.Style.FILL);
        midPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        TypedArray array = context.getTheme().obtainStyledAttributes(attrs, R.styleable.DotsZoomProgress, 0, 0);
        try {
            inRad = array.getDimension(R.styleable.DotsZoomProgress_inner_radius, 50);
            colorArc = array.getColor(R.styleable.DotsZoomProgress_inner_color, Color.parseColor("#5C6BC0"));
            outRad = array.getDimension(R.styleable.DotsZoomProgress_outer_radius, 90);
            colorArc2 = array.getColor(R.styleable.DotsZoomProgress_outer_color, Color.parseColor("#1A237E"));
            midRad = array.getDimension(R.styleable.DotsZoomProgress_mid_radius, 70);
            colorArc3 = array.getColor(R.styleable.DotsZoomProgress_mid_color, Color.parseColor("#1A237E"));
            minRad = array.getDimension(R.styleable.DotsZoomProgress_min_radius, 10);
            speed = array.getFloat(R.styleable.DotsZoomProgress_zoom_speed, 10);
            midAlpha = array.getInteger(R.styleable.DotsZoomProgress_mid_alpha, 50);
            outerAlpha = array.getInt(R.styleable.DotsZoomProgress_outer_alpha, 100);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            array.recycle();
        }
        paint.setColor(colorArc2);
        innerPaint.setColor(colorArc);
        midPaint.setColor(colorArc3);

        paint.setAlpha(outerAlpha);
        midPaint.setAlpha(midAlpha);
        distance = outRad - inRad;
        distance2 = midRad - inRad;
        speed = speed/10;

        post(animator);

    }


    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, animationProgress, paint);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, animationProgress3, midPaint);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, animationProgress2, innerPaint);
    }

    Runnable animator = new Runnable() {
        @Override
        public void run() {

            if (zoom) {
                animationProgress -= speed;
            }
            if (!zoom) {
                animationProgress += speed;
            }
            if (animationProgress >= outRad) {
                zoom = true;
            }
            if (animationProgress <= minRad + distance) {
                zoom = false;
            }
            if (zoom3) {
                animationProgress3 -= speed;
            }
            if (!zoom3) {
                animationProgress3 += speed;
            }
            if (animationProgress3 >= midRad) {
                zoom3 = true;
            }
            if (animationProgress3 <= minRad + distance2) {
                zoom3 = false;
            }
            if (zoom2) {
                animationProgress2 -= speed;
            }
            if (!zoom2) {
                animationProgress2 += speed;
            }
            if (animationProgress2 >= inRad) {
                zoom2 = true;
            }
            if (animationProgress2 <= minRad) {
                zoom2 = false;
            }
            invalidate();
            postDelayed(this, 30);
        }
    };
}
