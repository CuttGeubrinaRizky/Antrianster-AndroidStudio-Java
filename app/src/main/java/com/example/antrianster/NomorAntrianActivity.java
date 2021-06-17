package com.example.antrianster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class NomorAntrianActivity extends AppCompatActivity {

    private TextView textViewAntrian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nomor_antrian);
        textViewAntrian = findViewById(R.id.textViewAntrian);
        Intent intent = getIntent();
        int nomor = intent.getIntExtra("Nomor Antrian", 1);
        textViewAntrian.setText("" + nomor);
    }

    public void btnKembali(View view) {
        Intent intent = new Intent (NomorAntrianActivity.this, MainActivity.class);
        startActivity(intent);
    }
}