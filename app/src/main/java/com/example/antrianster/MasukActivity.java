package com.example.antrianster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.antrianster.Data.DataPasien;
import com.example.antrianster.Data.DatabaseHelper;
import com.example.antrianster.Data.Pasien;

import java.util.Calendar;
import java.util.List;

public class MasukActivity extends AppCompatActivity {

    private EditText editTextNomor, editTextTglLhr;
    private Button btnMasuk;
    private boolean isAuthenticated;
    private DataPasien db_pasien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masuk);

        init();

        Log.d("coba","Berhasil");

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        editTextTglLhr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(MasukActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month + 1;
                        String date = dayOfMonth + "/" + month + "/" + year;
                        editTextTglLhr.setText(date);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });
        login();
    }


    void init() {
        editTextNomor = findViewById(R.id.editTextNomor);
        editTextTglLhr = findViewById(R.id.editTextTglLhr);
        btnMasuk = findViewById(R.id.btnMasuk);
    }

    void login(){
        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nik = editTextNomor.getText().toString();
                String tgl = editTextTglLhr.getText().toString();
                isAuthenticated = false;
                db_pasien= new DataPasien(MasukActivity.this);
                db_pasien.open();
                Pasien pasien = db_pasien.logInUser(nik, tgl);
                if(pasien.getNik().isEmpty()){
                    Toast.makeText(MasukActivity.this, "NIK atau Tanggal Lahir salah", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(MasukActivity.this, PilihKlinikActivity.class);
                    startActivity(intent);
                }
                db_pasien.close();
                /*if(pasien.isEmpty()){
                    Toast.makeText(MasukActivity.this, "Database kosong, silakan buat akun baru", Toast.LENGTH_LONG).show();
                }else {
                        int pasien_id = pasien.getId();
                        String pasien_nama = pasien.getNama();
                        String pasien_jk = pasien.getJk();
                        String pasien_tgl = pasien.get_tgl();
                        String pasien_alamat = pasien.getAlamat();
                        String pasien_nohp = pasien.getNohp();
                        String pasien_agama = pasien.getAgama();
                        String pasien_nik = pasien.getNik();
                        if (pasien_nik.equals(nik)) {
                            isAuthenticated = true;
                            db_pasien.logOneUser(pasien_id,1);
//                            Toast.makeText(MainActivity.this, "Logged in:"+user_id, Toast.LENGTH_SHORT).show();
//                            Intent intent = new Intent(MasukActivity.this, PilihKlinikActivity.class);
//                            startActivity(intent);
                            break;
                        }else {
                            Toast.makeText(MasukActivity.this, "NIK atau Tanggal Lahir salah", Toast.LENGTH_SHORT).show();
                        }


                    *//*if(!isAuthenticated) {

                    }*//*
                }*/
            }
        });
    }
}