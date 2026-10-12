sealed class ItemStatus {
    object Available : ItemStatus()                                   // tidak butuh data tambahan
    data class Borrowed(val by: String, val date: String) : ItemStatus() // butuh: siapa & tanggal
    object Lost : ItemStatus()

    // Mengubah status jadi teks yang enak dibaca
    fun display(): String = when (this) {
        Available -> "Tersedia"
        is Borrowed -> "Dipinjam oleh $by pada $date"
        Lost -> "Hilang"
    }
}