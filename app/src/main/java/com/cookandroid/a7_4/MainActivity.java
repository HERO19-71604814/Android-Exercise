package com.cookandroid.a7_4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

//295쪽 내용참고
public class MainActivity extends AppCompatActivity {

    ImageView imar;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0,1,0,"강아지");
        menu.add(0,2,0,"고양이");
        menu.add(0,3,0,"토끼");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case 1:
//                imar.setImageResource(R.mipmap.ic_launcher); 기본 아이콘이미지를이용한 이미지 테스트
                imar.setImageResource(R.drawable.dog);
                return true;

            case 2:
//                imar.setImageResource(R.drawable.ic_launcher_background); 기본 아이콘이미지를이용한 이미지 테스트
                imar.setImageResource(R.drawable.cat);
                return true;

            case 3:
//                imar.setImageResource(R.drawable.ic_launcher_foreground); 기본 아이콘이미지를이용한 이미지 테스트
                imar.setImageResource(R.drawable.rabbit);
                return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("연습문제 7-4");
        imar = (ImageView) findViewById(R.id.ima1);
    }
}