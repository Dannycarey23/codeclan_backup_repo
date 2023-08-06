# Vending Machine Lab

In this exercise you will build the brains of a vending machine.  It will accept money, make change, maintain
inventory, and dispense products.  All the things that you might expect a vending machine to accomplish.

The point of this is to practice the concepts you have learned so far and can be used to practice TDD.

### MVP

* The vending machine will accept valid coins (10p, 20p, 50p, etc) and reject invalid ones (1p, 2p).

* When a valid coin is inserted the amount of the coin will be added to the current amount. Rejected coins are returned.

* There are three products: cola for £1.00, crisps for £0.50, and sweet for £0.65.  When the respective code is entered
and enough money has been inserted, the product is returned and the current amount will be set to £0.00.  If there is not enough money inserted then the machine returns the amount still required.

### Tasks

1. Create a CoinType enum with each coin type and associated value.
2. Create a coin class with a CoinType property.
3. Write a method to get the value of the coin.
4. Create a Product abstract class which has name and brand.
5. Create classes for Sweet, Crisp, Drink which extend product.
6. Create a Drawer class with a Enum code (A1, B1, ETC), price and a list of Products. (One product type per drawer but could swap out for any other product)
7. Add methods to add a product to drawer and return product from drawer.
8. Create a CoinReturn class (Where rejected coins or change is returned to) with a list of coins.
9. Write a method to get the total amount in the Coin Return.
10. Write a method to add a coin to the Coin return.
11. Create a Vending Machine class with a list of drawers, list of coins entered and coin return.
12. Write a method to add a coin to the machine.
13. Write a method to check if coin is valid.
14. Amend addCoin method to check if coin is valid and if not add the coin to the coin return.
15. Write a method to buy product taking in a code. If there is enough money to buy selected product.
16. If there is enough money then the vend method is called and will return the product and set the credit to 0.00.


#### Extensions

* When a product is selected that costs less than the amount of money in the machine, then the correct change is placed
in the coin return.

* When the return coins button is pressed, the money the customer has placed in the machine is returned into the coin return.

##### Tasks

1. Write a method in vending machine that checks credit and cost of selected product and returns any change to the coin return.

2. Write a method to transfer the coins totalling from the machine to the coin return.

#### Advanced Extensions

* When the machine is not able to make change with the money in the machine for any of the items that it sells, it will
only accept exact change.

##### Tasks

1. Add a correctChange property to the machine (boolean)
2. Write a method to set the correctChange boolean property to true.
3. Change vend method to check if the correct change is true then product only vends if exact amount inserted otherwise it will return the coins.
