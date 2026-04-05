package org.kzdwi.pbo;

public class ResepMinuman extends Resep {
    private String suhu; // Atribut khusus minuman (Contoh: Panas, Dingin)

    public ResepMinuman(int id, String nama, String asal, int kesulitan, String suhu) {
        super(id, nama, asal, kesulitan);
        this.suhu = suhu;
    }

    public String getSuhu() { return suhu; }
    public void setSuhu(String suhu) { this.suhu = suhu; }
}