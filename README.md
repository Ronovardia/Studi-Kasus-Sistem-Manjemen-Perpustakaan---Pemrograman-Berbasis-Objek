# Sistem Manajemen Perpustakaan

## Latar Belakang

Perpustakaan kampus memiliki koleksi berikut:

- **Buku**: bisa dipinjam, dan bisa dicari berdasarkan judul/penulis.
- **DVD**: bisa dipinjam, dan bisa dicari.

Setiap item memiliki **ID**, **judul**, dan **tahun**. Status item ada tiga:

- **Tersedia**
- **Dipinjam** (oleh siapa dan tanggal berapa)
- **Hilang**

## Fitur Sistem

Sistem harus mampu:

1. Menambah item ke koleksi.
2. Mencari item berdasarkan kata kunci.
3. Meminjam dan mengembalikan item yang *borrowable*.
4. Menampilkan daftar item tersedia dan dipinjam.
5. Menangani error (item tidak ditemukan, sudah dipinjam, dan lainnya).

## Tujuan Pembelajaran

- Merancang **abstract class** dan **interface** secara kolaboratif.
- Menerapkan **multiple interface** pada kelas yang berbeda.
- Menggunakan **sealed class** untuk status item.
- Menerapkan **generic** (`Repository`) dan **collection**.
- Menerapkan **exception handling**.
- Melatih **kolaborasi** dan **integrasi kode**.

## Struktur File

```
src/
├── Main.kt
├── model/
│   ├── Employee.kt                (individu)
│   ├── LibraryItem.kt             (kelompok)
│   ├── interfaces/
│   │   ├── Taxable.kt             (individu)
│   │   ├── BonusEligible.kt       (individu)
│   │   ├── Borrowable.kt          (kelompok)
│   │   └── Searchable.kt          (kelompok)
│   ├── status/
│   │   ├── EmployeeStatus.kt      (individu)
│   │   └── ItemStatus.kt          (kelompok)
│   ├── subclasses/
│   │   ├── FullTimeEmployee.kt    (individu)
│   │   ├── ContractEmployee.kt    (individu)
│   │   ├── Intern.kt              (individu)
│   │   ├── Book.kt                (kelompok)
│   │   ├── Magazine.kt            (kelompok)
│   │   └── DVD.kt                 (kelompok)
│   └── manager/
│       ├── Company.kt             (individu)
│       ├── Repository.kt          (kelompok)
│       └── LibraryManager.kt      (kelompok)
└── exception/
    └── CustomExceptions.kt
```

## Pembagian Tugas Kelompok

| Nama | NIM | Peran | Tugas |
|------|-----|-------|-------|
| **Renisa Rahmawati** | 225443025 | Arsitek, Integrator & Exception | Mendesain abstract class `LibraryItem`, interface `Borrowable` dan `Searchable`, serta sealed class `ItemStatus`. Membuat kerangka kelas. Membuat custom exception, exception handling, dan `main()` program. |
| **Ajeng Az Zahra** | 225443002 | Implementator Buku & Majalah | Implementasi `Book` dan `Magazine`. |
| **Shiva Nayla** | 225443053 | Implementator DVD & Manager | Implementasi `DVD` dan `LibraryManager` (Repository, operasi pinjam/cari). |
