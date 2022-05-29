package com.cookandroid.a10_5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class fistActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fist);
        setTitle("연습문제 10-5 2P");

        Button btn2,btn3;
        btn2 = (Button) findViewById(R.id.bt2);
        btn3 = (Button) findViewById(R.id.bt3);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte2 = new Intent(fistActivity.this, secondActivity.class);
                startActivity(inte2);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
