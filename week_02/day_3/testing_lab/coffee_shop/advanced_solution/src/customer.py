class Customer:
    
    def __init__(self, name, wallet, age, energy):
        self.name = name
        self.wallet = wallet
        self.age = age
        self.energy = energy
        
    
    def buy_drink(self, drink):
        if self.sufficient_funds(drink):
            self.wallet -= drink.price
            self.energy += drink.caffeine_level
    
    
    def buy_food(self, food):
        if self.sufficient_funds(food):
            self.wallet -= food.price
            self.energy -= food.digestion_level
    
    def sufficient_funds(self, item):
        return self.wallet >= item.price