package com.cookandroid.a9_5;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    //이미지 출력
    MyGraphicView graphicView;

    //확대, 축소, 회전, 밝게, 어둡게, 그레이영상의 축적시킬 변수
    static float scaleX = 1, scaleY = 1;//확대, 축소 축전변수
    static float angle = 0;//회전 축적변수
    static float color = 1;//밝게, 어둡게 축적변수
    static float satur = 1;//그레이 영상 축적변수

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setTitle("연습문제 9_5");

        //LinearLayout pictureLayout = (LinearLayout) findViewById(R.id.pictureLayout);
        //xml 인플레이트 코드를 대신하는 리니어 레이아웃 자바 코드
        LinearLayout.LayoutParams ptly = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT,9);
        LinearLayout baseLL = new LinearLayout(this);
        baseLL.setOrientation(LinearLayout.HORIZONTAL);
        baseLL.setGravity(Gravity.CENTER);
        setContentView(baseLL, ptly);

        //이미지 설정내용 출력
        graphicView = (MyGraphicView) new MyGraphicView(this);
        baseLL.addView(graphicView);

        //이미지설정 컨텍스트메뉴 출력
        registerForContextMenu(graphicView);
    }

    //이미지 설정 내용
    private static class MyGraphicView extends View {
        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            //이미지 뷰의 좌표
            int cenX = this.getWidth() / 2;
            int cenY = this.getHeight() / 2;
            canvas.scale(scaleX, scaleY, cenX, cenY);
            canvas.rotate(angle, cenX, cenY);

            //1차원배열을 2차원배열로사용 rgb색상 초기값
            Paint paint = new Paint();
            float[] array = { color, 0, 0, 0, 0, 0, color, 0, 0, 0, 0, 0,
                    color, 0, 0, 0, 0, 0, 1, 0 };

            //컬러매트릭스 생성후 페인트적용
            ColorMatrix cm = new ColorMatrix(array);

            if (satur == 0)
                cm.setSaturation(satur);

            //컬러매트릭스 생성후 페인트적용
            paint.setColorFilter(new ColorMatrixColorFilter(cm));

            //이미지 화면중앙 출력 코드
            Bitmap picture = BitmapFactory.decodeResource(getResources(),
                    R.drawable.lena256);
            int picX = (this.getWidth() - picture.getWidth()) / 2;
            int picY = (this.getHeight() - picture.getHeight()) / 2;
            //이미지 화면 출력
            canvas.drawBitmap(picture, picX, picY, paint);
            //비트맵 리소스 해제
            picture.recycle();
        }
    }

    //편집 버튼 종류
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);

        if (v == graphicView) {

            menu.add(0, 1, 0, "확대");
            menu.add(0, 2, 0, "축소");
            menu.add(0, 3, 0, "회전");
            menu.add(0, 4, 0, "밝게");
            menu.add(0, 5, 0, "어둡게");
            menu.add(0, 6, 0, "그레이영상");

        }
    }

    //편집 버튼 동작 내용
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case 1:
                scaleX = scaleX + 0.2f;
                scaleY = scaleY + 0.2f;
                graphicView.invalidate();
                return true;
            case 2:
                scaleX = scaleX - 0.2f;
                scaleY = scaleY - 0.2f;
                graphicView.invalidate();
                return true;
            case 3:
                angle = angle + 20;
                graphicView.invalidate();
                return true;
            case 4:
                color = color + 0.2f;
                graphicView.invalidate();
                return true;
            case 5:
                color = color - 0.2f;
                graphicView.invalidate();
                return true;
            case 6:
                if (satur == 0)
                    satur = 1;
                else
                    satur = 0;
                graphicView.invalidate();
                return true;
        }
        return false;
    }
}