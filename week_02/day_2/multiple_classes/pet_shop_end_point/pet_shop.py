class PetShop:
    def __init__(self, name, pets, total_cash):
        self.name = name
        self.pets = pets
        self.total_cash = total_cash
        self.pets_sold = 0

    def stock_count(self):
        return len(self.pets)

    def increase_total_cash(self, amount):
        self.total_cash += amount

    def remove_pet(self, pet):
        self.pets.remove(pet)

    def find_pet_by_name(self, name):
        for pet in self.pets:
            if pet.name == name:
                return pet

    def increase_pets_sold(self):
        self.pets_sold += 1

    def sell_pet(self, name):
        pet = self.find_pet_by_name(name)
        self.increase_total_cash(pet.price)
        self.increase_pets_sold()
        self.remove_pet(pet)
