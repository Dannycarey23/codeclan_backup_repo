class Person:
    def __init__(self, name, age, cash, boarding_pass):
        self.name = name
        self.age = age
        self.cash = cash
        self.boarding_pass = boarding_pass
        
    def reduce_cash(self, amount):
        self.cash -= amount
        
    
    