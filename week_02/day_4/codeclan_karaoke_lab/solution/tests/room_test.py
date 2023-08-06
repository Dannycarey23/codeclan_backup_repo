import unittest

from classes.room import Room
from classes.guest import Guest
from classes.song import Song

class TestRoom(unittest.TestCase):

    def setUp(self):
        self.song_1 = Song("Highway to Hell", "AC/DC")
        self.song_2 = Song("The Clansman", "Iron Maiden")
        self.song_3 = Song("Ace of Spades", "Motorhead")

        self.songs = [self.song_1, self.song_2, self.song_3]

        self.jack = Guest("Jack", 20, self.song_1)
        self.victor = Guest("Victor", 15, self.song_2)
        self.isa = Guest("Isa", 100, self.song_3)

        self.guests = [self.jack, self.victor, self.isa]

        self.winston = Guest("Winston", 10, self.song_2)
        self.room = Room("The Metal Room", 3, 10)

    def test_room_has_name(self):
        self.assertEqual("The Metal Room", self.room.name)

    def test_room_has_no_guests_at_start(self):
        self.assertEqual(0, self.room.number_of_guests())

    def test_room_has_no_songs_at_start(self):
        self.assertEqual(0, self.room.number_of_songs())

    def test_room_has_capacity(self):
        self.assertEqual(3, self.room.get_capacity())

    def test_room_till_starts_empty(self):
        self.assertEqual(0, self.room.till)

    def test_can_add_to_till(self):
        self.room.add_to_till(10)
        self.assertEqual(10, self.room.till)

    def test_can_check_in_guest(self):
        self.room.check_in_guest(self.victor)
        self.assertEqual(1, self.room.number_of_guests())

    def test_can_check_in_multiple_guests(self):
        self.room.check_in_guests(self.guests)
        self.assertEqual(3, self.room.number_of_guests())

    def test_can_check_guest_out(self):
        self.room.check_in_guest(self.victor)
        self.room.check_out_guest(self.victor)
        self.assertEqual(0, self.room.number_of_guests())

    def test_can_add_song_to_room(self):
        song = Song("The Number of the Beast", "Iron Maiden")
        self.room.add_song(song)
        self.assertEqual(1, self.room.number_of_songs())

    def test_can_add_multiple_songs_to_room(self):
        self.room.add_songs(self.songs)
        self.assertEqual(3, self.room.number_of_songs())

    def test_room_has_free_spaces_equal_to_capacity_at_start(self):
        self.assertEqual(3, self.room.free_spaces())

    def test_free_spaces_goes_down_when_guest_checked_in(self):
        self.room.check_in_guest(self.victor)
        self.assertEqual(2, self.room.free_spaces())

    def test_cannot_check_in_guest_if_room_is_full(self):
        self.room.check_in_guests(self.guests)
        self.room.check_in_guest(self.winston)
        self.assertEqual(3, self.room.number_of_guests())

    def test_cannot_check_in_multiple_guest_if_not_enough_free_space(self):
        self.room.check_in_guest(self.winston)
        self.room.check_in_guests(self.guests)
        self.assertEqual(1, self.room.number_of_guests())

    def test_room_has_fee(self):
        self.assertEqual(10, self.room.fee)

    def test_can_check_guest_if_cannot_afford_it(self):
        self.room.check_in_guest(self.winston)
        self.assertEqual(1, self.room.number_of_guests())
        self.assertEqual(10, self.room.till)
        self.assertEqual(0, self.winston.cash)

    def test_cannot_check_guest_in_if_cannot_afford_it(self):
        tam = Guest("Tam", 2, self.song_1)
        self.room.check_in_guest(tam)

        self.assertEqual(0, self.room.number_of_guests())
        self.assertEqual(0, self.room.till)
        self.assertEqual(2, tam.cash)

    def test_cheers_for_guests_fave_song(self):
        self.room.check_in_guest(self.winston)
        songs = self.songs
        self.assertEqual("Whoo Hoo!", self.room.guests[0].cheer(songs))


if __name__ == '__main__':
    unittest.main()
