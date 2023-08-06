import unittest
from src.customer import Customer
from src.drink import Drink
from src.food import Food

class TestCustomer(unittest.TestCase):
    
    def setUp(self):
        
        self.drink = Drink("latte", 2.00, 5)
        self.food = Food("Burger", 4.99, 3)
        self.customer = Customer("Frodo", 10.00, 28, 0)
        self.customer_2 = Customer("Sam", 10.00, 27, 5)
        
        
    def test_customer_has_name(self):
        self.assertEqual("Frodo", self.customer.name)
        
        
    def test_customer_has_wallet(self):
        self.assertEqual(10.00, self.customer.wallet)
        
    
    def test_customer_has_energy(self):
        self.assertEqual(0, self.customer.energy)
    
    
    def test_customer_has_age(self):
        self.assertEqual(28, self.customer.age)
    
    
    def test_sufficient_funds__true_if_enough(self):
        self.assertEqual(True, self.customer.sufficient_funds(self.drink))
    
    
    def test_sufficient_funds__false_if_not_enough(self):
        poor_customer = Customer("Alex", 1.00, 64, 0)
        self.assertEqual(False, poor_customer.sufficient_funds(self.drink))
    
    
    def test_customer_can_buy_drink__decreases_money(self): 
        self.customer.buy_drink(self.drink)
        self.assertEqual(8.00, self.customer.wallet)
    
    
    def test_customer_can_buy_drink__increases_energy(self): 
        self.customer.buy_drink(self.drink)
        self.assertEqual(5, self.customer.energy)
    
    
    def test_customer_cannot_buy_if_insufficient_funds(self):
        poor_customer = Customer("Alex", 1.00, 64, 0)
        poor_customer.buy_drink(self.drink)
        self.assertEqual(1.00, poor_customer.wallet)
        self.assertEqual(0, poor_customer.energy)
        
    
    def test_customer_can_buy_food__decreases_money(self): 
        self.customer_2.buy_food(self.food)
        self.assertEqual(5.01, self.customer_2.wallet)
        
        
    def test_customer_can_buy_drink__decreases_energy(self): 
        self.customer_2.buy_food(self.food)
        self.assertEqual(2, self.customer_2.energy)
    
    
    def test_sufficient_food_funds__true_if_enough(self):
        self.assertEqual(True, self.customer.sufficient_funds(self.food))
    
    
    def test_sufficient_food_funds__false_if_not_enough(self):
        poor_customer = Customer("Alex", 1.00, 64, 0)
        self.assertEqual(False, poor_customer.sufficient_funds(self.food))
    