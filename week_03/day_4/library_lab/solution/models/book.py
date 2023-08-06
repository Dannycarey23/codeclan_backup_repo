class Book:
    def __init__(self, title, author, genre, checked_out):
        self.title = title
        self.author = author
        self.genre = genre
        self.checked_out = checked_out

    def toggle_check_out(self, checked_out):
        self.checked_out = checked_out
