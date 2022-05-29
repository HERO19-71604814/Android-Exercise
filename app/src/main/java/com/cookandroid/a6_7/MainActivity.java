package com.cookandroid.a6_7;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("연습문제6-6");

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);

        Button bc1, bc2;

        bc1 = (Button) findViewById(R.id.ha1);
        bc2 = (Button) findViewById(R.id.ha2);

        bc1.setBackgroundColor(Color.rgb(152,152,152));
        bc2.setBackgroundColor(Color.rgb(76,175,80));

    }
}