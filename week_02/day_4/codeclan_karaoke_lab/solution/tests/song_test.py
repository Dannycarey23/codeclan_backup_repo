import unittest

from classes.song import Song

class TestSong(unittest.TestCase):

    def setUp(self):
        self.song = Song("Highway To Hell", "AC/DC")

    def test_song_has_title(self):
        self.assertEqual("Highway To Hell", self.song.title)

    def test_song_has_artist(self):
        song = Song("Highway To Hell", "AC/DC")
        self.assertEqual("AC/DC", self.song.artist)

    def test_equals_returns_true(self):
        song = Song("Highway To Hell", "AC/DC")
        result = self.song.equals(song)
        self.assertEqual(True, result)

    def test_equals_title_different_returns_false(self):
        song = Song("Back in Black", "AC/DC")
        result = self.song.equals(song)
        self.assertEqual(False, result)

    def test_equals_artist_different_returns_false(self):
        song = Song("Highway To Hell", "Iron Maiden")
        result = self.song.equals(song)
        self.assertEqual(False, result)

    def test_equals_song_different_returns_false(self):
        song = Song("Ace of Spades", "Iron Maiden")
        result = self.song.equals(song)
        self.assertEqual(False, result)

if __name__ == '__main__':
    unittest.main()
