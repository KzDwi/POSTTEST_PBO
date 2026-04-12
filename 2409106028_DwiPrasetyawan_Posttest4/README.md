# Laporan Program: Sistem Manajemen Resep Makanan & Minuman Unik

**Disusun oleh:** Dwi Prasetyawan   
**Mata Kuliah:** Pemrograman Berorientasi Objek (Post-test 4)

---

## 1. Pendahuluan
**Sistem Manajemen Resep Makanan & Minuman Unik** adalah aplikasi CLI (Command Line Interface) berbasis Java yang dirancang untuk mendokumentasikan resep secara terstruktur. 

Pada pembaruan versi ini, program telah berevolusi dari sekadar menggunakan pewarisan (Inheritance) menjadi mengimplementasikan konsep **Polymorphism** (Polimorfisme). Dengan pembaruan ini, program menjadi lebih dinamis, bersih dari pengecekan tipe manual (`instanceof`), dan memiliki tingkat *code reusability* yang lebih tinggi sesuai standar industri *Object-Oriented Programming*.

## 2. Fitur Utama
Program ini mengimplementasikan fungsi **CRUD** (Create, Read, Update, Delete) yang dinamis:

* **Tambah Resep Spesifik (Create):** Pengguna dapat memilih tipe resep (Makanan atau Minuman). Proses penambahan bahan kini lebih fleksibel berkat adanya *method overloading*.
* **Lihat Semua Resep (Read):** Menampilkan daftar seluruh resep. Program secara otomatis (dinamis) menjalankan fungsi *output* yang berbeda tergantung pada wujud asli objek tersebut (makanan atau minuman) berkat *method overriding*.
* **Update Data (Update):** Mengubah informasi dasar resep atau memperbarui daftar bahan tanpa mengubah identitas dasar objek asli dari resep tersebut.
* **Hapus Resep (Delete):** Menghapus resep tertentu dari koleksi berdasarkan ID unik.

## 3. Arsitektur File & Direktori
Proyek ini disusun dalam package `org.kzdwi.pbo` dengan struktur file sebagai berikut:

| Nama File | Peran dalam OOP | Deskripsi |
| :--- | :--- | :--- |
| **`Main.java`** | Driver Class | Memuat `main method` dan alur logika program (Menu). Tidak ada lagi penggunaan `instanceof`. |
| **`Resep.java`** | **Superclass** | Kelas induk yang menyimpan atribut umum dan mendefinisikan *method* kerangka untuk di-override, serta fungsi *overloading*. |
| **`ResepMakanan.java`** | **Subclass** | Meng-override fungsi spesifik untuk mencetak tipe dan data karbohidrat. |
| **`ResepMinuman.java`** | **Subclass** | Meng-override fungsi spesifik untuk mencetak tipe dan data suhu penyajian. |
| **`Bahan.java`** | Entity Class | Kelas pendukung yang dikomposisikan ke dalam sebuah resep. |

## 4. Implementasi Konsep Polymorphism
Berdasarkan **Modul 5 - Polymorphism**, program ini telah mengeliminasi pengecekan tipe statis dan mengimplementasikan polimorfisme melalui 4 fungsi (2 Overload, 2 Override):

### A. Static Polymorphism (Method Overloading)
Terjadi pada kelas `Resep` di mana terdapat fungsi dengan nama sama namun parameter berbeda:
1. **Constructor Overloading:** Pembuatan objek `Resep` bisa dilakukan dengan mengisi parameter *kesulitan* ataupun tanpa parameter tersebut (akan diberikan nilai default 1).
2. **Method `tambahBahan()` Overloading:** Memudahkan programmer dalam menambahkan komposisi. Bisa langsung mengirim bentuk `String` nama bahannya, atau mengirim objek instansiasi `Bahan` secara utuh.

### B. Dynamic Polymorphism (Method Overriding)
Terjadi pada subclass `ResepMakanan` dan `ResepMinuman` yang menimpa method induknya (menggunakan sintaks `@Override`) untuk perilaku spesifik:
1. **Method `tampilkanDetail()`:** Subclass memanggil cetakan induknya melalui `super.tampilkanDetail()`, kemudian menambahkan output spesifik (seperti mencetak data Karbohidrat untuk makanan atau Suhu untuk minuman) di waku *runtime*.
2. **Method `getKategori()`:** Menimpa fungsi dasar untuk mengembalikan teks spesifik ("Makanan" atau "Minuman") tanpa perlu menggunakan pengecekan `instanceof` di kelas Main.

## 5. Analisis Logika
### Efisiensi Main Class (Tanpa `instanceof`)
Pada versi sebelumnya, kelas `Main` harus bertugas ganda melakukan pengecekan `if (r instanceof ResepMakanan)` untuk menampilkan atribut khusus. Melalui *Dynamic Polymorphism*, kelas `Main` kini hanya perlu memanggil `r.tampilkanDetail()`. Java Virtual Machine (JVM) akan secara otomatis mengenali "bentuk" asli dari objek tersebut saat *runtime* dan menjalankan fungsi spesifik milik subclass yang sesuai. Hal ini memenuhi prinsip desain program yang general dan *reusable*.

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