package com.example.akb_uts_10117216_if7;

public class DaftarTemanModel {

    private String nim;
    private String nama;
    private String kelas;
    private String telp;
    private String email;
    private String sosmed;

    public DaftarTemanModel(String nim, String nama, String kelas, String telp, String email, String sosmed) {
        this.nim = nim;
        this.nama = nama;
        this.kelas = kelas;
        this.telp = telp;
        this.email = email;
        this.sosmed = sosmed;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSosmed() {
        return sosmed;
    }

    public void setSosmed(String sosmed) {
        this.sosmed = sosmed;
    }
}


// 12 mei 2020
// 10117216 - Adi Prayoga - IF7