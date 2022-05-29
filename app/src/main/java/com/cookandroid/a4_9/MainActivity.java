package com.cookandroid.a4_9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button button1;
    ImageView image1;
    int imaget = 10;
    int imageplus = 10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.button1);
        image1 = (ImageView) findViewById(R.id.image1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 {
                    imageplus += imaget;//ip(30) = ip(20) + im(10);//10도씩증가
                    image1.setRotation(imageplus);
                }
            }
        });
    }
}