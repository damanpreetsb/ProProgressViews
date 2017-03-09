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
 * Created by Damanpreet singh on 08-03-2017.
 */

public class DottedArcProgress extends View {

    private Paint paint=new Paint();
    private int startAngle=30;
    private int startAngle2=60;
    private int startAngle3=90;
    private int startAngle4=120;
    private int startAngle5=150;
    private int startAngle6=180;
    private RectF oval=new RectF();
    private int sweepAngle=10;

    private float in_rad;
    private int colorArc;

    public DottedArcProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint.setStyle(Paint.Style.STROKE);
        TypedArray array=context.getTheme().obtainStyledAttributes(attrs,R.styleable.DottedArcProgress,0,0);
        try{
            in_rad=array.getDimension(R.styleable.DottedArcProgress_dots_radius,50);
            colorArc=array.getColor(R.styleable.DottedArcProgress_dots_color, Color.parseColor("#5C6BC0"));
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

        oval.set(getWidth()/2-in_rad,getHeight()/2-in_rad,getWidth()/2+in_rad,getHeight()/2+in_rad);
        canvas.drawArc(oval,startAngle2,sweepAngle,false,paint);

        oval.set(getWidth()/2-in_rad,getHeight()/2-in_rad,getWidth()/2+in_rad,getHeight()/2+in_rad);
        canvas.drawArc(oval,startAngle3,sweepAngle,false,paint);

        oval.set(getWidth()/2-in_rad,getHeight()/2-in_rad,getWidth()/2+in_rad,getHeight()/2+in_rad);
        canvas.drawArc(oval,startAngle4,sweepAngle,false,paint);

        oval.set(getWidth()/2-in_rad,getHeight()/2-in_rad,getWidth()/2+in_rad,getHeight()/2+in_rad);
        canvas.drawArc(oval,startAngle5,sweepAngle,false,paint);

        oval.set(getWidth()/2-in_rad,getHeight()/2-in_rad,getWidth()/2+in_rad,getHeight()/2+in_rad);
        canvas.drawArc(oval,startAngle6,sweepAngle,false,paint);

    }
    Runnable animator=new Runnable() {
        @Override
        public void run() {
            if(startAngle<=360){
                startAngle+=10;
            }
            else{
                startAngle=1;
            }
            if(startAngle2<=360){
                startAngle2+=10;
            }
            else{
                startAngle2=1;
            }
            if(startAngle3<=360){
                startAngle3+=10;
            }
            else{
                startAngle3=1;
            }
            if(startAngle4<=360){
                startAngle4+=10;
            }
            else{
                startAngle4=1;
            }
            if(startAngle5<=360){
                startAngle5+=10;
            }
            else{
                startAngle5=1;
            }
            if(startAngle6<=360){
                startAngle6+=10;
            }
            else{
                startAngle6=1;
            }
            invalidate();
            postDelayed(this,30);
        }
    };
}

