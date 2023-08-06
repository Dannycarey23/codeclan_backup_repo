# Testing

**Lesson Duration: 30 minutes**

### Learning Objectives 

* Recap testing
* Know how to set up directories for testing
* Know how to write a test

## Why Should We Test?

When we write our code we want to make sure it works as we expected. Maybe this sounds obvious. So let's make an ever bigger claim. We can craft better code if it's tested.

We haven't really touched on the craft of writing code yet. When we talk about code craft we mean things like the ability to easily make changes to code without
worrying about introducing bugs, as well as the ability for other people to work on our code easily.

Having tests we can run ensures that if we break code by changing it we know instantly.
Therefore the quality of the code is instantly improved, even if the code itself is unchanged. It also means that someone new to our code can look at the tests to very quickly work out how the code works.

There are many approaches to testing our code but the principles are the same.
What we want to do is write code which expects some specific thing to happen.
These "expectations" are referred to as assertions. As our tests run, each assertion
will either pass or fail, and the result will be printed to the terminal.

Most programming languages have test suites and different ways of testing. We will use `unittest`, Python's built-in testing module.

## Unit Testing

Unit testing is a level of software testing where small individual components of code (often a method) are tested.

Our unit tests are written in a separate file to our main code and usually saved in a separate directory.

So let's set up our directory structure for the lab.

## Setting up directories and files

```bash
# Terminal

mkdir coffee_shop_lab
cd coffee_shop_lab
mkdir src
mkdir tests
touch run_tests.py
```

To run our tests we'll run the `run_tests.py` file. But first let's add some code to his file.

```python
# run_tests.py

import unittest


if __name__ == '__main__':
    unittest.main()

```

Now let's say we have a CoffeeShop class that we need to test.

We'll create a file for the class and a file for the test.

```bash
touch src/coffee_shop.py
touch tests/coffee_shop_test.py
```

Let's add some initial boilerplate code to coffee_shop_test.py

```python
# tests/coffee_shop_test.py

import unittest
from src.coffee_shop import CoffeeShop

class TestCoffeeShop(unittest.TestCase):
    pass
```
```python

# src/coffee_shop.py

class CoffeeShop:
	pass
```

And we'll import the `coffee_shop_test.py` file into our `run_tests.py`

```python
# run_tests.py

import unittest
from tests.coffee_shop_test import TestCoffeeShop

if __name__ == '__main__':
    unittest.main()

```

Ok so now we should be good to run our `run_tests.py` file.

```bash
# Terminal

python run_tests.py
```

## Setup method

Remember to use a `setUp` method. For example:

```python
# tests/coffee_shop_test.py

import unittest
from src.coffee_shop import CoffeeShop

class TestCoffeeShop(unittest.TestCase):

    def setUp(self): # NEW
      self.coffee_shop = CoffeeShop("The Prancing Pony", 100.00) # NEW

```

Let's add our first test. We can expect it to fail. Our job then is to get it to pass!

```python
# tests/coffee_shop_test.py

import unittest
from src.coffee_shop import CoffeeShop

class TestCoffeeShop(unittest.TestCase):

    def setUp(self):
      self.coffee_shop = CoffeeShop("The Prancing Pony", 100.00)

    def test_coffee_shop_has_name(self): # NEW
        self.assertEqual("The Prances Pony", self.coffee_shop.name) # NEW
```
```python
# src/coffee_shop.py

class CoffeeShop:
	def __init__(self, name, till):
		self.name = name
		self.till = till

```

Run the tests again!

```bash
# Terminal

python run_tests.py

```

## Testing a method

Next we'll write a test for an `increase_till` method. By convention we should begin the name of our tests with `test_` followed by name of the behaviour that we're testing. We will call this test `test_increase_till`.

```python
# tests/coffee_shop_test.py


    def test_increase_till(self): # NEW
        pass                      # NEW
```
```python
# src/coffee_shop.py

    def increase_till(self, amount):
	self.till += amount

```

Now that we have defined our test and method(behaviour), let's think about how we can test that the `increase_till` method works.

If we were to invoke our `increase_till` method, providing the argument `2.50`. What would we expect to get back? Assuming the method works as expected, we should expect to get `102.50` back. When writing a test we provide a hard-coded "expected" value. The result that we expect to see. We can then call the method and compare our expected value against the value that we actually got back. If the expected value and the actual value are the same, then we can safely assume that our code is working.

`unittest` provides us with a method called `assertEqual`, which does exactly that.

`assertEqual` takes two arguments, the expected value and the actual result, and compares them. If they're the same then the test passes. If they aren't the same then the test will fail and `unittest` will tell us what the expected and actual values were, so that we can begin to debug our code.

```python
# tests/coffee_shop_test.py

class TestCoffeeShop(unittest.TestCase):
    def test_increase_till(self):
        self.coffee_shop.increase_till(2.50)
        self.assertEqual(102.50, self.coffee_shop.till) # NEW
```

The function that we are testing here is very simple. It takes two numbers and adds them together. 

When we're testing more complex functionality, our tests may also become more complex. There are lots of different methodologies that help us structure tests. One of the most important is "the three As of testing".

### The Three As of Testing

The three As of testing are:

1. Arrange
2. Act
3. Assert

First, we arrange our test environment. This means that performing any setup that may be required in order to test the functionality. 

You may need to instantiate objects for the test, or ensure that an object is in a certain state during the test. You would need to add some items to a list if you were testing a sort function, for example. 

Simple tests will not require any arrangement, but others will. In this case, the arrange part happens in our `setup` method, which instantiates a `CoffeeShop` object with a `till` value of `100.00`.


Secondly, we perform the action that we are trying to test. In this case we called the `increase_till` method with the argument `2.50`. Another way you may see the same test written is as follows:

```python
# Example

def test_add(self):
    self.coffee_shop.increase_till(2.50)
    expected = 102.50
    actual = self.coffee_shop.till
    self.assertEqual(expected, actual)
```

Lastly, we make our assertion. Is the expected value the same as the value that actually came back?

## Conclusion

That's us set up a basic structure for our project. For clarity, it's conventional to have one test file for each class. This is not a strict rule but it makes sense if it's possible.
