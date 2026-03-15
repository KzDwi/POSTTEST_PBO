package org.kzdwi.pt1;

public class Bahan {
    private String namaBahan;

    public Bahan(String nama) {
        this.namaBahan = nama;
    }

    //  Getter
    public String getNamaBahan() {
        return namaBahan;
    }

    //  Setter
    public void setNamaBahan(String namaBahan) {
        this.namaBahan = namaBahan;
    }
}