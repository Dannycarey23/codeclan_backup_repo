import unittest
from src.customer import Customer
from src.drink import Drink
from src.coffee_shop import CoffeeShop

class TestShop(unittest.TestCase):
    
    def setUp(self):
        self.drink_1 = Drink("mocha", 2.00)
        self.drink_2 = Drink("latte", 3.00)
        self.drink_3 = Drink("esspresso", 4.00)
        self.shop = CoffeeShop("CC-Coffee", 100.00)
        self.customer = Customer("Frodo", 10.00)
        
    
    def test_shop_has_name(self):
        self.assertEqual("CC-Coffee", self.shop.name)
    
    
    def test_shop_has_till(self):
        self.assertEqual(100.00, self.shop.till)
        
    
    def test_shop_can_add_drinks(self):
        self.shop.add_drink(self.drink_1)
        self.assertEqual(1, self.shop.drink_count())
    
    
    def test_shop_can_serve_drink(self):
        self.shop.add_drink(self.drink_1)
        self.shop.add_drink(self.drink_2)
        self.shop.serve(self.customer, self.drink_1)
        self.assertEqual(8.00, self.customer.wallet)
        self.assertEqual(102.00, self.shop.till)
        self.assertEqual(1, self.shop.drink_count())
    
    
    def test_shop_cannot_serve_unstocked_drink(self):
        self.shop.add_drink(self.drink_1)
        self.shop.serve(self.customer, self.drink_2)
        self.assertEqual(10.00, self.customer.wallet)
        self.assertEqual(100.00, self.shop.till)
        self.assertEqual(1, self.shop.drink_count())
    
    
    def test_shop_does_not_serve_too_many_drinks(self):
        self.shop.add_drink(self.drink_1)
        self.shop.add_drink(self.drink_1)
        self.shop.serve(self.customer, self.drink_1)
        self.assertEqual(1, self.shop.drink_count())
    
    
        