package org.kzdwi.pbo;

import java.util.ArrayList;

// Menambahkan kata kunci 'abstract' dan 'implements'
public abstract class Resep implements Rating {
    private int id;
    private String nama;
    private String asal;
    private int kesulitan;
    private ArrayList<Bahan> listBahan = new ArrayList<>();

    public Resep(int id, String nama, String asal) {
        this.id = id;
        this.nama = nama;
        this.asal = asal;
        this.kesulitan = 1;
    }

    public Resep(int id, String nama, String asal, int kesulitan) {
        this.id = id;
        this.nama = nama;
        this.asal = asal;
        this.kesulitan = kesulitan;
    }

    public void tambahBahan(Bahan bahan) {
        this.listBahan.add(bahan);
    }

    public void tambahBahan(String namaBahan) {
        this.listBahan.add(new Bahan(namaBahan));
    }

    public void tampilkanDetail() {
        System.out.print("ID: " + id + " - " + nama + " (" + asal + ")");
    }

    // --- PENERAPAN ABSTRACT METHOD ---
    // Method ini tidak memiliki body dan harus di-override di class turunan 
    public abstract String getKategori();

    // --- IMPLEMENTASI INTERFACE ---
    // Class yang mengimplement interface harus membuat semua method yang didefinisikan 
    @Override
    public void tampilkanLevelKesulitan() {
        System.out.println("Tingkat Kesulitan: " + kesulitan + " dari 5");
    }

    @Override
    public boolean isRekomendasiPemula() {
        return kesulitan <= 2; // Jika kesulitan 1 atau 2, maka direkomendasikan untuk pemula
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