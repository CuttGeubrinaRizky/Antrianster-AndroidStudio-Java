package com.example.antrianster.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DataPasien{
    private SQLiteDatabase database;
    private DatabaseHelper dbhelper;

    public DataPasien(Context context){
        dbhelper = new DatabaseHelper(context);
    }

    public void open() throws SQLException {
        database = dbhelper.getWritableDatabase();
    }

    public void close(){
        dbhelper.close();
    }

    public void addPasien(Pasien pasien){
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.KEY_NAMA, pasien.getNama());
        values.put(DatabaseHelper.KEY_JK, pasien.getJk());
        values.put(DatabaseHelper.KEY_TANGGAL, pasien.get_tgl());
        values.put(DatabaseHelper.KEY_ALAMAT, pasien.getAlamat());
        values.put(DatabaseHelper.KEY_HP, pasien.getNohp());
        values.put(DatabaseHelper.KEY_AGAMA, pasien.getAgama());
        values.put(DatabaseHelper.KEY_NIK, pasien.getNik());
        values.put(DatabaseHelper.KEY_LOGGED, pasien.getLogged());

        //inserting row
        database.insert(DatabaseHelper.TABLE_PASIEN, null, values);
    }

    public Pasien logInUser(String nik, String tgl) {
        database = dbhelper.getReadableDatabase();
        String queryUser = "SELECT * FROM " + DatabaseHelper.TABLE_PASIEN +" WHERE " + DatabaseHelper.KEY_NIK + "= '" + nik + "' and " + DatabaseHelper.KEY_TANGGAL + "= '" + tgl + "'";
       /* database.execSQL(queryUser);*/
        System.out.println(queryUser);
        Pasien pasien;
        pasien = new Pasien();
        Cursor cursor = database.rawQuery(queryUser, null);
        if(cursor.getCount()!=1) {
            return pasien;
        }
        //looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            pasien.setId(Integer.parseInt(String.valueOf(cursor.getColumnIndex(DatabaseHelper.KEY_ID))));
            Log.i("pasienid", String.valueOf(Integer.parseInt(String.valueOf(cursor.getColumnIndex(DatabaseHelper.KEY_ID)))));
            pasien.setNik(cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_NIK)));
            Log.i("nomorinduk", cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_NIK)));
            pasien.setNama(cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_NAMA)));
            Log.i("nama", cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_NAMA)));
            pasien.setJk(cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_JK)));
            Log.i("jenisk", cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_JK)));
            pasien.set_tgl(cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_TANGGAL)));
            Log.i("tanggalahir", cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_TANGGAL)));
            pasien.setAlamat(cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_ALAMAT)));
            Log.i("alamat", cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_ALAMAT)));
            pasien.setNohp(cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_HP)));
            Log.i("nohp", cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_HP)));
            pasien.setAgama(cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_AGAMA)));
            Log.i("agama", cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_AGAMA)));
            pasien.setLogged(Integer.parseInt(String.valueOf(cursor.getColumnIndex(DatabaseHelper.KEY_LOGGED))));
            Log.i("teslog", String.valueOf(Integer.parseInt(String.valueOf(cursor.getColumnIndex(DatabaseHelper.KEY_LOGGED)))));
        }
        cursor.close();
        return pasien;
    }

    public void logOneUser(int id, int log) {
        database = dbhelper.getWritableDatabase();
        String queryString = "UPDATE " + DatabaseHelper.TABLE_PASIEN
                + " SET " + DatabaseHelper.KEY_LOGGED + " = " + log + " WHERE " + DatabaseHelper.KEY_ID + " = " + id;
        database.execSQL(queryString);
    }

    public List<Pasien> getAllPasien(){
        database = dbhelper.getReadableDatabase();

        List<Pasien> listPasien = new ArrayList<Pasien>();

        //select all data pasien
        String allPasien = "SELECT * FROM " + DatabaseHelper.TABLE_PASIEN;
        Cursor cursor = database.rawQuery(allPasien, null);

        //looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Pasien pasien = new Pasien();
                pasien.setId(Integer.parseInt(cursor.getString(0)));
                pasien.setNik(cursor.getString(1));
                pasien.setNama(cursor.getString(2));
                pasien.setJk(cursor.getString(3));
                pasien.set_tgl(cursor.getString(4));
                pasien.setAlamat(cursor.getString(5));
                pasien.setNohp(cursor.getString(6));
                pasien.setAgama(cursor.getString(7));

                //adding mahasiswa to the list
                listPasien.add(pasien);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return listPasien;
    }

    public Pasien getLoggedInUser(){
        database = dbhelper.getReadableDatabase();
        Pasien pasien = null;

        String allUsers = "SELECT * FROM " + DatabaseHelper.TABLE_PASIEN +" WHERE " + DatabaseHelper.KEY_LOGGED + "= 1";
        Cursor cursor = database.rawQuery(allUsers, null);

        //looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            pasien = new Pasien();
            pasien.setId(Integer.parseInt(cursor.getString(0)));
            pasien.setNik(cursor.getString(1));
            pasien.setNama(cursor.getString(2));
            pasien.setJk(cursor.getString(3));
            pasien.set_tgl(cursor.getString(4));
            pasien.setAlamat(cursor.getString(5));
            pasien.setNohp(cursor.getString(6));
            pasien.setAgama(cursor.getString(7));
            pasien.setLogged(Integer.parseInt(cursor.getString(8)));
        }
        cursor.close();
        return pasien;
    }
}

