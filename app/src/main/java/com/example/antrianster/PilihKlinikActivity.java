package com.example.antrianster;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.os.Bundle;

import java.util.Calendar;

public class PilihKlinikActivity extends AppCompatActivity {

    private Spinner spinner;
    private EditText editTextDate;
    private DatePickerDialog.OnDateSetListener listener;
    private int antrian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_klinik);

        spinner = findViewById(R.id.spinner);
        editTextDate = findViewById(R.id.editTextDate);
        antrian = 0;

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        String[] poliklinik = getResources().getStringArray(R.array.poliklinik);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, poliklinik);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        editTextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(PilihKlinikActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month + 1;
                        String date = dayOfMonth + "/" + month + "/" + year;
                        editTextDate.setText(date);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });
    }

    public void btnKirim(View view) {
        this.antrian++;
        Intent intent = new Intent (PilihKlinikActivity.this, NomorAntrianActivity.class);
        intent.putExtra("Nomor Antrian", this.antrian);
        startActivity(intent);
    }
}