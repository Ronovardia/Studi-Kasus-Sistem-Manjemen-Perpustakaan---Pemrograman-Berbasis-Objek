class DVD(
    id: String,
    title: String,
    year: Int,
    val duration: Int,
    val genre: String
) : LibraryItem(id, title, year), Borrowable, Searchable {

    override var status: ItemStatus = ItemStatus.Available

    override fun getDetails(): String = "DVD, $duration menit, genre: $genre"

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

    override fun matches(query: String): Boolean =
        title.contains(query, ignoreCase = true) ||
                genre.contains(query, ignoreCase = true)
}