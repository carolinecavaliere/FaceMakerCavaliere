/**
 * @author Caroline Cavaliere
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

public class Face extends SurfaceView implements Spinner.OnItemSelectedListener, SeekBar.OnSeekBarChangeListener, RadioGroup.OnCheckedChangeListener, View.OnClickListener{

    int skinColor;
    int eyeColor;
    int hairColor;
    int hairStyle;

    Paint skinPaint = new Paint();
    Paint eyePaint = new Paint();
    Paint hairPaint = new Paint();
    Paint whitePaint = new Paint();
    Paint blackPaint = new Paint();
    Paint greenPaint = new Paint();

    boolean hairChecked = true;
    boolean skinChecked = false;
    boolean eyesChecked = false;

    SeekBar blue = findViewById(R.id.blue);
    SeekBar red = findViewById(R.id.red);
    SeekBar green = findViewById(R.id.green);


    public Face(Context context, AttributeSet a)
    {
        super(context, a);
        randomize();
        setWillNotDraw(false);



        setBackgroundColor(Color.WHITE);

    }

    public void randomize()//produces random ints to represent skin/eye/hair color and hair style
    {
        skinColor = Color.rgb((int)Math.random()*256,(int) Math.random()*256,(int)Math.random()*256);
        eyeColor = Color.rgb((int)Math.random()*256,(int) Math.random()*256,(int)Math.random()*256);
        hairColor = Color.rgb((int)Math.random()*256,(int) Math.random()*256,(int)Math.random()*256);
        hairStyle = (int)Math.random()*3;//there are three hair styles to choose from


        if(hairChecked==true)
        {
            blue.setProgress(Color.blue(skinColor));
            red.setProgress(Color.red(skinColor));
            green.setProgress(Color.green(skinColor));
        }

        if(eyesChecked==true)
        {
            blue.setProgress(Color.blue(eyeColor));
            red.setProgress(Color.red(eyeColor));
            green.setProgress(Color.green(eyeColor));
        }

        if(skinChecked==true)
        {
            blue.setProgress(Color.blue(hairColor));
            red.setProgress(Color.red(hairColor));
            green.setProgress(Color.green(hairColor));
        }

        /**
         * External Citation
         *      Date: 9 September 2020
         *      Problem: Did not know how to represent a color using a single int.
         *      Resource:
         *          https://developer.android.com/reference/android/graphics/Color
         *      Solution: I used the rgb method in the Color class to produce a color int from three random red, green, and blue values.
         */
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
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
        greenPaint.setColor(Color.GREEN);
        greenPaint.setStyle(Paint.Style.FILL);
        canvas.drawOval(150.0f, 150.0f, 1050.0f, 1150.0f, skinPaint);

        drawEye(canvas, 300.0f, 400.0f, 500.0f, 600.0f, eyePaint);
        drawEye(canvas, 700.0f, 400.0f,900.0f, 600.0f, eyePaint);
        //drawEye(canvas, 900.0f, 300.0f, 1000.0f, 400.0f, eyePaint);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void drawEye(Canvas canvas, float left, float top, float right, float bottom, Paint paint)
    {
        canvas.drawOval(left, top, right, bottom, whitePaint);
        canvas.drawOval(left+30.0f, top+30.0f, right-30.0f, bottom-30.0f, greenPaint);
        canvas.drawOval(left+50.0f, top+50.0f, right-50.0f, bottom-50.0f, blackPaint);
    }


    public void drawHair(Canvas canvas, String style)
    {

    }

    public void drawNose(Canvas canvas, float left, float right, float stopLeft, float stopRight)
    {
        canvas.drawLine(left, right, stopLeft, stopRight, blackPaint);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
    {
        hairStyle = i;
        this.invalidate();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b)
    {
        if(seekBar==findViewById(R.id.red))
        {
            if(hairChecked)
            {
                hairColor = Color.rgb(i, Color.green(hairColor), Color.blue(hairColor));
            }
            else if(skinChecked)
            {
                skinColor = Color.rgb(i, Color.green(skinColor), Color.blue(skinColor));
            }
            else if(eyesChecked)
            {
                eyeColor = Color.rgb(i, Color.green(eyeColor), Color.blue(eyeColor));
            }
        }
        else if(seekBar==findViewById(R.id.green))
        {
            if(hairChecked)
            {
                hairColor = Color.rgb(Color.red(hairColor), i, Color.blue(hairColor));
            }
            else if(skinChecked)
            {
                skinColor = Color.rgb(Color.red(skinColor), i, Color.blue(skinColor));
            }
            else if(eyesChecked)
            {
                eyeColor = Color.rgb(Color.red(skinColor), i, Color.blue(eyeColor));
            }
        }
        else if(seekBar==findViewById(R.id.blue))
        {
            if(hairChecked)
            {
                hairColor = Color.rgb(Color.red(hairColor), Color.green(hairColor), i);
            }
            else if(skinChecked)
            {
                skinColor = Color.rgb(Color.red(skinColor), Color.green(skinColor), i);
            }
            else if(eyesChecked)
            {
                eyeColor = Color.rgb(Color.red(skinColor), Color.green(eyeColor), i);
            }
        }
        this.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {



        if(i==R.id.hair)
        {
            hairChecked = true;
            eyesChecked = false;
            skinChecked = false;

        }
        else if(i==R.id.eyes)
        {
            hairChecked = false;
            eyesChecked = true;
            skinChecked = false;

        }
        else if(i==R.id.skin)
        {
            hairChecked = false;
            eyesChecked = false;
            skinChecked = true;

        }
        this.invalidate();
    }

    @Override
    public void onClick(View view) {
        randomize();
        this.invalidate();
    }
}

