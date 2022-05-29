package com.cookandroid.a7_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout LY;

    //옵션메뉴의 화면 출력코드
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater minr = getMenuInflater();
        minr.inflate(R.menu.menu, menu);
        return true;
    }

    //옵션메뉴의 동작코드
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.item1:
                LY.setBackgroundColor(Color.RED);
                return true;

            case R.id.item2:
                LY.setBackgroundColor(Color.BLUE);
                return true;
        }
        return false;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LY = (LinearLayout) findViewById(R.id.lyc);
    }
}