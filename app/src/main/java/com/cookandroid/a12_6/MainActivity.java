package com.cookandroid.a12_6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    DatePicker datePicker;
    EditText editText;
    Button btn;
    String fileName;
    myDbHelper myDB;
    SQLiteDatabase sql;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        }, MODE_PRIVATE);

        datePicker = (DatePicker)findViewById(R.id.datePicker1);
        editText =  (EditText)findViewById(R.id.edtDiary);
        btn = (Button)findViewById(R.id.btnWrite);
        myDB = new myDbHelper(this);

        Calendar cal = Calendar.getInstance();
        int cYear = cal.get(Calendar.YEAR);
        int cMonth = cal.get(Calendar.MONTH);
        int cDate = cal.get(Calendar.DATE);
        fileName = Integer.toString(cYear) + "_" + Integer.toString(cMonth+1) + "_" + Integer.toString(cDate);
        String initStr = readDiary(fileName);
        editText.setText(initStr);
        btn.setEnabled(true);

        datePicker.init(cYear, cMonth, cDate, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                fileName = Integer.toString(year) + "_" + Integer.toString(monthOfYear+1) + "_" +
                        Integer.toString(dayOfMonth);
                String str = readDiary(fileName);
                editText.setText(str);
                btn.setEnabled(true);
            }
        });

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String str = editText.getText().toString();
                sql = myDB.getWritableDatabase();
                if(btn.getText().equals("새로 저장")) {
                    sql.execSQL("INSERT INTO myDiary VALUES(" + '"' + fileName + '"' + ", " +
                            '"' + str + '"' + ");");
                    btn.setText("수정하기");
                }
                else sql.execSQL("UPDATE myDiary SET content = " + '"' + str + '"');
                sql.close();
                Toast.makeText(getApplicationContext(), fileName + "이 저장됨", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public class myDbHelper extends SQLiteOpenHelper {
        myDbHelper(Context context) {
            super(context, "myDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try{
                db.execSQL("CREATE TABLE myDiary (diaryDate char(10) primary key, content varchar(500));");
            }catch (Exception e){
                System.out.println(e);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS myDiary");
            onCreate(db);
        }
    }

    String readDiary(String fName){
        String diaryStr = null;

        sql = myDB.getReadableDatabase();

        Cursor cursor = sql.rawQuery("SELECT * FROM myDiary WHERE diaryDate = " + '"' + fName + '"' + ";", null);
        while (cursor.moveToNext()) {
            diaryStr = cursor.getString(1);
        }
        if(diaryStr == null){
            editText.setHint("일기 없음");
            btn.setText("새로 저장");
        }
        else {
            btn.setText("수정하기");
        }

        return diaryStr;
    }
}