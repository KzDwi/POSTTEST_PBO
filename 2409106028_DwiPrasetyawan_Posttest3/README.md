# Laporan Program: Sistem Manajemen Resep Makanan & Minuman Unik

**Disusun oleh:** Dwi Prasetyawan   
**Mata Kuliah:** Pemrograman Berorientasi Objek (Post-test 3)

---

## 1. Pendahuluan
**Sistem Manajemen Resep Makanan & Minuman Unik** adalah aplikasi CLI (Command Line Interface) berbasis Java yang dirancang untuk mendokumentasikan resep secara terstruktur. 

Pada pembaruan versi ini, program telah mengimplementasikan konsep **Inheritance** (Pewarisan) untuk mengelompokkan resep ke dalam kategori yang lebih spesifik. Hal ini memungkinkan sistem untuk menangani perbedaan karakteristik antara makanan padat dan minuman cair dalam satu ekosistem yang sama.

## 2. Fitur Utama
Program ini mengimplementasikan fungsi **CRUD** (Create, Read, Update, Delete) yang dinamis dengan tambahan logika pewarisan:

* **Tambah Resep Spesifik (Create):** Pengguna dapat memilih tipe resep (Makanan atau Minuman). Setiap tipe memiliki input unik:
    * **Makanan:** Menambahkan data jenis karbohidrat (contoh: Nasi, Roti).
    * **Minuman:** Menambahkan data suhu penyajian (contoh: Dingin, Panas).
* **Lihat Semua Resep (Read):** Menampilkan daftar seluruh resep. Program secara cerdas menampilkan informasi tambahan yang berbeda tergantung apakah objek tersebut adalah makanan atau minuman.
* **Update Data (Update):** Mengubah informasi dasar resep atau memperbarui daftar bahan tanpa menghilangkan identitas objek asli.
* **Hapus Resep (Delete):** Menghapus resep tertentu dari memori berdasarkan ID unik.

## 3. Arsitektur File & Direktori
Proyek ini disusun dalam package `org.kzdwi.pbo` dengan struktur file sebagai berikut:

| Nama File | Peran dalam OOP | Deskripsi |
| :--- | :--- | :--- |
| **`Main.java`** | Driver Class | Memuat `main method` dan logika alur program (Menu). |
| **`Resep.java`** | **Superclass** | Kelas induk yang menampung atribut umum (ID, Nama, Asal). |
| **`ResepMakanan.java`** | **Subclass** | Spesialisasi resep untuk kategori makanan (Inherit dari Resep). |
| **`ResepMinuman.java`** | **Subclass** | Spesialisasi resep untuk kategori minuman (Inherit dari Resep). |
| **`Bahan.java`** | Entity Class | Kelas pendukung yang digunakan sebagai komponen dari sebuah resep. |

## 4. Implementasi Konsep Inheritance
Berdasarkan **Modul 4 - Inheritance**, program ini menerapkan:

1.  **Hierarchical Inheritance:** Satu superclass (`Resep`) diturunkan menjadi dua subclass sekaligus (`ResepMakanan` dan `ResepMinuman`).
2.  **Relasi IS-A:** * *ResepMakanan IS-A Resep* (Resep Makanan adalah sebuah Resep).
    * *ResepMinuman IS-A Resep* (Resep Minuman adalah sebuah Resep).
3.  **Penggunaan `super`:** Digunakan pada konstruktor subclass untuk mengirimkan data ke konstruktor superclass agar tidak terjadi duplikasi kode (*code redundancy*).
4.  **Polymorphism & Instanceof:** Program menggunakan operator `instanceof` pada kelas `Main` untuk mendeteksi tipe objek secara real-time saat menampilkan data, sehingga atribut spesifik subclass dapat diakses melalui *type casting*.

## 5. Analisis Logika
### Manajemen Memori
Program menggunakan **`ArrayList<Resep>`**. Karena `Resep` adalah parent dari `ResepMakanan` dan `ResepMinuman`, maka satu List tersebut dapat menampung berbagai jenis objek anak sekaligus. Ini adalah bentuk efisiensi dalam manajemen koleksi data di Java.

### Encapsulation
Semua atribut pada kelas entitas menggunakan akses modifier `private`. Interaksi data dilakukan melalui method **Getter** dan **Setter**, memastikan integritas data tetap terjaga.

## 6. Cara Menjalankan Program
1.  Pastikan semua file berada dalam folder yang sesuai dengan struktur package: `src/org/kzdwi/pbo/`.
2.  Buka terminal/command prompt di direktori `src`.
3.  Kompilasi semua file:
    ```bash
    javac org/kzdwi/pbo/*.java
    ```
4.  Jalankan aplikasi:
    ```bash
    java org.kzdwi.pbo.Main
    ```

---
*© 2026 Dwi Prasetyawan - Informatika Universitas Mulawarman*