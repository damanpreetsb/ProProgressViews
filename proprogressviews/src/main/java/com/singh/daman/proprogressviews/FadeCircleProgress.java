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

public class FadeCircleProgress extends View {

    Paint paint = new Paint();
    float animationProgress;
    private float radius;
    private int colorArc;
    private int alpha;
    private float minRad;
    boolean zoom = false;
    private int speed;
    private int fadeSpeed;

    public FadeCircleProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint.setStyle(Paint.Style.FILL);
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
        TypedArray array = context.getTheme().obtainStyledAttributes(attrs, R.styleable.FadeCircleProgress, 0, 0);
        try {
            radius = array.getDimension(R.styleable.FadeCircleProgress_radius, 50);
            colorArc = array.getColor(R.styleable.FadeCircleProgress_color, Color.parseColor("#1A237E"));
            minRad = array.getDimension(R.styleable.FadeCircleProgress_minimum_radius, 10);
            speed = array.getInteger(R.styleable.FadeCircleProgress_speed, 1);
            fadeSpeed = array.getInteger(R.styleable.FadeCircleProgress_fade_speed, 5);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            array.recycle();
        }
        paint.setColor(colorArc);
        post(animator);
    }

    @Override
    public void onDraw(Canvas canvas) {
        paint.setAlpha(alpha);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, animationProgress, paint);
    }

    Runnable animator = new Runnable() {
        @Override
        public void run() {
            if (zoom) {
                animationProgress -= speed;
                alpha += fadeSpeed;
            }
            if (!zoom) {
                animationProgress += speed;
                alpha -= fadeSpeed;
            }
            if (animationProgress >= radius) {
                zoom = true;
            }
            if (animationProgress <= minRad) {
                zoom = false;
            }
            invalidate();
            postDelayed(this, 30);
        }
    };
}
