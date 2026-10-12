class ItemNotFoundException(itemId: String) :
    Exception("Item dengan ID '$itemId' tidak ditemukan")

class ItemAlreadyBorrowedException(title: String, borrower: String) :
    Exception("'$title' sudah dipinjam oleh $borrower")

class ItemNotBorrowedException(title: String) :
    Exception("'$title' sedang tidak dipinjam, jadi tidak bisa dikembalikan")
