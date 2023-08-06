import unittest
from src.food import Food

class TestFood(unittest.TestCase):
    
    def setUp(self):
        self.food = Food("Burger", 4.99, 3)
        
    
    def test_has_name(self):
        self.assertEqual("Burger", self.food.name)
        
        
    def test_has_price(self):
        self.assertEqual(4.99, self.food.price)
        
        
    def test_has_digestion_level(self):
        self.assertEqual(3, self.food.digestion_level)