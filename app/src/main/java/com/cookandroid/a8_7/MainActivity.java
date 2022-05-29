package com.cookandroid.a8_7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    //변수
    Button butp1, butn1;
    TextView txv1;
    myPictureView mypicv1;
    int curNum = 0;
    File[] imf;
    String imfn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("연습문제 8-7");
        //SD 카드 권한 상자
        ActivityCompat.requestPermissions(this, new String[] {android.Manifest.permission.WRITE_EXTERNAL_STORAGE},MODE_PRIVATE);

        //대입
        butp1 = (Button) findViewById(R.id.butp);//이전
        butn1 = (Button) findViewById(R.id.butn);//다음
        txv1 = (TextView)findViewById(R.id.txv);//번호
        mypicv1 = (myPictureView) findViewById(R.id.mypicv);//이미지

        //SD카드 파일 리스트
        //내 휴대폰 이미지경로를 지정
        imf = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/DCIM/Camera").listFiles();
        imfn = imf[curNum].toString();//배열형태로 생성(0부터 시작)
        mypicv1.imagePath = imfn;//이미지파일을 출력하는 커스텀위젯에 넣는다.


        txv1.setText("1" + "/" + (imf.length-1));//처음출력되는 번호출력텍스트

        //이전그림 버튼 동작
        butp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //버튼을 눌렀을떄 그림의 위치가 첫번쨰일 경우
                if(curNum <= 0){
                    curNum = imf.length-1;//마지막 그림을 출력(마지막번호)
                } else {
                    curNum --;//1보다 작을떄까지감소
                }
                //이미지출력
                imfn = imf[curNum].toString();
                mypicv1.imagePath = imfn;
                mypicv1.invalidate();
                //버튼을누를떄마다 번호 변동
                txv1.setText(curNum + "/" + (imf.length-1));
            }
        });

        //다음그림 버튼 동작
        butn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //버튼을 눌렀을떄 그림의 위치가 첫번쨰랑 같거나 낮을 경우
                if(curNum >= imf.length-1){//배열 개념
                    curNum = 0;//처음 그림 화면으로 출력(1을 추가)
                } else {//(마지막그림번호보다 클떄까지)
                    curNum ++;//증가
                }
                //이미지출력
                imfn = imf[curNum].toString();
                mypicv1.imagePath = imfn;
                mypicv1.invalidate();
                //버튼을누를떄마다 번호 변동
                txv1.setText(curNum + "/" + (imf.length-1));
            }
        });

    }
}