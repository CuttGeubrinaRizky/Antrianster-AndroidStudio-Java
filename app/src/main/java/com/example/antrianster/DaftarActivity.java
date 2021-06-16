package com.example.antrianster;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Calendar;

public class DaftarActivity extends AppCompatActivity {

    private Spinner spinner2;
    private EditText editTextTanggal;
    private DatePickerDialog.OnDateSetListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        spinner2 = findViewById(R.id.spinner2);
        editTextTanggal= findViewById(R.id.editTextTanggal);

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
        Intent intent = new Intent (DaftarActivity.this, DashboardActivity.class);
        startActivity(intent);
    }
}