package com.cookandroid.a12_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn5;
    EditText editText;
    myDB myDbHelper;
    SQLiteDatabase sqlDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("가수 그룹 관리 DB");

        btn5 = (Button)findViewById(R.id.btn5);
        editText = (EditText)findViewById(R.id.editResult);
        myDbHelper = new myDB(this);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myDbHelper.getReadableDatabase();
                Cursor cursor = sqlDB.rawQuery("SELECT * FROM prodTable;", null);

                String str = "\n";

                while(cursor.moveToNext()){
                    str += cursor.getString(0) + ", "
                            + cursor.getString(1) + ","
                            + cursor.getString(2) + ","
                            + cursor.getString(3) + "\r\n";
                }

                editText.setText(str);
                cursor.close();
                sqlDB.close();
            }
        });

    }

    public class myDB extends SQLiteOpenHelper{

        myDB(Context context){
            super(context, "ex12_5DB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE prodTable ( num INTEGER PRIMARY KEY AUTOINCREMENT, uName CHAR(20), product CHAR(20), count INTEGER);");
            db.execSQL("INSERT INTO prodTable(uName, product, count) VALUES ('장동건','운동화', 2);");
            db.execSQL("INSERT INTO prodTable(uName, product, count) VALUES ('원빈', '노트북', 1);");
            db.execSQL("INSERT INTO prodTable(uName, product, count) VALUES ('소지섭', '모니터', 1);");
            db.execSQL("INSERT INTO prodTable(uName, product, count) Values ('김제동', '모니터', 5);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS prodTable");
            onCreate(db);
        }
    }
}