
from person import Person
from airport import Airport
from plane import Plane

# Create passengers
passenger_1 = Person("D.B. Cooper", 40, 100, "SUX900")
passenger_2 = Person("D.B. Cooper Jnr", 40, 100, "SUX900")
passenger_3 = Person("D.B. Cooper Snr", 40, 100, "SUX900")
passenger_4 = Person("D.B. Cooper The Third", 40, 100, "JSX800")

# Create airport
airport_1 = Airport("Glasgow")

# Create plane
plane_1 = Plane("Commercial", "SUX900", 40)


# Add passengers to airport
airport_1.add_passenger(passenger_1)
airport_1.add_passenger(passenger_2)
airport_1.add_passenger(passenger_3)
airport_1.add_passenger(passenger_4)

print(f"{airport_1.name} airport has {len(airport_1.passenger_lounge)} passengers in the departure lounge")

# Board passengers to plane
# Note: Only 3 should board as one has the incorrect boarding card

airport_1.embark_passengers(plane_1)
print("passengers embarking........")

print(f"{airport_1.name} airport now has {len(airport_1.passenger_lounge)} passengers in the departure lounge")
print(f"Plane_1 has {len(plane_1.passengers)} on board")

# Passenger buys item
airport_1.sell_item(passenger_1, "Shitty headphones")
print(f"{passenger_1.name} now has {passenger_1.cash} and one pair of shitty headphones")



