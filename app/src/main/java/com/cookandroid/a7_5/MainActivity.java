package com.cookandroid.a7_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button Toastimage;
    View toastxml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("연습문제 7-5");
        Toastimage = (Button) findViewById(R.id.tib1);

        Toastimage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                toastxml = (View) View.inflate(MainActivity.this,R.layout.toast1,null);

                //토스트메세지 생성
                Toast tib0 = new Toast(MainActivity.this);

                //랜덤 위치생성
                Display RTD = ((WindowManager)getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                int x = (int) (Math.random() * RTD.getWidth());
                int y = (int) (Math.random() * RTD.getHeight());


                //출력
                tib0.setGravity(Gravity.NO_GRAVITY, x, y);
                tib0.setView(toastxml);
                tib0.show();
            }
        });
    }
}