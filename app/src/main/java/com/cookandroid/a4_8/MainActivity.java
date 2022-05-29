package com.cookandroid.a4_8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    String et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.et1);


        et1.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                et2 = et1.getText().toString();
                Toast.makeText(getApplicationContext(),et2,Toast.LENGTH_LONG).show();
                return false;
            }
        });

        /*et1.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                String ets = et1.getText().toString();
                Toast.makeText(getApplicationContext(),ets,Toast.LENGTH_LONG).show();
                return false;

            }
        });*/

    }
}