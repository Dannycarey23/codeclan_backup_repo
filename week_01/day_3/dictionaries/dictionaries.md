# Dictionaries

**Lesson Duration: 60 minutes**

## Learning Objectives

- Understand what a dictionary is
- Understand the advantages of a dictionary
- Be able to create a dictionary
- Be able to retrieve items from a dictionary
- Be able to add items to a dictionary
- Be able to modify an item in a dictionary

## What Are Dictionaries

We have seen that we can store a collection of objects in a list or tuple object. Let's say we wanted to store the food we are going to have that day. Enter dictionaries.

Let's create a file called dictionaries.py

```python
# dictionaries.py
# as a list
meals = [ 'yoghurt', 'roll', 'steak' ]

# as a tuple
meals = ('yoghurt', 'roll', 'steak')
print(meals[0])
# => 'yoghurt'
```

This is fine but we need to remember that breakfast is index 0, lunch is index 1 and dinner is index 2. We can only access items by their index in a list or tuple.

In our example, we actually have additional information about the objects in our collection. We know the first one is breakfast, the second is lunch and the third is dinner. We don't actually care which order they are stored in really. Also, if we forgot the position of breakfast we would need to search through the whole set to find it again!

In Python, and many other languages, there is another collection we can use: a Dictionary. It's sometimes called a Hash or Associative Array in other languages.

In a dictionary every item is given a unique key of our choosing and it is this key that is used to retrieve the object rather than an index. The order is irrelevant so we can't rely on the ordering.

Each key in the dictionary is unique allowing you to always find the value you stored against a particular item.

It's a little bit like a filing cabinet - we have labels we associate with things we want to store e.g. finance, recipes, reciepts. It doesn't matter what "index" the items are stored at (there's no need to know Finance is the first set of items in the drawer), what matters is the label we filed it under. If we moved all the items around, we could still find "Finance" easily by its label.

## Using Dictionaries

### Creating Dictionaries

We have a couple of options for initialising an empty dictionary. We can create a new empty dictionary using braces, AKA curly brackets (`{}`), or by using the `dict` (short for dictionary) method

```python
# dictionaries.py
my_first_empty_dictionary = {}
my_second_empty_dictionary = dict()
```

Let's create a populated dictionary. We can create a dictionary with key-value pairs in it. A key-value pair is written by linking the `str` key to the value with a colon (`:`). Each key value-pair is separated from the next pair with a comma (`,`).

```python
# dictionaries.py
meals = { "breakfast" : "yoghurt",  "lunch" : "roll", "dinner" : "steak" }
print(meals)
```

In this dictionary, we have keys which are `str` and values which are `str`. The keys could be other types of things, like `int`s, and the values could be any object - lists, `bool`s, anything.

```python
# dictionaries.py
silly_thing = { 1 : "2", 2 : "3", 4 : False }
print(silly_thing)
```

### Accessing Elements

We can access elements in a similar manner to lists, using the square brackets - the main difference is, we have to use the key, instead of an index.

```python
# dictionaries.py
print (meals["breakfast"])
```

If we try to access an element for which there is no key we get a `KeyError`.

```python
# dictionaries.py
print (meals["supper"])
```

If we want to check if a key exists in a dictionary we can use the `in` keyword

```python
# dictionaries.py
print ("breakfast" in meals)
# => True

print ("supper" in meals)
# => False
```

## Modifying Elements

We can add objects to a dictionary much like we would assign variable.

```python
# dictionaries.py
meals["supper"] = "pancakes"
print(meals)
```

We can also replace objects

```python
# dictionaries.py
meals["dinner"] = "pasta"
print(meals)
```

We can remove items using the `del()` method:

```python
# dictionaries.py
del(meals["breakfast"])
print(meals)
```

> [TASK:] Make a dictionary with a key of a persons name and the value as their pocket money. Try updating and deleting items from it.

## Helpful Methods

A dictionary has lots of helpful methods, including ways to list all the keys:

```python
# dictionaries.py
print(list(meals))
# => ['lunch', 'dinner', 'supper']

print(meals.keys())
# => dict_keys(['breakfast', 'lunch', 'dinner', 'supper'])
```

The `keys()` method returns an object called a [view object](https://docs.python.org/3/library/stdtypes.html#dict-views). The view object contains the keys of the dictionary, as a list.

We can also get the list of values:

```python
# dictionaries.py
print(meals.values())

# => dict_values(['yoghurt', 'roll', 'pasta', 'pancakes'])
```

Like the `keys()` method the `values()` method also returns a view object.

## Nested Dictionaries

Let's make a quick dictionary of countries.

```python
# dictionaries.py

countries = {
    "uk": "London",
    "germany": "Berlin"
  }

print(countries)
```

This is fine, but what if we also want to store the population? Would we make a separate dictionary?

We can actually store a dictionary inside of a dictionary! Sounds scary, but it can actually be very useful. Let's add the populations.

```python
# dictionaries.py

countries = {
	"uk": {
		"capital": "London",
		"population": 1000
	},
	"germany": {
		"capital": "Berlin",
		"population": 5
	}
}

print(countries)
```

### Task
See if you can figure out how to get the population out of Germany.

```python
# dictionaries.py
germany_population = countries["germany"]["population"]
print(germany_population)
```

### Task
Make a dictionary called **avengers**. It should contain keys for Iron Man and Hulk.

Each avenger is represented by another dictionary, and has a name (Tony Stark and Bruce Banner respectively) and another dictionary containing their attacks.

Each attack should have an `int` value of the attack's power.
Iron man can punch (10) and kick (100) and Hulk can smash (1000) and roll (500).

Once you have created the dictionary, retrieve and print out the attack power of Hulks smash move.

#### Solution

To create the dictionary:

```python
#avengers_dictionary.py

avengers = {
  "ironman": {
    "name": "Tony Stark",
    "moves": {
      "punch": 10,
      "kick": 100
    }
  },
  "hulk": {
    "name": "Bruce Banner",
    "moves": {
      "smash": 1000,
      "roll": 500
    }
  }
}
```

To retrieve the attack power of the Hulk's smash move from the dictionary:

```python
#avengers_dictionary.py
# attack power of Hulk's smash move
print(avengers["hulk"]["moves"]["smash"])
```
