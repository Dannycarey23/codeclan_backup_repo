# Additional Multiple Classes Lab

Your task is to model an airport with a departure lounge and an plane or planes.

Create an app.py in which you can create instances of your classes and test their properties and functionality.

## Part A

### Step 1

- Create a Person class.
- The Person class should have attributes of name and age.

### Step 2

- Create a plane class.
- The plane class should have a type, flight number, capacity and a list of passengers
- The plane should be able to add a passenger, remove a passenger and clear all passengers.
- The plane should check that the capacity has not been exceeded prior to adding a passenger.

## Part B

- Create an airport class
- The airport should have a name.
- The airport should have a departure lounge property which will be a list of passengers.
- The airport should be able to transfer passengers from the departure lounge to the plane.

## Extensions / Suggestions

- Give the Passenger class a boarding pass property, the value of which will be a flight number. Ensure that passengers have the correct boarding pass when boarding a flight.
- Give the passenger a cash property. Give the airport a horribly overpriced shop from which the passenger is forced to buy huge packets of M&Ms.
E.G.
self.shop = {
    "M&Ms": 5.00,
    "Shitty headphones": 400.00,
    "Mechanically reclaimed floor sweepings sandwich": 150.00,
    "Copy of Roger's Profanisaurus": 20.00
}

