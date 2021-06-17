package com.example.antrianster.Data;

public class Pasien {

    int _id;
    String _nama;
    String _jk;
    String _tgl;
    String _alamat;
    String _nohp;
    String _agama;
    String _nik;
    int _logged;

    //Empty constructor
    //Default constructor
    public Pasien(){

    }

    //Constructor
    public Pasien(String nama, String jk, String tgl, String alamat, String nohp, String agama, String nik){
        this._nama = nama;
        this._jk = jk;
        this._tgl = tgl;
        this._alamat = alamat;
        this._nohp = nohp;
        this._agama = agama;
        this._nik = nik;
        this._logged = 1;
    }


    public int getId() {
        return this._id;
    }

    public void setId(int id) {
        this._id = id;
    }

    public String getNama(){
        return this._nama;
    }

    public void setNama(String nama){
        this._nama = nama;
    }

    public String getJk(){
        return this._jk;
    }

    public void setJk(String jk){
        this._jk = jk;
    }

    public String get_tgl() { return _tgl; }

    public void set_tgl(String _tgl) { this._tgl = _tgl; }

    public String getAlamat() { return this._alamat; }

    public void setAlamat(String alamat) {
        this._alamat = alamat;
    }

    public String getNohp() {
        return this._nohp;
    }

    public void setNohp(String nohp) {
        this._nohp = nohp;
    }

    public String getAgama() {
        return this._agama;
    }

    public void setAgama(String agama) {
        this._agama = agama;
    }

    public String getNik() {
        return this._nik;
    }

    public void setNik(String nik) {
        this._nik = nik;
    }

    public int getLogged() {
        return this._logged;
    }

    public void setLogged(int logged) {
        this._logged = logged;
    }
}
