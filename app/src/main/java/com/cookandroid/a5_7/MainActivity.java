package com.cookandroid.a5_7;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        LinearLayout.LayoutParams fba1 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT
                ,1);
        LinearLayout ba1 = new LinearLayout(this);
        ba1.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams fba2 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT
                ,1);
        LinearLayout ba2 = new LinearLayout(this);
        ba2.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout.LayoutParams fba3 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT
                ,1);
        LinearLayout ba3 = new LinearLayout(this);
        ba3.setBackgroundColor(Color.rgb(0,0,250));

        LinearLayout.LayoutParams fba4 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT
                ,1);
        LinearLayout ba4 = new LinearLayout(this);
        ba4.setBackgroundColor(Color.rgb(200,0,0));

        LinearLayout.LayoutParams fba5 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT
                ,1);
        LinearLayout ba5 = new LinearLayout(this);
        ba5.setBackgroundColor(Color.rgb(200,200,0));
        ba5.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams fba6 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT
                ,1);
        LinearLayout ba6 = new LinearLayout(this);
        ba6.setBackgroundColor(Color.rgb(200,200,0));

        LinearLayout.LayoutParams fba7 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT
                ,1);
        LinearLayout ba7 = new LinearLayout(this);
        ba7.setBackgroundColor(Color.rgb(0,0,0));

        setContentView(ba1, fba1);
        ba1.addView(ba2, fba2);
        ba1.addView(ba3, fba3);

        ba2.addView(ba4, fba4);
        ba2.addView(ba5, fba5);

        ba5.addView(ba6, fba6);
        ba5.addView(ba7, fba7);
    }
}