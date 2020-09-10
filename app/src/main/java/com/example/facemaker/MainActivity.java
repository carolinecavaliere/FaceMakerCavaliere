/**
 * @author Caroline Cavaliere
 */
package com.example.facemaker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
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
    }


}