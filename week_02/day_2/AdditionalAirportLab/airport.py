class Airport:
    
    def __init__(self, name):
        self.name = name
        self.passenger_lounge = []
        self.shop = {
            "M&Ms": 5.00,
            "Shitty headphones": 400.00,
            "Mechanically reclaimed floor sweepings sandwich": 150.00,
            "Copy of Roger's Profanisaurus": 20.00
        }
        
    def add_passenger(self, passenger):
        self.passenger_lounge.append(passenger)
        
    def embark_passengers(self, plane):
        remaining_passengers = []
        for passenger in self.passenger_lounge:
            plane.add_passenger(passenger)
            if passenger.boarding_pass != plane.flight_number:
                remaining_passengers.append(passenger)
        self.passenger_lounge = remaining_passengers
            
    def sell_item(self, customer, item_name):
        customer.reduce_cash(self.shop[item_name])