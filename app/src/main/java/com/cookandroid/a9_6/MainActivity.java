package com.cookandroid.a9_6;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SubMenu;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //매뉴 선택한 것 구분
    final static int LINE = 1, CIRCLE = 2, RECT = 3;
    //기본값을 선으로 지정
    static int curShape = LINE;
    //기본값 검정
    static int cr = Color.BLACK;

    //동적리스트
    static List<MyShape> myshape = new ArrayList<MyShape>();
    //MyShape클래스에 변수
    static MyShape myshapes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //이미지 화면 출력
        setContentView(new MyGraphicView(this));
        setTitle("연습문제9-6");
    }

    //옵션 매뉴 종류
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0,1,0,"선 그리기");
        menu.add(0,2,0,"원 그리기");
        menu.add(0,3,0,"사각형 그리기");

        SubMenu sMenu = menu.addSubMenu("색상 변경 >>");
        sMenu.add(0,4,0,"빨강");
        sMenu.add(0,5,0,"초록");
        sMenu.add(0,6,0,"파랑");
        return true;
    }

    //옵션 매뉴 동작 기능
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case 1:
                curShape = LINE;
                return true;
            case 2:
                curShape = CIRCLE;
                return true;
            case 3:
                curShape = RECT;
                return true;
            case 4:
                cr=Color.RED;
                return true;
            case 5:
                cr=Color.GREEN;
                return true;
            case 6:
                cr=Color.BLUE;
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //터치 기능
    private static class MyGraphicView extends View {

        public MyGraphicView(Context context){
            super(context);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {

            switch(event.getAction()) {
                case MotionEvent.ACTION_DOWN: //터치 상태
                    myshapes = new MyShape(curShape,cr);//시작점과 끝점 좌표 도형클래스에 저장(터치, 드래그값)
                    myshapes.startX = (int) event.getX();
                    myshapes.startY = (int) event.getY();
                    break;
                case MotionEvent.ACTION_MOVE: // 드래그
                case MotionEvent.ACTION_UP: //No 터치 상태
                    myshapes.stopX = (int) event.getX();
                    myshapes.stopY = (int) event.getY();
                    myshape.add(myshapes);
                    this.invalidate();
                    break;
            }
            return true;
        }

        //화면 터치, 드래그시 값을 저장후 반복
        @Override
        protected void onDraw(Canvas canvas) {
            for(MyShape myshapes : myshape){
                myshapes.display(canvas);
            }
        }
    }

    //도형클래스(저장)
    private static class MyShape{
        int shapeType;//도형 초기값
        int startX, startY, stopX, stopY;//시작점과 끝점 초기값
        int color;//색깔 초기값

        //도형과 색깔값을 저장
        public MyShape(int cur, int co){
            shapeType=cur;
            color=co;
        }

        public void display(Canvas canvas){
            //1. 페인트 생성, 2.도형 끝부분 부드럽게, 3.선의 두께, 4.도형의 내부 채우기 여부, 5.색상
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStrokeWidth(5);
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(color);

            //그림 생성(선, 원, 도형)
            switch (shapeType){
                case LINE:
                    canvas.drawLine(startX,startY,stopX,stopY,paint);
                    break;
                case CIRCLE:
                    int radius = (int)Math.sqrt(Math.pow(stopX-startX, 2)+Math.pow(stopY-startX,2));
                    canvas.drawCircle(startX,startY,radius,paint);
                    break;
                case RECT:
                    canvas.drawRect(startX,startY,stopX,stopY,paint);
                    break;
            }
        }

    }

}