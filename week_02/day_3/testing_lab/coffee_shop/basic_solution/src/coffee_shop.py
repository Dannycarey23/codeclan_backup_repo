class CoffeeShop:
    
    def __init__(self, name, till):
        self.name = name
        self.till = till
        self.drinks = []
        
    
    def drink_count(self):
        return len(self.drinks)
    
    
    def add_drink(self, drink):
        self.drinks.append(drink)
    
    
    def serve(self, customer, drink):
        if self.drinks.count(drink) == 0:
            return
        self.drinks.remove(drink)
        customer.buy_drink(drink)
        self.till += drink.price    
        
    
        