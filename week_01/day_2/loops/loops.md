# Loops

**Lesson Duration: 60 minutes**

### Learning Objectives

- Be able to use loops to control behaviour
- Be able to use a for loop and a while loop

## What Are Loops

Loops in Python are used to execute a block of code a specified number of times. One of the principles of writing clean code is Don't Repeat Yourself, or DRY. Writing loops is one way to help us write more DRY code. Instead of repeating a block of code, we can tell Python to run it multiple times.

We're going to look at two types of loops: `while` and `for`.

Let's create a file:

```bash
#terminal

touch loops.py
```

## `while` Loop

A while loop executes code while a specified condition is true. Once the condition is not true the loop ends.

> Show this without the `counter += 1` line first.

```python
# loops.py

counter = 0
my_number = 5

while (counter < my_number):
   print(f"counter is {counter}")
   counter += 1
```

What happens if the condition is always true?... The code will loop forever, or eventually crash.

So beware of infinite loops. Python loops just keep on going until you run out of RAM...

## Playing with Loops

Let's write a program that asks a user to guess the answer to a question, and loops until they get it right:

So let's create a new file for this:

```bash
#terminal

touch quiz.py
```

```python
# quiz.py

my_number = 5
value = int(input("What number am I thinking of? "))

while (value != my_number):
    value = int(input("nope! try again... "))

print("yes!")
```

> Next bit is totally optional, just some conditionals practice. Maybe give them 5 mins to figure it out?

What would need to change in the above program to give the user information about whether their guess was too high, or too low? Is it much effort to do that? Why don't we...

```python
# quiz.py

my_number = 5
value = int(input("What number am I thinking of? "))

while (value != my_number):
    if (value > my_number):
        print("too high")
    else:
        print("too low")
    value = int(input("try again... "))

print("yes!")
```

## Exiting out of Loops

To exit out of loops, and when loops crash, we have some other functionality available to us. The keyword `break` terminates the loop.

So for instance, if we want to loop asking the user for input for ever, _until_ they type a particular character ('q'), we could use:

> you might want to create a separate file for this

```python
while (True):
    line = input("type something: ")
    if (line.lower() == 'q'):
        break
    print(f"you typed: {line}")
```

## `for` Loop

So we've already looked at lists and collections of things, and seen how we can access individual items in that collection and do stuff with the items we access. But what if we want to do that stuff on all the items in the collection.

So say a farmer had a collection of chickens and she wanted to check them all to see if they'd laid any eggs that day. Each morning she goes round all the nests, making sure that each chicken is in its nest, and checks to see if any eggs have been laid. So she actually does exactly the same thing at each chicken's nest. Now if we were writing code to do this then it would get a bit tedious writing the same bit of code over and over again for each chicken.

A for loop executes code once for each element in expression.

Let's start with a simple example using some numbers:

> Write the middle line as `print(number)` at first, then add `* 3`

```python
# loops.py

numbers = [1, 2, 3, 4, 5]

for number in numbers:
    print(number * 3)
```

```python
# loops.py

total = 0

for number in numbers:
    total = total + number

print(total)
```

Say a farmer was doing a roll call of her five chickens:

```python
# loops.py

chickens  = ["Margaret", "Hetty", "Henrietta", "Audrey", "Mabel"]

for chicken in chickens:
    print(chicken)

```

> Draw on board with loops

* first time chicken = "Margaret"
* second time chicken = "Hetty"
* third time chicken = "Henrietta" and so on...

If we add more chickens we don't have to tell it to loop more times, it will just do it.


