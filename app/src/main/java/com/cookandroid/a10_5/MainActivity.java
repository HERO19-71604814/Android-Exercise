package com.cookandroid.a10_5;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("연습문제 10-5 1P");

        Button btn1 = (Button)findViewById(R.id.bt1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte1 = new Intent(MainActivity.this, fistActivity.class);
                startActivity(inte1);
            }
        });
    }
}