# Vending Machine Lab

In this exercise you will build the brains of a vending machine.  It will accept money, make change, maintain
inventory, and dispense products.  All the things that you might expect a vending machine to accomplish.

The point of this is to practice the concepts you have learned so far and can be used to practice TDD.

### MVP

* The vending machine will accept valid coins (10p, 20p, 50p, etc) and reject invalid ones (1p, 2p).

* When a valid coin is inserted the amount of the coin will be added to the current amount. Rejected coins are returned.

* There are three products: cola for £1.00, crisps for £0.50, and sweet for £0.65.  When the respective code is entered
and enough money has been inserted, the product is returned and the current amount will be set to £0.00.  If there is not enough money inserted then the machine returns the amount still required.

#### Extensions

* When a product is selected that costs less than the amount of money in the machine, then the correct change is placed
in the coin return.

* When the return coins button is pressed, the money the customer has placed in the machine is returned into the coin return.

##### Advanced Extensions

* When the machine is not able to make change with the money in the machine for any of the items that it sells, it will
only accept exact change.
