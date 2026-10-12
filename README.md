### “SISTEM MANAJEMEN PERPUSTAKAAN”

#### Latar Belakang
Perpustakaan kampus memiliki koleksi:
- **Buku** – bisa dipinjam, bisa dicari berdasarkan judul/penulis.
- **DVD** – bisa dipinjam, bisa dicari.

Setiap item memiliki ID, judul, tahun. Status item: Tersedia, Dipinjam (oleh siapa, tanggal), atau Hilang.

Sistem harus mampu:
- Menambah item ke koleksi.
- Mencari item berdasarkan kata kunci.
- Meminjam dan mengembalikan item yang borrowable.
- Menampilkan daftar item tersedia dan dipinjam.
- Menangani error (item tidak ditemukan, sudah dipinjam, dll).

#### Tujuan Pembelajaran
- Merancang **abstract class** dan **interface** secara kolaboratif.
- Menerapkan **multiple interface** pada kelas yang berbeda.
- Menggunakan **sealed class** untuk status item.
- Menerapkan **generic** (Repository) dan **collection**.
- Menerapkan **exception handling**.
- Melatih **kolaborasi** dan **integrasi kode**.


### Struktur File yang Disarankan
```
src/
├── Main.kt
├── model/
│   ├── Employee.kt (individu)
│   ├── LibraryItem.kt (kelompok)
│   ├── interfaces/
│   │   ├── Taxable.kt
│   │   ├── BonusEligible.kt
│   │   ├── Borrowable.kt
│   │   └── Searchable.kt
│   ├── status/
│   │   ├── EmployeeStatus.kt
│   │   └── ItemStatus.kt
│   ├── subclasses/
│   │   ├── FullTimeEmployee.kt
│   │   ├── ContractEmployee.kt
│   │   ├── Intern.kt
│   │   ├── Book.kt
│   │   ├── Magazine.kt
│   │   └── DVD.kt
│   └── manager/
│       ├── Company.kt
│       └── LibraryManager.kt
└── exception/
    └── CustomExceptions.kt
```

#### Pembagian Tugas Kelompok 
| Nama | NIM | Tugas | Deskripsi |
|-------|-------|-------|-------|
| **Renisa Rahmawati** | 225443025 | **Arsitek dan Integrator & Exception** | Mendesain abstract class `LibraryItem`, interface `Borrowable`, `Searchable`, sealed class `ItemStatus`. Membuat kerangka kelas. Membuat custom exception, exception handling, dan `main()` program. |
| **Ajeng Az Zahra** | 225443002 | **Implementator Buku & Majalah** | Implementasi `Book` dan `Magazine`. |
| **Shiva Nayla** | 225443053 | **Implementator DVD & Manager** | Implementasi `DVD` dan `LibraryManager` (Repository, operasi pinjam/cari). |
