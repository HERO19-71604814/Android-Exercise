package com.cookandroid.a10_6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

public class fistActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fist);
        setTitle("투표 결과 출력");

        /*앞 화면에서 보낸 투표 결과 값을 받는다.*/
        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("VoteCount");

        // 9개의 ImageView, int 객체배열
        ImageView iv[] = new ImageView[voteResult.length];
        int imint[] = new int[voteResult.length];

        /* 9개의 fistActivity의 이미지뷰와 9개의 drawable의 이미지파일에대한 ID 배열*/
        //이미지뷰
        Integer imID[] = {R.id.ivTop1, R.id.ivTop2, R.id.ivTop3, R.id.ivTop4, R.id.ivTop5,
                R.id.ivTop6, R.id.ivTop7, R.id.ivTop8, R.id.ivTop9};
        //이미지 이름
        Integer imnameID[] = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4,
                R.drawable.pic5, R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9};

        //ImageView 배열 변수 iv에 대입, 개체 찾기
        for(int i=0;i<voteResult.length;i++){
            iv[i] = (ImageView)findViewById(imID[i]);
        }

        //1번과 2번은 인터넷 참고(https://blog.naver.com/jane_04/220708807655)
        //1.초기화
        //imintID 초기화
        //imintID는 순위를 정하는 역할
        for(int i=0;i<voteResult.length;i++){
            imint[i]=0;
        }

        //2.순서구하기
        //순서 구하기
        //배열크기만큼 반복(총 9번)
        for(int i=0;i<voteResult.length;i++){
            for(int j=i+1 ;j < voteResult.length; j++) {
                //j가 i보다클경우 i를증가
                if (voteResult[i] < voteResult[j])
                    imint[i]++;
                //i가 j보다클경우 j를증가
                else
                    imint[j]++;
            }
        }

        // 넘겨 받은 값을 반영.
        for(int i=0;i<voteResult.length;i++){
            //넘겨받은 이미지 파일(imnameid)과 값을 이미지뷰(iv)와 imint에 삽입후 출력
            iv[imint[i]].setImageResource(imnameID[i]);
        }


        //교재259쪽 6-2 직접풀어보기 뷰플리퍼 코드 참고
        Button btnStart, btnStop;
        final ViewFlipper vFlipper;

        btnStart = (Button) findViewById(R.id.br1);
        btnStop = (Button) findViewById(R.id.br2);

        vFlipper = (ViewFlipper) findViewById(R.id.viewFlipper1);

        vFlipper.setFlipInterval(500);

        btnStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                vFlipper.startFlipping();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                vFlipper.stopFlipping();
            }
        });

        /*교재 395쪽 참고*/
        Button btnReturn = (Button) findViewById(R.id.br3);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();

            }
        });
    }
}