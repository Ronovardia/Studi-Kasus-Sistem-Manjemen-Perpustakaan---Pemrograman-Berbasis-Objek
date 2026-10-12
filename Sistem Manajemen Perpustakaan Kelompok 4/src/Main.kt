fun printList(items: List<LibraryItem>) {
    if (items.isEmpty()) {
        println("(kosong)")
    } else {
        items.forEach { println("[${it.id}] ${it.title} (${it.year}) - ${it.status.display()}") }
    }
}

fun main() {

    println("==========================================")
    println("            STUDI KASUS INDIVIDU          ")
    println("==========================================")

    val company = Company("PT Maju Jaya")
    company.addEmployee(FullTimeEmployee("P001", "Budi", 5_000_000.0, 1_500_000.0, 6_000_000.0))
    company.addEmployee(ContractEmployee("P002", "Siti", 4_500_000.0, 12))
    company.addEmployee(Intern("P003", "Ahmad", 2_000_000.0))

    company.displayAllEmployees()
    println("Total Gaji: Rp ${company.getTotalSalary()}")
    println("Total Pajak: Rp ${company.getTotalTax()}")
    println("Total Bonus: Rp ${company.getTotalBonus()}")

    println()
    println("==========================================")
    println("            STUDI KASUS KELOMPOK          ")
    println("       SISTEM MANAJEMEN PERPUSTAKAAN      ")
    println("==========================================")
    println("")

    // --- Tambah item ke koleksi ---
    LibraryManager.addItem(Book("P001", "Pemrograman Kotlin", 2023, "Budi Santoso", 350))
    LibraryManager.addItem(Book("P002", "Dasar-Dasar OOP", 2022, "Siti Rahayu", 280))
    LibraryManager.addItem(Magazine("M001", "Tech Today", 2024, 42, "Tech Media"))
    LibraryManager.addItem(DVD("D001", "Film Dokumenter", 2021, 120, "Dokumenter"))

    LibraryManager.displayAllItems()

    // --- Pinjam ---
    println("\n--- Meminjam buku P001 oleh M001 ---")
    LibraryManager.borrowItem("P001", "M001", "2025-01-15")

    // --- Cari ---
    println("\n--- Mencari 'Kotlin' ---")
    printList(LibraryManager.findByTitle("Kotlin"))

    // --- Daftar dipinjam ---
    println("\n--- Item Dipinjam ---")
    printList(LibraryManager.getBorrowedItems())

    // --- Kembalikan ---
    println("\n--- Mengembalikan buku P001 ---")
    LibraryManager.returnItem("P001")

    // --- Daftar tersedia ---
    println("\n--- Item Tersedia ---")
    printList(LibraryManager.getAvailableItems())

    // --- Uji skenario error ---
    println("\n=== UJI SKENARIO ERROR ===")

    println("\n1) Pinjam item yang tidak ada:")
    LibraryManager.borrowItem("X999", "M001", "2025-01-16")

    println("\n2) Pinjam item yang sudah dipinjam:")
    LibraryManager.borrowItem("P002", "M001", "2025-01-16")
    LibraryManager.borrowItem("P002", "M002", "2025-01-17")

    println("\n3) Kembalikan item yang tidak sedang dipinjam:")
    LibraryManager.returnItem("D001")

    println("\n4) Pinjam majalah (tidak bisa dipinjam):")
    LibraryManager.borrowItem("M001", "M001", "2025-01-18")
}