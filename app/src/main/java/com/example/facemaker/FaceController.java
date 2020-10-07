/*
@author Caroline Cavaliere
This class acts as a listener for all of the widgets in the FaceMaker app.
 */

package com.example.facemaker;

import android.graphics.Color;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

public class FaceController implements Spinner.OnItemSelectedListener, SeekBar.OnSeekBarChangeListener, RadioGroup.OnCheckedChangeListener, View.OnClickListener
{
    private Face faceView = null;
    private SeekBar redSeek = null;
    private SeekBar greenSeek = null;
    private SeekBar blueSeek = null;
    private Spinner hairStyles = null;

    public FaceController(Face f, SeekBar r, SeekBar g, SeekBar b, Spinner h)
    {
        redSeek = r;
        greenSeek = g;
        blueSeek = b;
        faceView = f;
        hairStyles = h;

    }

    /**
     * Sets the hair style in the spinner to the one the user selects.
     * @param adapterView
     * @param view
     * @param i the hair style selected
     * @param l
     */
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
    {
        faceView.setHairStyle(i);
        faceView.invalidate();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView)
    {

    }

    /**
     * Changes the color of the hair, skin, or eyes depending on where
     * the user slides the red, green, or blue SeekBars.
     * @param seekBar can be the red, green, or blue SeekBar
     * @param i the color value for red, green, or blue
     * @param b
     */
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b)
    {
        if(seekBar==redSeek)
        {
            if(faceView.getHairChecked())
            {
                faceView.setHairColor(Color.rgb(i, Color.green(faceView.getHairColor()), Color.blue(faceView.getHairColor())));//changes only the red value of the hair
            }
            else if(faceView.getSkinChecked())
            {
                faceView.setSkinColor(Color.rgb(i, Color.green(faceView.getSkinColor()), Color.blue(faceView.getSkinColor())));
            }
            else if(faceView.getEyesChecked())
            {
                faceView.setEyeColor(Color.rgb(i, Color.green(faceView.getEyeColor()), Color.blue(faceView.getEyeColor())));
            }
        }
        else if(seekBar==greenSeek)
        {
            if(faceView.getHairChecked())
            {
                faceView.setHairColor(Color.rgb(Color.red(faceView.getHairColor()), i, Color.blue(faceView.getHairColor())));
            }
            else if(faceView.getSkinChecked())
            {
                faceView.setSkinColor(Color.rgb(Color.red(faceView.getSkinColor()), i, Color.blue(faceView.getSkinColor())));
            }
            else if(faceView.getEyesChecked())
            {
                faceView.setEyeColor(Color.rgb(Color.red(faceView.getEyeColor()), i, Color.blue(faceView.getEyeColor())));
            }
        }
        else if(seekBar==blueSeek)
        {
            if(faceView.getHairChecked())
            {
                faceView.setHairColor(Color.rgb(Color.red(faceView.getHairColor()), Color.green(faceView.getHairColor()), i));
            }
            else if(faceView.getSkinChecked())
            {
                faceView.setSkinColor(Color.rgb(Color.red(faceView.getSkinColor()), Color.green(faceView.getSkinColor()), i));
            }
            else if(faceView.getEyesChecked())
            {
                faceView.setEyeColor(Color.rgb(Color.red(faceView.getSkinColor()), Color.green(faceView.getEyeColor()), i));
            }
        }
        faceView.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar)
    {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar)
    {

    }

    /**
     * Allows the user to choose whether they are changing the color of the
     * hair, eyes, or skin
     * @param radioGroup
     * @param i refers to which RadioButton is active
     */
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i)
    {

        if(i==R.id.hair)
        {
            faceView.setHairChecked(true);
            faceView.setEyesChecked(false);
            faceView.setSkinChecked(false);
            blueSeek.setProgress(Color.blue(faceView.getHairColor()));//resets the SeekBar progress
            redSeek.setProgress(Color.red(faceView.getHairColor()));
            greenSeek.setProgress(Color.green(faceView.getHairColor()));

        }
        else if(i==R.id.eyes)
        {
            faceView.setHairChecked(false);
            faceView.setEyesChecked(true);
            faceView.setSkinChecked(false);
            blueSeek.setProgress(Color.blue(faceView.getEyeColor()));
            redSeek.setProgress(Color.red(faceView.getEyeColor()));
            greenSeek.setProgress(Color.green(faceView.getEyeColor()));

        }
        else if(i==R.id.skin)
        {
            faceView.setHairChecked(false);
            faceView.setEyesChecked(false);
            faceView.setSkinChecked(true);
            blueSeek.setProgress(Color.blue(faceView.getSkinColor()));
            redSeek.setProgress(Color.red(faceView.getSkinColor()));
            greenSeek.setProgress(Color.green(faceView.getSkinColor()));
        }
        faceView.invalidate();
    }

    /**
     * Shows a random face when the "Random Face" button is clicked.
     * @param view
     */
    @Override
    public void onClick(View view)
    {
        faceView.randomize();

        if(faceView.getHairChecked())
        {
            blueSeek.setProgress(Color.blue(faceView.getHairColor()));//update SeekBar progresses
            redSeek.setProgress(Color.red(faceView.getHairColor()));
            greenSeek.setProgress(Color.green(faceView.getHairColor()));
        }

        if(faceView.getEyesChecked())
        {
            blueSeek.setProgress(Color.blue(faceView.getEyeColor()));
            redSeek.setProgress(Color.red(faceView.getEyeColor()));
            greenSeek.setProgress(Color.green(faceView.getEyeColor()));
        }

        if(faceView.getSkinChecked())
        {
            blueSeek.setProgress(Color.blue(faceView.getSkinColor()));
            redSeek.setProgress(Color.red(faceView.getSkinColor()));
            greenSeek.setProgress(Color.green(faceView.getSkinColor()));
        }
        hairStyles.setSelection(faceView.getHairStyle());
        faceView.invalidate();
    }
}
