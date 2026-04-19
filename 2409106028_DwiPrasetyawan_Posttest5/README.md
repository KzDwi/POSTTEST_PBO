# Laporan Program: Sistem Manajemen Resep Makanan & Minuman Unik

**Disusun oleh:** Dwi Prasetyawan   
**Mata Kuliah:** Pemrograman Berorientasi Objek (Post-test 5)

---

## 1. Pendahuluan
**Sistem Manajemen Resep Makanan & Minuman Unik** adalah aplikasi CLI (Command Line Interface) berbasis Java yang dirancang untuk mendokumentasikan resep secara terstruktur. 

Pada pembaruan versi ini, program telah berevolusi lebih jauh dengan mengimplementasikan konsep **Abstraction** (Abstraksi) dan **Interface** (Antarmuka). Melalui penerapan *Abstract Class* dan *Interface*, program kini memiliki fondasi kerangka *template* yang lebih kuat dan "kontrak" ketat yang harus dipenuhi oleh class turunannya, menyembunyikan detail implementasi kompleks dan hanya menampilkan fungsionalitas esensial.

## 2. Fitur Utama
Program ini mengimplementasikan fungsi **CRUD** (Create, Read, Update, Delete) yang dinamis dengan tambahan fitur evaluasi resep:

* **Tambah Resep Spesifik (Create):** Pengguna dapat memilih tipe resep (Makanan atau Minuman). Proses ini ditangani oleh class turunan karena class induk kini bersifat abstrak dan tidak bisa diinstansiasi secara langsung.
* **Lihat Semua Resep & Evaluasi (Read):** Menampilkan daftar seluruh resep beserta evaluasi tingkat kesulitan dan rekomendasi bagi pemula (berkat implementasi *Interface*).
* **Update Data (Update):** Mengubah informasi dasar resep atau memperbarui daftar bahan.
* **Hapus Resep (Delete):** Menghapus resep tertentu dari koleksi berdasarkan ID unik.

## 3. Arsitektur File & Direktori
Proyek ini disusun dalam package `org.kzdwi.pbo` dengan struktur file sebagai berikut:

| Nama File | Peran dalam OOP | Deskripsi |
| :--- | :--- | :--- |
| **`Main.java`** | Driver Class | Memuat `main method` dan alur logika program (Menu). Tempat di mana implementasi antarmuka dan abstraksi dipanggil. |
| **`Penilaian.java`**| **Interface** | (*BARU*) Sebuah antarmuka yang mendefinisikan kontrak penilaian untuk sebuah resep (memuat minimal 2 method). |
| **`Resep.java`** | **Abstract Class** | Kelas induk abstrak yang tidak dapat diinstansiasi langsung. Mengimplementasikan antarmuka `Penilaian` dan memuat *abstract method*. |
| **`ResepMakanan.java`** | **Subclass** | Mengimplementasikan bentuk nyata dari *abstract method* induknya, khusus untuk data makanan (Karbohidrat). |
| **`ResepMinuman.java`** | **Subclass** | Mengimplementasikan bentuk nyata dari *abstract method* induknya, khusus untuk data minuman (Suhu). |
| **`Bahan.java`** | Entity Class | Kelas pendukung yang dikomposisikan ke dalam sebuah resep. |

## 4. Implementasi Konsep Abstraction & Interface
Berdasarkan **Modul 6 - Abstraction**, program ini melakukan perombakan struktur untuk memenuhi kaidah enkapsulasi dan abstraksi tingkat lanjut:

### A. Abstract Class & Abstract Method
1. **Abstract Class (`Resep`):** Kelas `Resep` diubah dengan menambahkan *keyword* `abstract`. Hal ini mencegah pembuatan objek `Resep` secara mentah, memaksa program untuk selalu menspesifikkan apakah objek tersebut Makanan atau Minuman (lewat polimorfisme pada class turunannya).
2. **Abstract Method (`getKategori()`):** Di dalam kelas `Resep`, terdapat deklarasi `public abstract String getKategori();` tanpa *body* method. Hal ini memaksa (mewajibkan) subclass `ResepMakanan` dan `ResepMinuman` untuk melakukan *override* dan mendefinisikan logikanya masing-masing.

### B. Interface Implementation
1. **Pembuatan Interface:** Kelas `Penilaian` dibuat menggunakan *keyword* `interface`. Di dalamnya memuat 2 method murni tanpa *body*: `tampilkanLevelKesulitan()` dan `isRekomendasiPemula()`.
2. **Implementasi pada Class:** Abstract class `Resep` menggunakan *keyword* `implements Penilaian` untuk mengikat kontrak dengan antarmuka tersebut. Hasilnya, method yang ada pada interface didefinisikan perilaku nyatanya di dalam kelas `Resep`, sehingga seluruh subclass turunannya otomatis mewarisi fitur evaluasi kesulitan resep ini.

## 5. Analisis Logika
Dengan mengkombinasikan *Abstract Class* dan *Interface*, kita memisahkan konsep "Apa yang harus dilakukan oleh objek" dari "Bagaimana objek itu melakukannya". *Abstract class* `Resep` bertindak sebagai *template* hierarkis yang solid untuk pewarisan sifat dasar resep, sementara *Interface* `Penilaian` bertindak sebagai kontrak standarisasi fitur di luar hierarki utama. Ini membuat sistem menjadi sangat terstruktur, *scalable*, dan mencegah *programmer* lupa mengimplementasikan fungsi krusial pada resep jenis baru di masa depan.

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