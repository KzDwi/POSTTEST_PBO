package org.kzdwi.pt1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Resep> daftarResep = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int idSekarang = 1;
        int pilihan = 0;

        while (pilihan != 5) {
            System.out.println("\n=== MENU RESEP MAKANAN ===");
            System.out.println("1. Tambah Resep");
            System.out.println("2. Lihat Semua Resep");
            System.out.println("3. Update Nama Resep");
            System.out.println("4. Hapus Resep");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine();

            if (pilihan == 1) {
                System.out.print("Nama Makanan: "); String nama = input.nextLine();
                System.out.print("Asal Negara: "); String asal = input.nextLine();
                System.out.print("Level Kesulitan (1-5): "); int sulit = input.nextInt();
                input.nextLine();

                Resep resepBaru = new Resep(idSekarang, nama, asal, sulit);

                String tambahLagi = "y";
                while (tambahLagi.equalsIgnoreCase("y")) {
                    System.out.print("Masukkan Nama Bahan: ");
                    String namaBahan = input.nextLine();
                    // Menggunakan getter untuk mengakses list
                    resepBaru.getListBahan().add(new Bahan(namaBahan));

                    System.out.print("Tambah bahan lagi? (y/n): ");
                    tambahLagi = input.nextLine();
                }

                daftarResep.add(resepBaru);
                idSekarang++;
                System.out.println("Resep berhasil disimpan!");

            } else if (pilihan == 2) {
                if (daftarResep.isEmpty()) {
                    System.out.println("Belum ada resep.");
                } else {
                    for (Resep r : daftarResep) {
                        System.out.println("\nID: " + r.getId() + " - " + r.getNama() + " (" + r.getAsal() + ")");
                        System.out.print("Bahan-bahan: ");

                        // Menggunakan getter untuk list dan atribut bahan
                        ArrayList<Bahan> bahanResep = r.getListBahan();
                        for (int j = 0; j < bahanResep.size(); j++) {
                            System.out.print(bahanResep.get(j).getNamaBahan());
                            if (j < bahanResep.size() - 1) System.out.print(", ");
                        }
                        System.out.println();
                    }
                }

            } else if (pilihan == 3) {
                System.out.print("Masukkan ID resep yang ingin diubah: ");
                int cariId = input.nextInt();
                input.nextLine();

                boolean ketemu = false;
                for (Resep r : daftarResep) {
                    if (r.getId() == cariId) {
                        ketemu = true;
                        System.out.println("Data ditemukan: " + r.getNama());

                        System.out.print("Ubah Nama? (y/n): ");
                        if(input.nextLine().equalsIgnoreCase("y")) {
                            System.out.print("Masukkan Nama Baru: ");
                            r.setNama(input.nextLine());
                        }

                        System.out.print("Ubah Asal? (y/n): ");
                        if(input.nextLine().equalsIgnoreCase("y")) {
                            System.out.print("Masukkan Asal Baru: ");
                            r.setAsal(input.nextLine());
                        }

                        System.out.print("Ubah Daftar Bahan? (y/n): ");
                        if(input.nextLine().equalsIgnoreCase("y")) {
                            r.getListBahan().clear();
                            String tambahLagi = "y";
                            while (tambahLagi.equalsIgnoreCase("y")) {
                                System.out.print("Masukkan Nama Bahan Baru: ");
                                String namaBahan = input.nextLine();
                                r.getListBahan().add(new Bahan(namaBahan));

                                System.out.print("Tambah bahan lagi? (y/n): ");
                                tambahLagi = input.nextLine();
                            }
                        }
                        System.out.println("Data resep berhasil diperbarui!");
                        break;
                    }
                }
                if (!ketemu) System.out.println("ID tidak ditemukan.");

            } else if (pilihan == 4) {
                System.out.print("Masukkan ID resep yang ingin dihapus: ");
                int hapusId = input.nextInt();
                input.nextLine();

                for (int i = 0; i < daftarResep.size(); i++) {
                    if (daftarResep.get(i).getId() == hapusId) {
                        daftarResep.remove(i);
                        System.out.println("Resep berhasil dihapus!");
                        break;
                    }
                }
            }
        }
        System.out.println("Program selesai.");
        input.close();
    }
}