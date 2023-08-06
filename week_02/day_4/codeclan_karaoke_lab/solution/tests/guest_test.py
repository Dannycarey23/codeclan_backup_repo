import unittest

from classes.guest import Guest
from classes.song import Song

class TestGuest(unittest.TestCase):

    def setUp(self):
        self.song_1 = Song("Highway to Hell", "AC/DC")
        self.song_2 = Song("The Clansman", "Iron Maiden")
        self.song_3 = Song("Ace of Spades", "Motorhead")

        self.songs = [self.song_1, self.song_2, self.song_3]

        song = Song("Ace of Spades", "Motorhead")
        self.guest = Guest("Jack", 20, song)

    def test_guest_has_name(self):
        self.assertEqual("Jack", self.guest.name)

    def test_guest_has_cash(self):
        self.assertEqual(20, self.guest.cash)

    def test_guest_has_favourite_song(self):
        self.assertEqual("Ace of Spades", self.guest.favourite_song.title)

    def test_guest_can_change_favourite_song(self):
        song = Song("The Clansman", "Iron Maiden")
        self.guest.favourite_song = song
        self.assertEqual("The Clansman", self.guest.favourite_song.title)

    def test_guest_can_afford_10(self):
        self.assertEqual(True, self.guest.can_afford(10))

    def test_guest_can_afford_20(self):
        self.assertEqual(True, self.guest.can_afford(20))

    def test_guest_cannot_afford_30(self):
        self.assertEqual(False, self.guest.can_afford(30))

    def test_guest_can_pay_amount(self):
        self.guest.pay(10)
        self.assertEqual(10, self.guest.cash)

    def test_guest_cheers_when_fave_song_in_list(self):
        result = self.guest.cheer(self.songs)
        self.assertEqual("Whoo Hoo!", result)

    def test_guest_does_not_cheer_when_fave_song_not_in_list(self):
        song = Song("Back in Black", "AC/DC")
        guest = Guest("Tam", 2, song)
        self.assertEqual(None, guest.cheer(self.songs))

if __name__ == '__main__':
    unittest.main()
