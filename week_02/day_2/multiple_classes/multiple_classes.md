# Multiple Classes

**Duration: 90 minutes**

## Learning Objectives

- Use multiple classes together

### Introduction

So far, we have started our journey into Object Oriented Programming by writing single classes. But in the real world, things don't exist in isolation - they interact with each other.

We're going to investigate how we can develop our programs by making our classes interact with each other. We're going to model a pet shop, which interacts with customers and pets.

> Hand out start point

## The Pet Shop

The pet shop will be a place to store all the pets for sale, and it will have methods related to selling a pet.

The `Pet` class has been completed for us already. A Pet has:

- a name
- a type
- a breed
- a price

We will need to create the `Pet Shop` class. Our pet shop will have:

- a name
- pets (a list of pet objects)
- pets_sold
- cash

And our pet shop will be able to:

- remove pet
- increase cash
- increase pets sold
- sell pet to a customer

Just like the `Pet` class can have a string for its name and an integer for its price, the `Pet Shop` class can have a list called pets and that list can contain `Pet` type objects. Let's see this in action.

First, we will need to create a file to write our Pet class in.

```sh
touch pet_shop.py
```

Creating the class will be no different from the classes that we have created previously. We will create a class called `PetShop` and create an `__init__` function within it to set up the properties.

```py
# pet_shop.py

class PetShop:
    def __init__(self):
        pass
```

Let's add the properties to our init function. We will pass in values for the name, cash and pets, as those might be different for every new Pet Shop, and set pets_sold to 0.

```py
class PetShop:
    def __init__(self, name, cash, pets):
        self.name = name
        self.cash = cash
        self.pets = pets
        self.pets_sold = 0
```

> When we make a new Pet Shop, pets sold will always start as 0, so we'll hard code that at 0 in the `__init__` method instead of passing the value for it as an argument.

Let's make a `PetShop` type object in app.py. We will need to import the `PetShop` class so that we can use the constructor function to make an object.

```py
from pet_shop import PetShop

# ...

cc_pet_shop = PetShop("CodeClan Pet Shop", pets, 0)
```

> We'll pass in the pets list as the value for the pet shop's `pets` property.

Let's write a method on the `PetShop` class which will tell us how many pets it has in stock.

We'll call the method `stock_count` and it will return to us the number of pets within the pet shop as an integer.

First, let's imagine how we would like to be able to use the method...

```py
# app.py

stock_count = cc_pet_shop.stock_count()
print(f"{cc_pet_shop.name} has {stock_count} pets in stock")
```

Now we can implement the method in the Pet Shop.

We can use Python's built in `len()` function to tell us the length of the list of pets.

```py
# pet_shop.py

def stock_count(self):
    return len(self.pets)
```

If we wanted the pet shop to be able to sell a pet, let's think about all the things that would need to happen.

We would need to:

- increase the amount of cash the pet shop has
- find and remove the pet from the pet shop
- increase the number of pets sold by the pet shop

Let's add a method to do each of these things, so our pet shop is able to sell pets.

First, we'll add the method to allow us to increase the amount of cash that the pet shop has.

To check that this works, let's print out the total cash of the pet shop before and after we try to increase it.

```py
# app.py

print(f"{cc_pet_shop.name} started with £{cc_pet_shop.total_cash}")
print("Increasing total cash by 100")
cc_pet_shop.increase_total_cash(100)
print(f"{cc_pet_shop.name} now has £{cc_pet_shop.total_cash}")
```

Next we will need to implement a method called `increase_total_cash` in the pet shop, which takes in an amount and increases the value of the `total_cash` by that amount.

```py
# pet_shop.py

def increase_total_cash(self, amount):
    self.total_cash += amount
```

Let's move on to the next piece of functionality that we said we would need to add - the ability to remove a pet from the pet shop.

We can test this using the `stock_count` property to make sure that the stock count goes down after we remove a pet.

```py
# app.py
print(f"Removing {monty.name} from {cc_pet_shop.name}...")
cc_pet_shop.remove_pet(monty)
print(f"{cc_pet_shop.name} has {cc_pet_shop.stock_count} pets in stock")
```

Next, we can implement a method called `remove_pet`, which takes in a pet object and removes it from the list of pets.

Remember, the value of the `pets` property in the `PetShop` class is a list, so we can use the lists `.remove()` function to remove the element that we want to remove from the list.

```py
# pet_shop.py

def remove_pet(self, pet):
    self.pets.remove(pet)
```

Let's add the method to find a specific pet object within the list. There are a few different ways that we could do this but we will write a method that takes in the name of the pet that we want to find and returns the whole object.

We can test this by trying to find a pet and printing it out.

```py
# app.py

print("Searching for a pet with the name Charles...")
found_pet = cc_pet_shop.find_pet_by_name("Charles")
print(found_pet.__dict__)
```

Implementing this method will be a little bit more tricky.

We will need to use a for loop to look at each pet in the list in turn and check if their name matches the name that we're looking for. If it does, this is the pet object that we're looking for, so we'll return it from the method.

```py
# pet_shop.py

def find_pet_by_name(self, name):
    for pet in self.pets:
        if pet.name == name:
            return pet
```

Lastly, we need to be able to increase the number of pets sold by the Pet Shop. This will be much easier than the last one.

We can test this by printing out the value of the `pets_sold` property of the Pet Shop before and after increasing it.

```py
# app.py

print(f"{cc_pet_shop.name} has sold {cc_pet_shop.pets_sold} pets")
print(f"Increasing pets sold...")
cc_pet_shop.increase_pets_sold()
print(f"{cc_pet_shop.name} has now sold {cc_pet_shop.pets_sold} pets")
```

Now we can write the method, which just needs to increase the number of pets sold by 1.

```py
# pet_shop.py

def increase_pets_sold(self):
    self.pets_sold += 1
```

Let's put it all together.

We can write a `sell_pet` method, which calls all of the other methods that we wrote in sequence.

When we sell a pet, we will:

- find the pet object we want to sell
- increase total cash by the price of that pet
- increase the number of pets sold
- remove the pet from the pet shop

We can test this by selling a pet and checking that the expected changes have happened within the Pet Shop object.

```py
# app.py

cc_pet_shop.sell_pet("Charles")
print(f"{cc_pet_shop.name} sold {charles.name}")
print(f"{cc_pet_shop.__dict__}")
```

Now, let's implement the method.

```py
# pet_shop.py

def sell_pet(self, name):
    pet = self.find_pet_by_name(name)
    self.increase_total_cash(pet.price)
    self.increase_pets_sold()
    self.remove_pet(pet)
```

Breaking more complex methods up into smaller methods like this can help to make our code much more readable.

### Conclusion & Composition

Making our classes work together is really no different from using Python's built-in data types, like strings and integers, as the values for properties of our classes. With time and practice it will become second nature.

One way we can make objects interact is to add a list as an instance variable and pass in objects into that list. But it doesn't have to be a list! An instance variable could be a single object, such as customers only having a single `Pet` property, for example. Once we have objects within this list, we can access any properties or methods they have on them.

For example, a car class might have an `engine` property, and to start the car, we might do `engine.start()`. This is a process called _composition_, and we'll look at it in more detail later on in the course.

We can also pass objects into methods and use the properties or methods attached to the object. For example, if we were to access one of the Pet objects inside a Pet Shop's list of pets, we would be able to access its name, type, breed, or price.
