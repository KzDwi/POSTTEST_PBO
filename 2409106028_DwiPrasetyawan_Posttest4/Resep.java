package org.kzdwi.pbo;

import java.util.ArrayList;

public class Resep {
    private int id;
    private String nama;
    private String asal;
    private int kesulitan;
    private ArrayList<Bahan> listBahan = new ArrayList<>();

    // --- 1. OVERLOADING (Constructor) ---
    // Jika kesulitan tidak diisi, defaultnya adalah 1
    public Resep(int id, String nama, String asal) {
        this.id = id;
        this.nama = nama;
        this.asal = asal;
        this.kesulitan = 1;
    }

    // Constructor utama dengan parameter lengkap (Overloading)
    public Resep(int id, String nama, String asal, int kesulitan) {
        this.id = id;
        this.nama = nama;
        this.asal = asal;
        this.kesulitan = kesulitan;
    }

    // Cara 1: Menambah bahan dengan mengirim objek Bahan
    public void tambahBahan(Bahan bahan) {
        this.listBahan.add(bahan);
    }

    // Cara 2: Menambah bahan dengan mengirim String namanya saja (Lebih praktis)
    public void tambahBahan(String namaBahan) {
        this.listBahan.add(new Bahan(namaBahan));
    }

    public void tampilkanDetail() {
        System.out.print("ID: " + id + " - " + nama + " (" + asal + ") | Level: " + kesulitan);
    }

    public String getKategori() {
        return "Resep Umum";
    }

    // Getter & Setter standar
    public ArrayList<Bahan> getListBahan() { return listBahan; }
    public int getId() { return id; }
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public String getAsal() { return asal; }
    public void setAsal(String asal) { this.asal = asal; }
    public int getKesulitan() { return kesulitan; }
    public void setKesulitan(int k) { this.kesulitan = k; }
}