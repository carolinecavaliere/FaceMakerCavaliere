/**
 * @author Caroline Cavaliere
 */
package com.example.facemaker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creates drop-down list of three different hairstyles
        Spinner hairStyles = findViewById(R.id.hairStyleSpinner);
        String[] hairStyleNames = {"Long", "Medium","Short"};
        ArrayAdapter<String> hairStylesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, hairStyleNames);
        hairStyles.setAdapter(hairStylesAdapter);

        //assigning listeners to widgets

        Face ref = findViewById(R.id.face);
        hairStyles.setOnItemSelectedListener(ref);
        RadioGroup features = findViewById(R.id.features);
        features.setOnCheckedChangeListener(ref);
        SeekBar redBar = findViewById(R.id.red);
        SeekBar blueBar = findViewById(R.id.blue);
        SeekBar greenBar = findViewById(R.id.green);
        redBar.setOnSeekBarChangeListener(ref);
        blueBar.setOnSeekBarChangeListener(ref);
        greenBar.setOnSeekBarChangeListener(ref);
        Button random = findViewById(R.id.randomFace);
        random.setOnClickListener(ref);
    }


}