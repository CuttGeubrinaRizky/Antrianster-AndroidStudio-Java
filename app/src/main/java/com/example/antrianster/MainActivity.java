package com.example.antrianster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*MainActivity.this.deleteDatabase("db_pasien");*/
    }

    public void btn1(View view) {
        Intent intent = new Intent(MainActivity.this, DaftarActivity.class);
        startActivity(intent);
    }

    public void btn2(View view) {
        Intent intent = new Intent(MainActivity.this, MasukActivity.class);
        startActivity(intent);
    }
}