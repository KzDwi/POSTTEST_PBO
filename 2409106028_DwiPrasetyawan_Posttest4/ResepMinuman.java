package org.kzdwi.pbo;

public class ResepMinuman extends Resep {
    private String suhu;

    public ResepMinuman(int id, String nama, String asal, int kesulitan, String suhu) {
        super(id, nama, asal, kesulitan);
        this.suhu = suhu;
    }

    @Override
    public void tampilkanDetail() {
        super.tampilkanDetail();
        System.out.print(" [Suhu: " + suhu + "]\n");
    }

    @Override
    public String getKategori() {
        return "Minuman";
    }

    public String getSuhu() { return suhu; }
    public void setSuhu(String suhu) { this.suhu = suhu; }
}