# Laporan Program: Sistem Manajemen Resep Makanan Unik

**Disusun oleh:** Dwi Prasetyawan   
Post-Test 1 Praktikum PBO

---
## 1. Pendahuluan
**Sistem Manajemen Resep Makanan Unik** adalah aplikasi berbasis konsol (CLI) yang dirancang untuk membantu pengguna mendokumentasikan resep masakan secara terstruktur. Program ini dibuat menggunakan bahasa pemrograman Java dengan fokus pada kemudahan penggunaan dan implementasi konsep **Object-Oriented Programming (OOP)**.

## 2. Fitur Utama
Program ini mengimplementasikan fungsi **CRUD** (Create, Read, Update, Delete) yang berjalan secara dinamis menggunakan `ArrayList`:

* **Tambah Resep (Create):** Pengguna dapat memasukkan data identitas resep (Nama, Asal, Kesulitan) dan menambahkan banyak bahan sekaligus menggunakan perulangan `while`.
* **Lihat Semua Resep (Read):** Menampilkan daftar seluruh resep yang tersimpan beserta ID unik dan rincian bahan-bahannya.
* **Update Data Selektif (Update):** Memungkinkan pengguna mengubah nama, asal negara, atau melakukan reset total pada daftar bahan tanpa menghapus identitas utama resep.
* **Hapus Resep (Delete):** Menghapus data resep tertentu dari sistem berdasarkan ID unik yang dipilih.
* **Menu Interaktif:** Program berjalan terus-menerus dalam loop `while` sampai pengguna memilih opsi keluar.

## 3. Arsitektur Class
Program ini terdiri dari tiga class utama yang saling berhubungan melalui prinsip **Komposisi**:



| Class | Deskripsi | Atribut Utama |
| :--- | :--- | :--- |
| **`Main`** | Class utama yang mengontrol alur program dan interaksi pengguna. | `daftarResep` (ArrayList), `input` (Scanner) |
| **`Resep`** | Entitas utama yang menampung informasi makanan dan daftar objek bahan. | `id`, `nama`, `asal`, `kesulitan`, `listBahan` (ArrayList) |
| **`Bahan`** | Entitas pendukung yang mewakili satu item bahan makanan. | `namaBahan` |

## 4. Analisis Logika Program
### A. Struktur Data Dinamis
Program menggunakan **`ArrayList<Resep>`** untuk menyimpan data secara fleksibel. Berbeda dengan array biasa, `ArrayList` memungkinkan penambahan dan penghapusan data tanpa perlu mendefinisikan kapasitas maksimal di awal program.

### B. Relasi Komposisi (One-to-Many)
Setiap objek `Resep` memiliki atribut berupa **`ArrayList<Bahan>`**. Hal ini menunjukkan relasi di mana satu resep dapat memiliki banyak bahan. Logika ini memudahkan pengelolaan data yang kompleks seperti daftar belanja atau langkah-langkah komposisi.

### C. Manajemen Input & Buffer
Program menggunakan objek `Scanner` untuk menangkap input pengguna. Untuk menghindari kesalahan pembacaan saat berpindah dari input angka ke teks, program menerapkan perintah `input.nextLine()` untuk membersihkan sisa *buffer* pada memori.

## 5. Panduan Instalasi & Menjalankan Program
1.  Pastikan Java JDK sudah terpasang di perangkat Anda.
2.  Letakkan file `Main.java`, `Resep.java`, dan `Bahan.java` dalam struktur folder `org/kzdwi/pt1/`.
3.  Buka Terminal atau Command Prompt dan masuk ke folder `src`.
4.  Kompilasi program:
    ```bash
    javac org/kzdwi/pt1/*.java
    ```
5.  Jalankan program:
    ```bash
    java org.kzdwi.pt1.Main
    ```