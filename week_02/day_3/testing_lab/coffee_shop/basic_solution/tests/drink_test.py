import unittest
from src.drink import Drink

class TestDrink(unittest.TestCase):
    
    def setUp(self):
        self.drink = Drink("mocha", 4.00)
        
    
    def test_drink_has_name(self):
        self.assertEqual("mocha", self.drink.name)
                        
                        
    def test_drink_has_price(self):
        self.assertEqual(4.00, self.drink.price)                
