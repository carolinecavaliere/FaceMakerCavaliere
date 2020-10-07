/*
 * @author Caroline Cavaliere
 * This class models the attributes of a face and draws them on the screen.
 */
package com.example.facemaker;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

import androidx.annotation.RequiresApi;

public class Face extends SurfaceView
{

    private int skinColor;
    private int eyeColor;
    private int hairColor;
    private int hairStyle;

    private Paint skinPaint = new Paint();
    private Paint eyePaint = new Paint();
    private Paint hairPaint = new Paint();
    private Paint whitePaint = new Paint();
    private Paint blackPaint = new Paint();

    //indicates which RadioButton is selected
    private boolean hairChecked = true;
    private boolean skinChecked = false;
    private boolean eyesChecked = false;


    public Face(Context context, AttributeSet a)
    {
        super(context, a);
        randomize();
        setWillNotDraw(false);

        skinPaint.setColor(skinColor);
        skinPaint.setStyle(Paint.Style.FILL);
        whitePaint.setColor(Color.WHITE);
        whitePaint.setStyle(Paint.Style.FILL);
        blackPaint.setColor(Color.BLACK);
        blackPaint.setStyle(Paint.Style.FILL);
        eyePaint.setColor(eyeColor);
        eyePaint.setStyle(Paint.Style.FILL);
        hairPaint.setColor(hairColor);
        hairPaint.setStyle(Paint.Style.FILL);
        setBackgroundColor(Color.WHITE);

    }

    /**
     * Produces random ints to represent skin/eye/hair color and hair style
     */
    public void randomize()
    {
        skinColor = android.graphics.Color.argb(255,(int)(Math.random()*256),(int) (Math.random()*256),(int)(Math.random()*256));
        eyeColor = android.graphics.Color.argb(255,(int)(Math.random()*256),(int) (Math.random()*256),(int)(Math.random()*256));
        hairColor = android.graphics.Color.argb(255,(int)(Math.random()*256),(int) (Math.random()*256),(int)(Math.random()*256));
        hairStyle = (int)(Math.random()*3);//there are three hair styles to choose from


        /**
         * External Citation
         *      Date: 9 October 2020
         *      Problem: Did not know how to represent a color using a single int.
         *      Resource:
         *          https://developer.android.com/reference/android/graphics/Color#argb(int,%20int,%20int,%20int)
         *      Solution: I used the argb method in the Color class to produce a color int from three random red, green, and blue values and an alpha value.
         */
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    /**
     * Draws the face onscreen.
     */
    public void onDraw(Canvas canvas)
    {
        skinPaint.setColor(skinColor);
        skinPaint.setStyle(Paint.Style.FILL);
        whitePaint.setColor(Color.WHITE);
        whitePaint.setStyle(Paint.Style.FILL);
        blackPaint.setColor(Color.BLACK);
        blackPaint.setStyle(Paint.Style.FILL);
        eyePaint.setColor(eyeColor);
        eyePaint.setStyle(Paint.Style.FILL);
        hairPaint.setColor(hairColor);
        hairPaint.setStyle(Paint.Style.FILL);

        drawHair(canvas, 150.0f, 150.0f, 1050.0f, 1150.0f, hairPaint);
        canvas.drawOval(150.0f, 150.0f, 1050.0f, 1150.0f, skinPaint); //draw head
        drawEye(canvas, 300.0f, 400.0f, 500.0f, 600.0f, eyePaint);
        drawEye(canvas, 700.0f, 400.0f,900.0f, 600.0f, eyePaint);
        canvas.drawArc(300.0f, 300.0f, 900.0f, 1000.0f, 180, -180, false, blackPaint);//draw mouth


    }

    /**
     * Draws an eye. Positional parameters refer to where the white part of the eye is drawn.
     * @param canvas
     * @param left
     * @param top
     * @param right
     * @param bottom
     * @param paint
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void drawEye(Canvas canvas, float left, float top, float right, float bottom, Paint paint)
    {
        canvas.drawOval(left, top, right, bottom, whitePaint);//draw white part of eye
        canvas.drawOval(left+30.0f, top+30.0f, right-30.0f, bottom-30.0f, eyePaint);
        canvas.drawOval(left+50.0f, top+50.0f, right-50.0f, bottom-50.0f, blackPaint);//draw pupil
    }

    /**
     * Draws the hair style indicated by the Spinner. Positional parameters refer to where
     * the head is drawn.
     * @param canvas
     * @param left
     * @param top
     * @param right
     * @param bottom
     * @param paint
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void drawHair(Canvas canvas, float left, float top, float right, float bottom, Paint paint)
    {
        if (hairStyle==1)//draw long hair
        {
            canvas.drawRect(left+50.0f, top+300.0f, right-50.0f, bottom+100.0f, paint);
        }
        else if(hairStyle==2)//draw space buns
        {
            canvas.drawOval(left-20.0f, top, right-710.0f, bottom-780.0f, paint);
            canvas.drawOval(left+710.0f, top, right+20.0f, bottom-780.0f, paint);
        }

    }


    //getters and setters
    public int getEyeColor()
    {
        return eyeColor;
    }

    public int getHairColor()
    {
        return hairColor;
    }

    public int getHairStyle()
    {
        return hairStyle;
    }

    public int getSkinColor()
    {
        return skinColor;
    }

    public boolean getSkinChecked()
    {
        return skinChecked;
    }

    public boolean getEyesChecked()
    {
        return eyesChecked;
    }

    public boolean getHairChecked()
    {
        return hairChecked;
    }

    public void setEyeColor(int eyeColor)
    {
        this.eyeColor = eyeColor;
    }


    public void setEyesChecked(boolean eyesChecked)
    {
        this.eyesChecked = eyesChecked;
    }

    public void setHairChecked(boolean hairChecked)
    {
        this.hairChecked = hairChecked;
    }

    public void setHairColor(int hairColor)
    {
        this.hairColor = hairColor;
    }

    public void setHairStyle(int hairStyle)
    {
        this.hairStyle = hairStyle;
    }

    public void setSkinChecked(boolean skinChecked)
    {
        this.skinChecked = skinChecked;
    }

    public void setSkinColor(int skinColor)
    {
        this.skinColor = skinColor;
    }

}

