# Lists

**Lesson Duration: 45 minutes**

### Learning Objectives

* Explain what lists are
* Create a list
* Access an element in a list
* Add items to a list
* Call list methods

## Intro - Collections

We've been dealing a lot with single objects - a person, a number. Just as with real life, we don't always have one of something - we could have a group of things. At home we don't just have one piece of food, we have many. We don't have one pair of shoes, we have many. So how do we represent this in our code?

This is where Lists come in. A list is part of a subset of objects known as "collections". It is essentially a storage container like a big basket, or bag, or box. In real life we might be storing fruit, shoes or sweets but in our code we can store any object we like of any of the datatypes we have seen - `int`s, `str`s, even `bool`s. 

`List`s in Python are very similar to what other languages call arrays.

The key thing about `List`s is that they are 'indexed', that is, you can access the things inside it by their index. It's all very well having a shopping bag full of fruit, but how do we find an apple in there? We'd have to search through every other item until we found it.

It's kind of like our lockers. They are ordered top to bottom and if we put items in them, even though we can't see them we know which locker they are in. As long as no one comes along and reorders our items without us knowing, we can always guarantee our items are in the same locker we left them.

## What Are Lists for in Programming

Given a list is a collection, we use them when we want to collect related items together to do useful things with them. Maybe we want to have a set of people's names or a list of lottery numbers. We can pass this around our program and do interesting things with it - most notably use loops to do repeated actions to every item in the set. We call this "enumerating".

This is such an important, useful functionality that we'll cover it in a whole dedicated lesson.

## What Are They Not For

Lists are pretty dumb, all they know is where something is in the list and no other information. It has no idea that the second item is a banana, or that bananas are yellow. It knows if it has an item at position 2 or not and that's about it.

So if we wanted to find a certain person's locker and we didn't know which position it was in, we have no other information to help us. We'd need to go through each one until we found it. Later on you'll see why using a dictionary would be a more efficient way to do it.

## Accessing Lists

All "keys" to a lists are integers, we call this the "index". The first element in a list is at index zero, and the amount of elements can generally go up as high as your computer/programming language will allow. Some languages require that you specify how big is each new list you use (to know how much space to allocate in memory), but Python is a bit more flexible, and will grow lists automatically to fit as many items as you add to it.

So what does this look like?

First, let's create a file in your working directory!

```
touch lists.py
```

```python
# lists.py

fruits = ['apple', 'banana', 'grape', 'orange']
print(fruits)
```

Lists are characterised by the square brackets around the elements.

List/array indexes in most programming languages start at 0. Why? [More info here](https://en.wikipedia.org/wiki/Zero-based_numbering#Usage_in_programming_languages) for the curious.

```python
# lists.py

print(fruits[0])
print(fruits[2])

```

But if we try to access an element that doesn't exist, we'll get an `IndexError`.

```python
# lists.py

print(fruits[10])
```

Unlike many other languages, Python lets us access elements from the end of the list using a negative index too

```python
# lists.py

print(fruits[-1])
print(fruits[-2])
```

## Updating an Item

We can update an item in a list by accessing an element at a particular index and giving it a new value, just like re-assigning a variable.

```python
# lists.py

fruits[1] = 'mango'
print(fruits)
```

## Creating an Empty List

There will be times where you want to initialize an empty list. We can do this in several ways, including

```python
# lists.py

my_list = []
my_list = list()
```

## Getting the Number of Items in a List

To find out how many items a list contains, we use Python's `len()` method:

```python
# lists.py

num_items = len(fruits)
print(num_items)
```

## Adding and Removing Items

We will so often need to add and remove items from lists, that there are numerous ways to do it.

If we take a look at [Python's List](https://docs.python.org/3/tutorial/datastructures.html) documentation, we can see that Python's lists have a number of handy methods we can use to perform operations.

We can add/remove to the end of the list.

```python
# lists.py

fruits.append('pear')
print(fruits)
fruits.pop()
print(fruits)
```

## List Elements

Elements can be _any_ type of object; literal values or variables. Unlike other languages, Python allows us to put a mixture of different kind of objects in an list.

```python
fruits_and_numbers = [ 'apple', 1, 'grape', 2 ]
print(fruits_and_numbers)
```

We can even put lists inside of lists.

```python
nested_list = [ 1, 2, 3, 4, [5, 6, 7] ]
print(nested_list)
```


### Task: 10 Minutes

> Note: Hand out [Task Start](lists_task_start.py).

Complete the tasks in `lists_task_start.py`
<details>
<summary>Sample solution</summary>


```python
# 1. Create an empty list called `task_list`

task_list = []


# 2. Add a few `str` elements, representing some everyday tasks e.g. 'Make Dinner'

task_list.append('Go Shopping')
task_list.append('Make Dinner')
task_list.append('Take Dog For a Walk')
task_list.append('Wash Dishes')

# 3. Print out `task_list`

print(task_list)

# 4. Remove the last task

task_list.pop()

# 5. Print out `task_list`

print(task_list)

# 6. Print out the number of elements in `task_list`

print(len(task_list))
  
```
</details>

## Recap

What number do list indexes start from?
<details>
<summary>Answer</summary>
Zero
</details>
</br>

How do we access an element in a list?
<details>
<summary>Answer</summary>
By using the name of the list, followed by the index of the element we are looking for in square brackets e.g. `my_list[2]`
</details>
</br>

Which type(s) can list elements be?
<details>
<summary>Answer</summary>
List elements can be of any type, including other lists
</details>
</br>

How can we add an element to the end of a list?
<details>
<summary>Answer</summary>
By using the `append()` method e.g. `my_list.append('banana')` 
</details>
</br>

How can we remove an element from the end of a list?
<details>
<summary>Answer</summary>
By using the `pop()` method e.g. `my_list.pop() `
</details>
</br>

How can we get the number of elements in a list?
<details>
<summary>Answer</summary>
By using Python's `len()` method e.g. `len(my_list)`
</details>
</br>

## Conclusion

We have seen how we can store collections of objects using lists and that we can add items to the end of a list and remove items from the end.
