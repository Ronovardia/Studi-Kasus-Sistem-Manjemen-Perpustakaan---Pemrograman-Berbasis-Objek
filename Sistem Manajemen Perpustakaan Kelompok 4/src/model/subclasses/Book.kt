class Book(
    id: String,
    title: String,
    year: Int,
    val author: String,
    val pages: Int
) : LibraryItem(id, title, year), Borrowable, Searchable {

    // Awalnya setiap buku berstatus Tersedia
    override var status: ItemStatus = ItemStatus.Available

    override fun getDetails(): String = "Buku oleh $author, $pages halaman"

    // ----- dari Borrowable -----
    override fun borrow(memberId: String, date: String): Boolean {
        when (val current = status) {
            is ItemStatus.Borrowed ->
                throw ItemAlreadyBorrowedException(title, current.by)
            ItemStatus.Lost ->
                throw IllegalStateException("'$title' berstatus hilang, tidak bisa dipinjam")
            ItemStatus.Available ->
                status = ItemStatus.Borrowed(memberId, date)
        }
        return true
    }

    override fun returnItem(): Boolean {
        if (status !is ItemStatus.Borrowed) {
            throw ItemNotBorrowedException(title)
        }
        status = ItemStatus.Available
        return true
    }

    override fun isAvailable(): Boolean = status is ItemStatus.Available

    override fun getBorrower(): String? = (status as? ItemStatus.Borrowed)?.by

    // ----- dari Searchable -----
    // Buku bisa dicari lewat judul ATAU penulis (huruf besar/kecil diabaikan)
    override fun matches(query: String): Boolean =
        title.contains(query, ignoreCase = true) ||
                author.contains(query, ignoreCase = true)
}