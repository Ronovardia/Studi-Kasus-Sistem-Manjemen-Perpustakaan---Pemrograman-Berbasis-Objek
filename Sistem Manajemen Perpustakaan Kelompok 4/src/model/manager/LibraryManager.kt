object LibraryManager {
    private val itemRepo = Repository<LibraryItem>()

    fun addItem(item: LibraryItem) {
        itemRepo.add(item)
    }

    // Fungsi bantu: cari item by ID, kalau tidak ada -> error
    private fun findItemOrThrow(itemId: String): LibraryItem {
        return itemRepo.find { it.id == itemId }
            ?: throw ItemNotFoundException(itemId)
    }

    // Cari berdasarkan kata kunci (hanya item yang Searchable)
    fun findByTitle(query: String): List<LibraryItem> {
        return itemRepo.findAll { it is Searchable && it.matches(query) }
    }

    fun borrowItem(itemId: String, memberId: String, date: String): Boolean {
        val result = runCatching {
            val item = findItemOrThrow(itemId)

            if (item !is Borrowable) {
                throw IllegalArgumentException("'${item.title}' tidak bisa dipinjam")
            }

            item.borrow(memberId, date)
            println("✅ '${item.title}' dipinjam oleh $memberId pada $date")
        }
        result.onFailure { println("❌ Gagal meminjam: ${it.message}") }
        return result.isSuccess
    }

    fun returnItem(itemId: String): Boolean {
        val result = runCatching {
            val item = findItemOrThrow(itemId)

            if (item !is Borrowable) {
                throw IllegalArgumentException("'${item.title}' tidak bisa dipinjam/dikembalikan")
            }

            item.returnItem()
            println("✅ '${item.title}' dikembalikan")
        }
        result.onFailure { println("❌ Gagal mengembalikan: ${it.message}") }
        return result.isSuccess
    }

    fun getAvailableItems(): List<LibraryItem> =
        itemRepo.findAll { it.status is ItemStatus.Available }

    fun getBorrowedItems(): List<LibraryItem> =
        itemRepo.findAll { it.status is ItemStatus.Borrowed }

    fun displayAllItems() {
        itemRepo.getAll().forEach { it.display() }
    }
}