import pdb
from models.book import Book
from models.author import Author

import repositories.book_repository as book_repository
import repositories.author_repository as author_repository

book_repository.delete_all()
author_repository.delete_all()

author1 = Author("Terry", "Pratchett")
author_repository.save(author1)
author2 = Author("David", "Ascher")
author_repository.save(author2)


book_1 = Book("Colour of Magic", "Fantasy", "Colin Smythe", author1)
book_repository.save(book_1)

book_2 = Book("The Light Fantastic", "Fantasy", "Colin Smythe", author1)
book_repository.save(book_2)

book_3 = Book("Learning Python", "Education", "O' Reilly", author2)
book_repository.save(book_3)