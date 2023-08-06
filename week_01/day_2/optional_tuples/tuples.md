# Tuples

**Lesson Duration: 30 minutes**

### Learning Objectives

* Explain what tuples are
* Create a tuple
* Access an element in a tuple
* Add items to a tuple
* Call tuple methods
* Know the difference between a list and a tuple

## Intro

Tuples are another data structure we can use in Python. They are very similar to lists - we can access elements by index and call methods on them but have they one major difference. As we have seen, once we have created a list we can add/change/remove items i.e change the contents of the list. This means that a list is _mutable_. Tuples, on the other hand are _immutable_ which means that once a tuple has been created, it's contents cannot change. If we try to change an element in a tuple then we get an error.

## Creating a Tuple

To create a tuple we use a comma-separated list of values. These may, or may not be in parenthesis `()`.

```python
# tuples.py

my_tuple = 'Ford', 'Escort', 1300, 'Red'
my_tuple = ('Ford', 'Escort', 1300, 'Red')

print(my_tuple)
```

If we want to create a tuple which has only one element then we need to include a final comma (otherwise it is treated as a single value):

```python

my_single_element_tuple = 'Ford',
print(my_single_element_tuple)
```

We can actually also create an empty tuple:

```python
my_empty_tuple = ()
my_empty_tuple = tuple()
```

Why would we do this? 
> We might need to do this where we have a collection of tuples and want to denote some empty data.

## Immutability

Unlike lists, we cannot change the contents of a tuple. For example, if we were to try 

```python
my_tuple[1] = 'Fiesta'
```

We get the following error:

```
TypeError: 'tuple' object does not support item assignment
```

## Accessing a Tuple

Like lists, tuples can be accessed by their index (starting at 0)

```python
# tuples.py

print(my_tuple[0])
print(my_tuple[3])
print(my_tuple[-1])  # ACCESSING FROM THE END
print(my_tuple[-2])
```

## Tuple methods

Tuples only have two methods available: `count`, which counts the number of occurrences of an object in a tuple; and `index`, which returns the index of an object inside the tuple:

```python
# tuples.py

print( my_tuple.count('Ford') ) 
# => 1

fruits = ("apple", "apple", "banana", "banana", "banana", "tangerine")
print(fruits.count("banana") ) 
# => 3

print(my_tuple.index("Escort") ) 
# => 1
```

Tuples can also be passed into Python's built-in functions, like `len`:

```python
# tuples.py

print(len(my_tuple)) 
# => 4
```

## Tuples vs Lists

Although both lists and tuples can contain items of different types, it is usually preferable to store items of the same types in lists as we may want to go through that list and perform some operation on each item in the list. 

For example, we might want to collect data about a person, such as their name, age, job title and whether or not they are a vegetarian. 
A list isn't a great way to store this data, however. The data is collected, which is great, but we probably don't ever need to insert or append new data here. We have these four data points about a person, and that's that. This is where it is probably best to store the data in a tuple

```python
# tuples.py

person = ("Ada", 33, "Instructor", True)
print( person )
```

Another occasion where we may wish to use a tuple is where we have a collection of data which we know we do not want to change, for example:

```python
# tuples.py

days_of_the_week = ('Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday')

print(days_of_the_week)
```

When we know which information we want to store in the collection then we would use a tuple, rather than a list. 

### Task

Task: 10 Minutes

> Note: Hand out [Task Start](tuples_task_start.py).

Complete the tasks in `tuples_task_start.py`
<details>
<summary>Sample solution</summary>

```python
# 1. Create a tuple called 'my_task' for a task containing the following data:
# 'Make Dinner'
# 'Tomorrow'
# 2
# False

my_task = ('Make Dinner', 'Tomorrow', 2, False)

# 2. Print the tuple

print(my_task)

# 3. Accessing the tuple by index,
# print the object in the tuple with the value 2

print(my_task[2])

# 4. Using the appropriate method, print the number of objects in the tuple

print(len(my_task))

# 5. Get the index of the object in the tuple with
# the value 'False' and print it out

print(my_task.index(False))


```
</details>

## Recap

What's the main difference between a list and a tuple?
<details>
<summary>Answer</summary>
Lists are mutable i.e. their elements can change, but tuples are immutable and so the contents can't be changed once it has been created.
</details>
</br>

How do we access an object in a tuple?
<details>
<summary>Answer</summary>
By using the name of the tuple, followed by the index of the object we are looking for in square brackets e.g. `my_tuple[2]`
</details>
</br>

How can we get the number of elements in a tuple?
<details>
<summary>Answer</summary>
By using Python's `len()` method e.g. `len(my_tuple)`
</details>
</br>

Which methods are available on tuples?
<details>
<summary>Answer</summary>
`count` - returns the number of occurences of an object in a tuple
`index` - returns the index of an object inside the tuple
</details>
</br>



## Conclusion

We have seen that tuples are very similar to lists except that with tuples, unlike with lists, we cannot change the objects stored in a tuple once the tuple has been created. We have seen how to create tuples and how to access objects in a tuple.

