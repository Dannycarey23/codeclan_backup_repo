class Song:
    def __init__(self, title, artist):
        self.title = title
        self.artist = artist

    def equals(self, song):
        return song.title == self.title and song.artist == self.artist
