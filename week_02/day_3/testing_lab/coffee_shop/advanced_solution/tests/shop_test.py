import unittest
from src.customer import Customer
from src.drink import Drink
from src.coffee_shop import CoffeeShop

class TestShop(unittest.TestCase):

    def setUp(self):
        self.drink_1 = Drink("mocha", 2.00, 5)
        self.drink_2 = Drink("latte", 3.00, 10)
        self.drink_3 = Drink("espresso", 4.00, 30)

        self.shop = CoffeeShop("CC-Coffee", 100.00)

        self.customer_1 = Customer("Frodo", 10.00, 28, 0)
        self.customer_2 = Customer("Merry", 15.00, 14, 0)
        self.customer_3 = Customer("Pippin", 100.00, 28, 0)


    def test_shop_has_name(self):
        self.assertEqual("CC-Coffee", self.shop.name)


    def test_shop_has_till(self):
        self.assertEqual(100.00, self.shop.till)


    def test_shop_stock_value_starts_at_0(self):
        self.assertEqual(0, self.shop.stock_value())


    def test_stock_level_0_if_drink_not_in_stock(self):
        self.assertEqual(0, self.shop.stock_level(self.drink_3))


    def test_shop_can_add_drink(self):
        self.shop.add_drink(self.drink_1)
        self.assertEqual(1, self.shop.stock_level(self.drink_1))
        self.assertEqual(2.00, self.shop.stock_value())


    def test_shop_has_stock_value(self):
        self.shop.add_drink(self.drink_1)
        self.assertEqual(2.00, self.shop.stock_value())


    def test_shop_can_get_stock_level(self):
        self.shop.add_drink(self.drink_1)
        self.assertEqual(1, self.shop.stock_level(self.drink_1))


    def test_shop_can_add_multiple_of_same_drink(self):
        self.shop.add_drink(self.drink_1)
        self.shop.add_drink(self.drink_1)
        self.assertEqual(2, self.shop.stock_level(self.drink_1))
        self.assertEqual(4.00, self.shop.stock_value())


    def test_shop_cannot_serve_drink(self):
        self.shop.add_drink(self.drink_1)
        self.shop.add_drink(self.drink_2)
        self.shop.serve(self.customer_1, self.drink_1)
        self.assertEqual(8.00, self.customer_1.wallet)
        self.assertEqual(102.00, self.shop.till)
        self.assertEqual(0, self.shop.stock_level(self.drink_1))


    def test_shop_cannot_serve_unstocked_drink(self):
        self.shop.add_drink(self.drink_1)
        self.shop.serve(self.customer_1, self.drink_2)
        self.assertEqual(10.00, self.customer_1.wallet)
        self.assertEqual(100.00, self.shop.till)
        self.assertEqual(1, self.shop.stock_level(self.drink_1))
        self.assertEqual(0, self.shop.stock_level(self.drink_2))


    def test_shop_does_not_serve_too_many_drinks(self):
        self.shop.add_drink(self.drink_1)
        self.shop.add_drink(self.drink_1)
        self.shop.serve(self.customer_1, self.drink_1)
        self.assertEqual(1, self.shop.stock_level(self.drink_1))


    def test_shop_cannot_serve_stock_runs_out(self):
        self.shop.add_drink(self.drink_3)
        self.shop.serve(self.customer_3, self.drink_3)
        self.shop.serve(self.customer_1, self.drink_3)
        self.assertEqual(0, self.shop.stock_level(self.drink_3))
        self.assertEqual(10.00, self.customer_1.wallet)
        self.assertEqual(0, self.customer_1.energy)
        self.assertEqual(104.00, self.shop.till)


    def test_shop_restocking(self):
        self.shop.add_drink(self.drink_1)
        self.shop.add_drink(self.drink_1)
        self.shop.serve(self.customer_1, self.drink_1)
        self.shop.add_drink(self.drink_1)
        self.assertEqual(2, self.shop.stock_level(self.drink_1))


    def test_customer_is_old_enough__returns_true(self):
        self.assertEqual(True, self.shop.customer_is_old_enough(self.customer_1))


    def test_customer_is_old_enough__returns_false(self):
        self.assertEqual(False, self.shop.customer_is_old_enough(self.customer_2))


    def test_customer_too_energetic__returns_false(self):
        self.assertEqual(False, self.shop.customer_too_energetic(self.customer_1))


    def test_customer_too_energetic__returns_true(self):
        energetic_customer = Customer("Keith", 75.00, 64, 50)
        self.assertEqual(True, self.shop.customer_too_energetic(energetic_customer))


    def test_can_serve__customer_old_enough_returns_true(self):
        self.shop.add_drink(self.drink_2)
        self.assertEqual(True, self.shop.can_serve(self.customer_1, self.drink_2) )


    def test_can_serve__customer_not_old_enough_returns_false(self):
        self.shop.add_drink(self.drink_2)
        self.assertEqual(False, self.shop.can_serve(self.customer_2, self.drink_2) )


    def test_can_serve__customer_not_too_energetic_returns_true(self):
        self.shop.add_drink(self.drink_2)
        self.assertEqual(True, self.shop.can_serve(self.customer_3, self.drink_2) )


    def test_can_serve__customer_too_energetic__returns_false(self):
        energetic_customer = Customer("Jack", 75.00, 64, 60)
        self.shop.add_drink(self.drink_2)
        self.assertEqual(False, self.shop.can_serve(energetic_customer, self.drink_2) )


    def test_can_serve__customer_can_afford_drink__returns_true(self):
        self.shop.add_drink(self.drink_2)
        self.assertEqual(True, self.shop.can_serve(self.customer_1, self.drink_2) )


    def test_can_serve__customer_cannot_afford_drink__returns_false(self):
        poor_customer = Customer("Ally", 0.00, 32, 0)
        self.shop.add_drink(self.drink_2)
        self.assertEqual(False, self.shop.can_serve(poor_customer, self.drink_2) )


    def test_can_serve__drink_in_stock__returns_true(self):
        self.shop.add_drink(self.drink_3)
        self.assertEqual(True, self.shop.can_serve(self.customer_3, self.drink_3) )


    def test_can_serve__drink_not_in_stork__returns_false(self):
        self.shop.add_drink(self.drink_2)
        self.assertEqual(False, self.shop.can_serve(self.customer_3, self.drink_3) )


    def test_shop_checks_age__serves_over_16(self):
        self.shop.add_drink(self.drink_2)
        self.shop.serve(self.customer_1, self.drink_2)
        self.assertEqual(7.00, self.customer_1.wallet)
        self.assertEqual(103.00, self.shop.till)


    def test_shop_checks_age__doesnt_serve_underage(self):
        self.shop.add_drink(self.drink_2)
        self.shop.serve(self.customer_2, self.drink_2)
        self.assertEqual(15.00, self.customer_2.wallet)
        self.assertEqual(100.00, self.shop.till)


    def test_shop_doesnt_serve_at_or_above_50_energy(self):
        new_shop = CoffeeShop("Cosbucks", 100.00)
        energetic_customer = Customer("Jarrod", 75.00, 64, 50)
        new_shop.add_drink(self.drink_2)
        new_shop.serve(energetic_customer, self.drink_2)
        self.assertEqual(1, new_shop.stock_level(self.drink_2))
        self.assertEqual(75.00, energetic_customer.wallet)
        self.assertEqual(50, energetic_customer.energy)
        self.assertEqual(100.00, new_shop.till)

    def test_shop_doesnt_serve_if_cannot_afford(self):
        new_shop = CoffeeShop("Cosbucks", 100.00)
        poor_customer = Customer("Ally", 0.00, 32, 0)
        new_shop.add_drink(self.drink_2)
        new_shop.serve(poor_customer, self.drink_2)
        self.assertEqual(1, new_shop.stock_level(self.drink_2))
        self.assertEqual(0, poor_customer.wallet)
        self.assertEqual(0, poor_customer.energy)
        self.assertEqual(100.00, new_shop.till)
