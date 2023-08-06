import unittest
from src.customer import Customer
from src.drink import Drink

class TestCustomer(unittest.TestCase):
    
    def setUp(self):
        self.customer = Customer("Frodo", 10.00)
        
        
    def test_customer_has_name(self):
        self.assertEqual("Frodo", self.customer.name)
        
        
    def test_customer_has_wallet(self):
        self.assertEqual(10.00, self.customer.wallet)
        
    def test_customer_can_buy_drink(self):
        drink = Drink("mocha", 4.00)
        self.customer.buy_drink(drink)
        self.assertEqual(6.00, self.customer.wallet)