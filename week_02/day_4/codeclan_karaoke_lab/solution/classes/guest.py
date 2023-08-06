class Guest:
    def __init__(self, name, cash, song):
        self.name = name
        self.cash = cash
        self.favourite_song = song

    def can_afford(self, amount):
        return self.cash >= amount

    def pay(self, amount):
        self.cash -= amount

    def cheer(self, songs):
        for song in songs:
            if song.equals(self.favourite_song):
                return "Whoo Hoo!"
        return None
