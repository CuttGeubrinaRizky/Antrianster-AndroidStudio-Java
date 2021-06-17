package com.example.antrianster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {

    private TextView textViewNama, textViewNik, textViewHp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        textViewNama = findViewById(R.id.textViewName);
        textViewNik = findViewById(R.id.textViewNik);
        textViewHp = findViewById(R.id.textViewHp);
        Intent intent = getIntent();
        textViewNama.setText(intent.getStringExtra("Nama"));
        textViewNik.setText(intent.getStringExtra("NIK"));
        textViewHp.setText(intent.getStringExtra("No.Hp"));
    }

    public void btnPilih(View view) {
        Intent intent = new Intent (DashboardActivity.this, PilihKlinikActivity.class);
        startActivity(intent);
    }

    public void btnKeluar(View view) {
        Intent intent = new Intent (DashboardActivity.this, MainActivity.class);
        startActivity(intent);
    }
}