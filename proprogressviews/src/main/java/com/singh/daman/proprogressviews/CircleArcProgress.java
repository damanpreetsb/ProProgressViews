package com.singh.daman.proprogressviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by damanpreet.singh on 08-03-2017.
 */

public class CircleArcProgress extends View {

    private Paint paint=new Paint();
    private int startAngle=120;
    private int startAngle2=240;
    private RectF oval=new RectF();
    private int sweepAngle=100;

    private float in_rad;
    private float out_rad;
    private int colorArc;
    private int colorArc2;

    public CircleArcProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint.setStyle(Paint.Style.STROKE);
        TypedArray array=context.getTheme().obtainStyledAttributes(attrs,R.styleable.CircleArcProgress,0,0);
        try{
            in_rad=array.getDimension(R.styleable.CircleArcProgress_circle_size,50);
            colorArc=array.getColor(R.styleable.CircleArcProgress_color_circle, Color.parseColor("#5C6BC0"));
            out_rad=array.getDimension(R.styleable.CircleArcProgress_arc_radius,70);
            colorArc2=array.getColor(R.styleable.CircleArcProgress_arc_color, Color.parseColor("#1A237E"));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            array.recycle();
        }
        post(animator);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(colorArc);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(getWidth()/2,getHeight()/2, in_rad, paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(colorArc2);
        paint.setStrokeWidth(10);
        oval.set(getWidth()/2-out_rad,getHeight()/2-out_rad,getWidth()/2+out_rad,getHeight()/2+out_rad);
        canvas.drawArc(oval,startAngle2,sweepAngle,false,paint);
    }

    Runnable animator=new Runnable() {
        @Override
        public void run() {

            if(startAngle2>=1){
                startAngle2-=15;
            }
            else{
                startAngle2=360;
            }
            invalidate();
            postDelayed(this,30);
        }
    };
}

