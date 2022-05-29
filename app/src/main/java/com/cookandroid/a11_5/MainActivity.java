package com.cookandroid.a11_5;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("연습문제 11-5");

        final GridView gv2 = (GridView) findViewById(R.id.gv1);
        MyGridAdapter ga1 = new MyGridAdapter(this);
        gv2.setAdapter(ga1);
    }

    public class MyGridAdapter extends BaseAdapter {
        Context ct;

        public MyGridAdapter(Context c) {
            ct = c;
        }

        //이미지 개수 반환
        public int getCount() {
            return poid.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        Integer[] poid = { R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
                R.drawable.pic4, R.drawable.pic5, R.drawable.pic6,
                R.drawable.pic7, R.drawable.pic8, R.drawable.pic9};

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageview = new ImageView(ct);
            imageview.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 690));
            imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageview.setPadding(5, 5, 5, 5);

            imageview.setImageResource(poid[position]);
            return imageview;
        }

    }
}
