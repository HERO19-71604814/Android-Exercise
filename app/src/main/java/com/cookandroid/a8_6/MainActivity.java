package com.cookandroid.a8_6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    //변수
    DatePicker dapi11;
    EditText etd1;
    Button bw1;

    String fn;
    int ye, mo, da, i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("연습문제 8-6번");

        //대입
        dapi11 =(DatePicker)findViewById(R.id.dapi1);
        etd1 = (EditText)findViewById(R.id.etd);
        bw1 = (Button)findViewById(R.id.bw);

        //캘린더 클래스를 이용한 연,월,일 구하기
        Calendar calr = Calendar.getInstance();
        ye = calr.get(Calendar.YEAR);//년
        mo = calr.get(Calendar.MONTH);//월
        da = calr.get(Calendar.DAY_OF_MONTH);//일


        //SD카드 허용/거부 대화상자
        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);

        //데이트키퍼 초기화[init()] 후 동작
        dapi11.init(ye, mo, da, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                //년,월,일 출력
                //만들 파일의 파일이름(text파일)
                fn = Integer.toString(year) + "년 " + Integer.toString(monthOfYear) + "월 " + Integer.toString(dayOfMonth) +
                        "일.txt";

                String str = readDiary(fn);
                etd1.setText(str);
            }
        });

        //버튼 동작
        bw1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //SD카드 절대경로
                String stsd = Environment.getExternalStorageDirectory().getAbsolutePath();
                //SD카드 생성할 폴더
                File myDiary = new File(stsd + "/AmyDiary");
                //폴더생성
                myDiary.mkdir();

                try {
                    //https://dev-nomad.com/62 -> MainActivity.java 코드추가 ( 파일 쓰기 ) 참고햇습니다.
                    //myDiary1 = 생성할 파일경로, 생성할파일
                    File myDiary1 = new File(myDiary,fn);

                    //내장매모리경로
                    //FileOutputStream ouf = openFileOutput(fn, Context.MODE_PRIVATE);

                    //쓰기모드
                    //자바 FileWriter 클래스(인터넷 참고)
                    FileWriter ouf = new FileWriter(myDiary1);//파일 입력
                    String str = etd1.getText().toString();//일기장내용
                    str.getBytes();//str을 바이트형으로 변경
                    ouf.write(str);//저장
                    ouf.close();

                    //토스트 메세지
                    Toast.makeText(getApplicationContext(), fn + "가 저장됨", Toast.LENGTH_SHORT).show();

                } catch (IOException ioex) {
                }
            }

        });
    }

    //날짜 파일 읽기 후 일기내용반환메소드
    String readDiary(String fn1) {
        //저장
        String dis = null;
        try{
            FileInputStream fi = openFileInput(fn1);
            byte[] txtx = new byte[500];
            fi.read(txtx);
            fi.close();

            dis = (new String(txtx)).trim();
            bw1.setText("수정하기");

        } catch (IOException ioex) {
            etd1.setHint("일기 없음");
            bw1.setText("새로 저장");
        }
        return dis;
    }
}