package com.cookandroid.a11_6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    final Integer[] posterId = { R.drawable.mov21, R.drawable.mov22,
            R.drawable.mov23, R.drawable.mov24, R.drawable.mov25,
            R.drawable.mov26, R.drawable.mov27, R.drawable.mov28,
            R.drawable.mov29, R.drawable.mov30 };

    MyGraphicView graphicView;
    static float scaleX = 1, scaleY = 1, angle = 0, skew = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("연습문제 11-6");
        //https://d0ngr0thy.tistory.com/94 코드 가져옴

        final String[] movie = { "아바타", "힘을내요 미스터리", "포드vs페라리","쥬만지", "대부",
                "국가대표", "토이스토리3", "마당을 나온 암탉", "죽은 시인의 사회", "서유기" };

        Spinner spinner = (Spinner)findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, movie);
        spinner.setAdapter(adapter);
        LinearLayout layout = (LinearLayout)findViewById(R.id.layout1);
        graphicView = new MyGraphicView(this);
        layout.addView(graphicView);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                graphicView.setPosition(position);
                graphicView.invalidate();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        registerForContextMenu(graphicView);
    }

    //컨텍스트 메뉴
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,1,0,"회전");
        menu.add(0,2,0,"확대");
        menu.add(0,3,0,"축소");
        menu.add(0,4,0,"기울기 증가");
        menu.add(0,5,0,"기울기 감소");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case 1:
                angle += 45;
                break;
            case 2:
                scaleX += 0.2f;
                scaleY += 0.2f;
                break;
            case 3:
                scaleX -= 0.2f;
                scaleY -= 0.2f;
                break;
            case 4:
                skew += 0.3f;
                break;
            case 5:
                skew -= 0.3f;
                break;
        }
        graphicView.invalidate();
        return true;
    }

    //예제 9-6
    public class MyGraphicView extends View{
        int position;

        public MyGraphicView(Context context){
            super(context);
        }

        public void setPosition(int position){
            this.position = position;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Bitmap picture = BitmapFactory.decodeResource(getResources(), posterId[position]);
            int cenX = this.getWidth()/2;
            int cenY = this.getHeight()/2;
            int picX = (this.getWidth() - picture.getWidth())/2;
            int picY = (this.getHeight() - picture.getHeight())/2;
            canvas.rotate(angle, cenX, cenY);
            canvas.scale(scaleX, scaleY, cenX, cenY);
            canvas.skew(skew, skew);
            canvas.drawBitmap(picture, picX, picY, null);
            picture.recycle();
        }
    }

}