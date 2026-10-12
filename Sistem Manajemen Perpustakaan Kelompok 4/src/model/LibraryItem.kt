abstract class LibraryItem(
    open val id: String,
    open val title: String,
    open val year: Int
) {
    // abstract = WAJIB diisi oleh class turunan
    abstract var status: ItemStatus
    abstract fun getDetails(): String

    // open = sudah ada isinya, tapi boleh diganti turunan
    open fun display() {
        println("[$id] $title ($year) - ${status.display()}")
        println("   Detail: ${getDetails()}")
    }
}