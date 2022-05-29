package com.cookandroid.a8_7;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class myPictureView extends View {

    String imagePath = null;
    public myPictureView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        if (imagePath != null){
            //교과서 352쪽 참고
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
            int px = (this.getWidth() - bitmap.getWidth()) / 2;
            int py = (this.getHeight() - bitmap.getHeight()) / 2;
            canvas.drawBitmap(bitmap, px, py, null);
            bitmap.recycle();
        }

    }
}
