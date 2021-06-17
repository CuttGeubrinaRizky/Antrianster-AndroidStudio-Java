package com.example.antrianster;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.antrianster.Data.DataPasien;
import com.example.antrianster.Data.DatabaseHelper;
import com.example.antrianster.Data.Pasien;

import java.util.Calendar;

public class DaftarActivity extends AppCompatActivity {

    private DataPasien db;
    private SQLiteDatabase database;
    private DatabaseHelper dbhelper;

    private Spinner spinner2;
    private EditText editTextTanggal, editTextNama, editTextNIK, editTextAlamat, editTextAgama, editNumHp;
    private DatePickerDialog.OnDateSetListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        spinner2 = findViewById(R.id.spinner2);
        editTextTanggal= findViewById(R.id.editTextTanggal);
        editTextNama= findViewById(R.id.editTextNama);
        editTextNIK= findViewById(R.id.editTextNIK);
        editTextAlamat= findViewById(R.id.editTextAlamat);
        editTextAgama= findViewById(R.id.editTextAgama);
        editNumHp= findViewById(R.id.editNumHp);

        db = new DataPasien(DaftarActivity.this);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        String[] jeniskelamin = getResources().getStringArray(R.array.jeniskelamin);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, jeniskelamin);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);

        editTextTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(DaftarActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month + 1;
                        String date = dayOfMonth + "/" + month + "/" + year;
                        editTextTanggal.setText(date);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });
    }

    public void btnKirim(View view) {
        db.open();
        db.addPasien(new Pasien(editTextNama.getText().toString(), spinner2.getSelectedItem().toString(), editTextTanggal.getText().toString(), editTextAlamat.getText().toString(), editNumHp.getText().toString(), editTextAgama.getText().toString(), editTextNIK.getText().toString()));
        db.close();
        Toast.makeText(DaftarActivity.this, "Data added!", Toast.LENGTH_LONG).show();
        Intent intent = new Intent (DaftarActivity.this, DashboardActivity.class);
        intent.putExtra("Nama", editTextNama.getText().toString());
        intent.putExtra("NIK", editTextNIK.getText().toString());
        intent.putExtra("No.Hp", editNumHp.getText().toString());
        startActivity(intent);
    }
}