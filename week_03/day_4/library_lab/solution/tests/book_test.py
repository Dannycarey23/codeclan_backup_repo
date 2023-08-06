import unittest
from models.book import Book
import datetime


class TestBook(unittest.TestCase):
    def setUp(self):
        self.book = Book("The Lord of the Rings", "J R R Tolkien", "fantasy", True)

    def test_book_has_title(self):
        self.assertEqual("The Lord of the Rings", self.book.title)

    def test_book_has_author(self):
        self.assertEqual("J R R Tolkien", self.book.author)

    def test_book_has_genre(self):
        self.assertEqual("fantasy", self.book.genre)

    def test_book_checked_out(self):
        self.assertTrue(self.book.checked_out)
