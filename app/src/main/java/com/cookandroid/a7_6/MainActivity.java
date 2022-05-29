package com.cookandroid.a7_6;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg0;
    View dog11, cat11, rad11, hos11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("연습문제 7-6");

        //동물선택 라디오버튼 그룹
        rg0 = (RadioGroup) findViewById(R.id.rg1);

        //동물이미지
        dog11 = (View) View.inflate(MainActivity.this,R.layout.dog0,null);
        cat11 = (View) View.inflate(MainActivity.this,R.layout.cat0,null);
        rad11 = (View) View.inflate(MainActivity.this,R.layout.rad0,null);
        hos11 = (View) View.inflate(MainActivity.this,R.layout.hos0,null);

        //선택 후 실행 버튼
        Button imabut1 = (Button) findViewById(R.id.imabut);

        //동물선택후 그림보기눌렀을떄
        imabut1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (rg0.getCheckedRadioButtonId()) {
                    case R.id.dog:
                        AlertDialog.Builder diganl1 = new AlertDialog.Builder(MainActivity.this);
                        diganl1.setTitle("강아지");
                        diganl1.setView(dog11);
                        diganl1.setNegativeButton("닫기", null);
                        diganl1.show();
                        break;

                    case R.id.cat:
                        AlertDialog.Builder diganl2 = new AlertDialog.Builder(MainActivity.this);
                        diganl2.setTitle("고양이");
                        diganl2.setView(cat11);
                        diganl2.setNegativeButton("닫기", null);
                        diganl2.show();
                        break;

                    case R.id.rad:
                        AlertDialog.Builder diganl3 = new AlertDialog.Builder(MainActivity.this);
                        diganl3.setTitle("토끼");
                        diganl3.setView(rad11);
                        diganl3.setNegativeButton("닫기", null);
                        diganl3.show();
                        break;

                    case R.id.hos:
                        AlertDialog.Builder diganl4 = new AlertDialog.Builder(MainActivity.this);
                        diganl4.setTitle("말");
                        diganl4.setView(hos11);
                        diganl4.setNegativeButton("닫기", null);
                        diganl4.show();
                        break;

                    default:
                        AlertDialog.Builder diganl5 = new AlertDialog.Builder(MainActivity.this);
                        diganl5.setTitle("! 경고 !");
                        diganl5.setMessage("동물이 선택되지 않았습니다??? 동물을 선택해주세요!!!");
                        diganl5.setNegativeButton("닫기", null);
                        diganl5.show();
                }

            }
        });
    }
}