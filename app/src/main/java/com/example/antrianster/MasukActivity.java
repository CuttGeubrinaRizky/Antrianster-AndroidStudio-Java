package com.example.antrianster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MasukActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masuk);
    }

    public void btnMasuk(View view) {
        Intent intent = new Intent(MasukActivity.this, PilihKlinikActivity.class);
        startActivity(intent);
    }
}