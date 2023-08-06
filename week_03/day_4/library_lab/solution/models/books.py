from models.book import Book

book_1 = Book("The Lord of the Rings", "J R R Tolkien", "fantasy", True)
book_2 = Book("The Hobbit", "J R R Tolkien", "fantasy", False)
book_3 = Book("Clean Clode", "Robert Martin", "software development", True)
books = [book_1, book_2, book_3]


def add_book(book):
    books.append(book)


def delete_book(index):
    books.pop(index)
