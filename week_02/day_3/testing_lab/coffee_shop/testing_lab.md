# Lab - Coffee Shop

## Task

The task for this lab is to plan and create an object oriented model of a Coffe Shop, with Drinks and Customers! You should write tests for all your classes and methods. Make sure that you create a separate file for each class and a separate test file for each class.

## Learning Objectives

1. Create your own classes
2. Create multiple objects
3. Add some properties
4. Add some methods and behaviours
5. Get methods and behaviours to interact with properties
6. Get classes to interact with each other
7. Test classes and methods

MVP:

  - A `Drink` should have a `name`, and a `price`
  - A `Coffee Shop` should have a `name`, a `till`, and a collection of `drinks` containing instances of class `Drink` (Mocha, Latte, Hot Chocolate, Tea etc)
  - A `Customer` should have a `name`, and a `wallet`
  - A `Customer` should have method which reduces the wallet by a specified amount as a parameter
  - A `Customer` should be able to buy a `Drink` and reduce their wallet by the `Drink`'s price.
  - A `Coffee Shop` should be able to sell a drink to a customer and increase it's `till` by the price of `Drink`. Hint: Use a `Customer` method you already have.



Extensions:

  - Most coffee shops won't serve coffee to anyone under 16. Add an `age` to the `Customer`. Make sure the `Coffee Shop` checks the `age` before serving the `Customer`.
  - Add `caffeine_level` to the Drink, and a `energy` level to the `Customer`. Every time a `Customer` buys a drink, the `energy` level should go up by the `caffeine_level`.
  - `Coffee Shop` should refuse service to a `Customer` with an `energy` above a certain amount!
  

Advanced extensions:

  - Create a `Food` class, that has a `name`, `price` and `digestion_level`. Each time a `Customer` buys `Food`, their `energy` should go down by the `digestion_level`
  - Coffee Shop can have a `stock` (maybe a Dictionary?) to keep track the amount of `drinks` available (Hard! Might need to change the drinks List to a drinks Dictionary)
  - Coffee Shop can have a `stock_value` method to check the total value of its `drinks`

### Files and Directories

  - In your working directory, create two directories, one for your classes and one for your tests
  - create a `run_tests.py` file in your working directory. Use this file to run your tests.
  - If a method returns a boolean i.e. `True` or `False` then create _at least_ two tests for the method, one where you expect the result to be `True`, and one where you expect the result to be `False`

**REMEMBER** to commit to git regularly