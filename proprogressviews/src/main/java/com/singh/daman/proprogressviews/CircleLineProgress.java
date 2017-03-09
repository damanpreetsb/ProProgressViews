package com.singh.daman.proprogressviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by damanpreet.singh on 07-03-2017.
 */

public class CircleLineProgress extends View {

    private Paint paint=new Paint();
    private int startAngle=120;
    private RectF oval=new RectF();
    private int sweepAngle=360;
    private int sweepAngle2=10;
    private float in_rad;
    private float out_rad;
    private int colorArc;
    private int colorArc2;

    public CircleLineProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint.setStyle(Paint.Style.STROKE);
        TypedArray array=context.getTheme().obtainStyledAttributes(attrs,R.styleable.CircleLineProgress,0,0);
        try{
            in_rad=array.getDimension(R.styleable.CircleLineProgress_circle_radius,50);
            colorArc=array.getColor(R.styleable.CircleLineProgress_circle_color, Color.parseColor("#5C6BC0"));
            out_rad=array.getDimension(R.styleable.CircleLineProgress_line_radius,50);
            colorArc2=array.getColor(R.styleable.CircleLineProgress_line_color, Color.parseColor("#1A237E"));
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
        paint.setStrokeWidth(7);
        oval.set(getWidth()/2-in_rad,getHeight()/2-in_rad,getWidth()/2+in_rad,getHeight()/2+in_rad);
        canvas.drawArc(oval,startAngle,sweepAngle,false,paint);

        paint.setColor(colorArc2);
        paint.setStrokeWidth(50);
        oval.set(getWidth()/2-out_rad,getHeight()/2-out_rad,getWidth()/2+out_rad,getHeight()/2+out_rad);
        canvas.drawArc(oval,startAngle,sweepAngle2,false,paint);
    }
    Runnable animator=new Runnable() {
        @Override
        public void run() {
            if(startAngle<=360){
                if(startAngle <= 180) {
                    startAngle += 5;
                }else
                    startAngle += 15;
            }
            else{
                startAngle=1;
            }

            invalidate();
            postDelayed(this,30);
        }
    };
}

