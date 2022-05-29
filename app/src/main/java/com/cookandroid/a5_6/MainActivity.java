package com.cookandroid.a5_6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout display, display1, display2, display3;
    int text1, text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = (LinearLayout) findViewById(R.id.dsiplay);
        display1 = (LinearLayout) findViewById(R.id.display1);
        display2 = (LinearLayout) findViewById(R.id.display2);
        display3 = (LinearLayout) findViewById(R.id.display3);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1 = display.getHeight();
                text2 = display.getWidth();
                Toast.makeText(getApplicationContext(),"값1: "+ text1 + " 값2: "+ text2,Toast.LENGTH_LONG).show();
            }
        });

        display1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1 = display1.getHeight();
                text2 = display1.getWidth();
                Toast.makeText(getApplicationContext(),"값1: "+ text1 + " 값2: "+ text2,Toast.LENGTH_LONG).show();
            }
        });

        display2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1 = display2.getHeight();
                text2 = display2.getWidth();
                Toast.makeText(getApplicationContext(),"값1: "+ text1 + " 값2: "+ text2,Toast.LENGTH_LONG).show();
            }
        });

        display3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1 = display3.getHeight();
                text2 = display3.getWidth();
                Toast.makeText(getApplicationContext(),"값1: "+ text1 + " 값2: "+ text2,Toast.LENGTH_LONG).show();
            }
        });
    }
}