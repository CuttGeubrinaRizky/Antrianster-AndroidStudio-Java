package com.example.antrianster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NomorAntrianActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nomor_antrian);
    }

    public void btnKembali(View view) {
        Intent intent = new Intent (NomorAntrianActivity.this, MainActivity.class);
        startActivity(intent);
    }
}