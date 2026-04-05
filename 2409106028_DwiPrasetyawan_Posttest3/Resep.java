package org.kzdwi.pbo;

import java.util.ArrayList;

public class Resep {
    private int id;
    private String nama;
    private String asal;
    private int kesulitan;
    private ArrayList<Bahan> listBahan = new ArrayList<>();

    public Resep(int id, String nama, String asal, int kesulitan) {
        this.id = id;
        this.nama = nama;
        this.asal = asal;
        this.kesulitan = kesulitan;
    }

    public ArrayList<Bahan> getListBahan() { return listBahan; }
    public int getId() { return id; }
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public String getAsal() { return asal; }
    public void setAsal(String asal) { this.asal = asal; }
    public int getKesulitan() { return kesulitan; }
    public void setKesulitan(int k) { this.kesulitan = k; }
}