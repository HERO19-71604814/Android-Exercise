package com.cookandroid.a4_7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;

public class MainActivity extends AppCompatActivity {

    CheckBox cb1,cb2,cb3;
    Button but1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb1 = (CheckBox) findViewById(R.id.cb1);
        cb2 = (CheckBox) findViewById(R.id.cb2);
        cb3 = (CheckBox) findViewById(R.id.cb3);
        but1 = (Button) findViewById(R.id.but1);

        cb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb1.isChecked() == true)
                {
                    but1.setEnabled(false);
                }
                else
                {
                    but1.setEnabled(true);
                }
            }
        });
        cb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb2.isChecked() == true)
                {
                    but1.setClickable(false);
                }
                else
                {
                    but1.setClickable(true);
                }
            }
        });
        cb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb3.isChecked() == true)
                {
                    but1.setRotation(45);
                }
                else
                {
                    but1.setRotation(0);
                }
            }

        });

    }
}