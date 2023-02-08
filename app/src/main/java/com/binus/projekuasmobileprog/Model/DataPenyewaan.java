package com.binus.projekuasmobileprog.Model;

public class DataPenyewaan {

    private int idPenyewaan, ruangId;
    private String namaPenyewa, judulFilm, tanggalPenyewaan, jamPenyewaan;

    public int getIdPenyewaan() {
        return idPenyewaan;
    }

    public void setIdPenyewaan(int idPenyewaan) {
        this.idPenyewaan = idPenyewaan;
    }

    public int getRuangId() {
        return ruangId;
    }

    public void setRuangId(int ruangId) {
        this.ruangId = ruangId;
    }

    public String getNamaPenyewa() {
        return namaPenyewa;
    }

    public void setNamaPenyewa(String namaPenyewa) {
        this.namaPenyewa = namaPenyewa;
    }

    public String getJudulFilm() {
        return judulFilm;
    }

    public void setJudulFilm(String judulFilm) {
        this.judulFilm = judulFilm;
    }

    public String getTanggalPenyewaan() {
        return tanggalPenyewaan;
    }

    public void setTanggalPenyewaan(String tanggalPenyewaan) {
        this.tanggalPenyewaan = tanggalPenyewaan;
    }

    public String getJamPenyewaan() {
        return jamPenyewaan;
    }

    public void setJamPenyewaan(String jamPenyewaan) {
        this.jamPenyewaan = jamPenyewaan;
    }
}
