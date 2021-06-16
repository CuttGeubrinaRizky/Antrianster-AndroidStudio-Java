package com.example.antrianster.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DataMahasiswa extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "pasien.db";

    public static final String TABLE_PASIEN = "tb_pasien";

    public static final String KEY_ID = "id";
    public static final String KEY_NAMA = "nama";
    public static final String KEY_JK = "jk";
    public static final String KEY_ALAMAT = "alamat";
    public static final String KEY_HP = "no hp";
    public static final String KEY_AGAMA = "agama";
    public static final String KEY_NIK = "nik";

    public DataMahasiswa(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_PASIEN = "CREATE TABLE " + TABLE_PASIEN + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAMA + " TEXT,"
                + KEY_JK + " TEXT," + KEY_ALAMAT +" TEXT," + KEY_HP + " TEXT," + KEY_AGAMA + " TEXT," + KEY_NIK + " TEXT" + ")";
        db.execSQL(CREATE_TABLE_PASIEN);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //drop tabel jika sudah pernah ada
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PASIEN;

        //create table again
        onCreate(db);
    }
}
