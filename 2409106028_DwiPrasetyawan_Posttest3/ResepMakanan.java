package org.kzdwi.pbo;

public class ResepMakanan extends Resep {
    private String jenisKarbo; // Atribut khusus makanan (Contoh: Nasi, Mie, Roti)

    public ResepMakanan(int id, String nama, String asal, int kesulitan, String jenisKarbo) {
        super(id, nama, asal, kesulitan); // Memanggil konstruktor superclass
        this.jenisKarbo = jenisKarbo;
    }

    public String getJenisKarbo() { return jenisKarbo; }
    public void setJenisKarbo(String jenisKarbo) { this.jenisKarbo = jenisKarbo; }
}