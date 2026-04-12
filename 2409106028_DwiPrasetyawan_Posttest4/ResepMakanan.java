package org.kzdwi.pbo;

public class ResepMakanan extends Resep {
    private String jenisKarbo;

    public ResepMakanan(int id, String nama, String asal, int kesulitan, String jenisKarbo) {
        super(id, nama, asal, kesulitan); 
        this.jenisKarbo = jenisKarbo;
    }

    @Override
    public void tampilkanDetail() {
        super.tampilkanDetail(); // Memanggil cetakan superclass
        System.out.print(" [Karbo: " + jenisKarbo + "]\n"); // Menambahkan detail spesifik
    }

    @Override
    public String getKategori() {
        return "Makanan";
    }

    public String getJenisKarbo() { return jenisKarbo; }
    public void setJenisKarbo(String jenisKarbo) { this.jenisKarbo = jenisKarbo; }
}