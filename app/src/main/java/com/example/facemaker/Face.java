/**
 * @author Caroline Cavaliere
 */
package com.example.facemaker;
import android.graphics.Color;

public class Face {

    int skinColor;
    int eyeColor;
    int hairColor;
    int hairStyle;

    public Face(int s, int e, int hc, int hs)
    {
        randomize();
    }

    public void randomize()//produces random ints to represent skin/eye/hair color and hair style
    {
        skinColor = Color.rgb((int)Math.random()*256,(int) Math.random()*256,(int)Math.random()*256);
        eyeColor = Color.rgb((int)Math.random()*256,(int) Math.random()*256,(int)Math.random()*256);
        hairColor = Color.rgb((int)Math.random()*256,(int) Math.random()*256,(int)Math.random()*256);
        hairStyle = (int)Math.random()*3;//there are three hair styles to choose from

        /**
         * External Citation
         *      Date: 9 September 2020
         *      Problem: Did not know how to represent a color using a single int.
         *      Resource:
         *          https://developer.android.com/reference/android/graphics/Color
         *      Solution: I used the rgb method in the Color class to produce a color int from three random red, green, and blue values.
         */
    }
    }

