class Room:
    def __init__(self, name, capacity, fee):
        self.name = name
        self.guests = []
        self.songs = []
        self._capacity = capacity
        self.till = 0
        self.fee = fee

    def number_of_guests(self):
        return len(self.guests)

    def number_of_songs(self):
        return len(self.songs)

    def get_capacity(self):
        return self._capacity

    def check_in_guest(self, guest):
        if self.free_spaces() > 0 and guest.can_afford(self.fee):
           guest.pay(self.fee)
           self.till += self.fee
           self.guests.append(guest)

    def check_in_guests(self, guests):
        if self.free_spaces() >= len(guests):
            for guest in guests:
                self.check_in_guest(guest)

    def check_out_guest(self, guest):
        self.guests.remove(guest)

    def add_song(self, song):
        self.songs.append(song)

    def add_songs(self, songs):
        for song in songs:
            self.songs.append(song)

    def free_spaces(self):
        return self._capacity - len(self.guests)

    def add_to_till(self, amount):
        self.till += amount
