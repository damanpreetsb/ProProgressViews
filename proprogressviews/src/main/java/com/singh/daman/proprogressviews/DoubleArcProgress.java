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
 * Created by damanpreet singh on 07-03-2017.
 */

public class DoubleArcProgress extends View {

    private Paint paint=new Paint();
    private int startAngle=120;
    private int startAngle2=240;
    private RectF oval=new RectF();
    private int sweepAngle=100;

    private float in_rad;
    private int colorArc;

    public DoubleArcProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint.setStyle(Paint.Style.STROKE);
        TypedArray array=context.getTheme().obtainStyledAttributes(attrs,R.styleable.DoubleArcProgress,0,0);
        try{
            in_rad=array.getDimension(R.styleable.DoubleArcProgress_arcRadius,50);
            colorArc=array.getColor(R.styleable.DoubleArcProgress_colorofArc, Color.parseColor("#5C6BC0"));
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
