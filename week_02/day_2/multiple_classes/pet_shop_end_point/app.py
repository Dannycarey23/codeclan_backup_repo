from pet import Pet
from pet_shop import PetShop

monty = Pet("Monty", "Snake", "Python", 500)
charles = Pet("Charles", "Dog", "Spaniel", 250)
mrs_norris = Pet("Mrs. Norris", "Cat", "Maine Coon", 100)
pets = [monty, charles, mrs_norris]

cc_pet_shop = PetShop("CodeClan Pet Shop", pets, 0)

stock_count = cc_pet_shop.stock_count()
print(f"{cc_pet_shop.name} has {stock_count} pets in stock")

print(f"{cc_pet_shop.name} started with £{cc_pet_shop.total_cash}")
print("Increasing total cash by 100")
cc_pet_shop.increase_total_cash(100)
print(f"{cc_pet_shop.name} now has £{cc_pet_shop.total_cash}")


print(f"Removing {monty.name} from {cc_pet_shop.name}...")
cc_pet_shop.remove_pet(monty)
print(f"{cc_pet_shop.name} has {cc_pet_shop.stock_count} pets in stock")

print("Searching for a pet with the name Charles...")
found_pet = cc_pet_shop.find_pet_by_name("Charles")
print(found_pet.__dict__)

print(f"{cc_pet_shop.name} has sold {cc_pet_shop.pets_sold} pets")
print(f"Increasing pets sold...")
cc_pet_shop.increase_pets_sold()
print(f"{cc_pet_shop.name} has now sold {cc_pet_shop.pets_sold} pets")

cc_pet_shop.sell_pet("Charles")
print(f"{cc_pet_shop.name} sold {charles.name}")
print(f"{cc_pet_shop.__dict__}")
