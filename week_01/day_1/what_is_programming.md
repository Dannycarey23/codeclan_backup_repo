# What is Programming?

**Lesson Duration: 90 minutes**

### Learning Objectives
- Know what a programming language is
- Understand the difference between a class and an object
- Be able to run Python code in the Python3 REPL on the command line

## What Is a Programming Language?

Our task as programmer is to communicate thoughts/ideas/structures to a computer.

> Draw image of communicating thoughts to a computer

Let's imagine we live in a world with no programming languages. We have to talk to our computer in machine code. 0010101001010. This would not be fun. It would be hard to write and hard to read. Expressing high level ideas would be almost impossible.

Thankfully we live in the lovely world where lovely people have created programming languages, and more importantly interpreters to speak to the computer at a low level language.

> Break down computer into CPU and language interpreter.

> Draw robot on whiteboard

The programmer can then speak in the more expressive/readable/maintainable high level language.  Examples of these languages are Python, Javascript, Java, Ruby, C, C++, C#, Swift, Go, Pascal, Scala....

## Python

The language we are going to start using is Python. The Python programming language was created by the Dutch engineer Guido Van Rossum in the early 1990s. In contrast with other programming languages of that time, it was designed to be _fun_. This is reflected in the name of the language, which is named after Monty Python's Flying Circus - not the snake!

Python is a general purpose programming language; it is intended to be used to solve a wide variety of problems in computing, such as:

- Building desktop and web applications
- Solving scientific and statistical problems
- Providing scripting support for other software applications, particularly multimedia apps
- Artificial intelligence and data science

As a language, Python has a clear, readable syntax. Perhaps its most notable feature is its use of whitespace to denote blocks of code, rather than the curly brackets that you might see in other programming languages.

It's community places quite an emphasis on aesthetics. It's common to hear code being described as _Pythonic_ - this is code that meets the community's idea of how Python code should be. This philosophy is laid out in a document called [The Zen of Python](https://www.python.org/dev/peps/pep-0020/#id3).

## A short note about version numbers

In this course, we'll be using Python 3, as it is the current and future implementation of Python.

Unfortunately, many computers still come with Python 2 rather than Python 3. 

### Why Teach Python?

Python has many traits which are transferable to other languages.

- Structure similar to many other languages (class based object orientated language)
- Community tends to follow best practices (e.g. how code is tested)
- Clean (everything is an object)
- It is very popular

### Working with Python

We all have Python installed on our laptops.

```bash
# terminal

python3 --version
```

Typing `python3`  will open an interactive Python environment in the console (we exit it by typing `quit()`). This launches a Python REPL:

  * REPL = Read, evaluate, print, loop => good for experimenting with short" snippets of code.

This REPL allows you to quickly try snippets of Python outside of your application.

Use it frequently to test lines of code or to experiment outside of the bigger programs we will write later.

Let's write our first Python program

```python
# python3

"hello"
```
So what was going on here?


## Objects

Python is an Object Oriented language. 'Everything is an object'.

Here our Python interpreter created an object to represent text for us.

Python is class based object orientated language. All objects are instances of classes.  The class that represents text is called `str`. We just created an object of the `str` class. We can find out the class of an object by calling the `type()` function with the object:

```python
# python3

type("hello")

# => <class 'str'>
```

The idea of classes and objects is the key to object orientated programming.  It is a concept that can be hard to grasp.  Let's look at some examples.

> It's useful to use a real word analogy here to explain class vs object. eg Person class, can create person objects (such as us)!

> Optional depending how you get on, in Text Editor write up example of Classes and corresponding Objects,  get the class to create them.

Python provides a number of Classes for us out the box,  we can then create objects from them.

Where did this `str` class come from? We can produce these objects because Python provides these classes out the box.

```python
# python3

"Hello"
"Good Day"
"Howdy"
```

> Show on diagram we are creating multiple objects of the same class.

Learning to program in an object orientated language like Python is a combination of understanding how we construct programs (much like grammar) and how we can use the Classes it provides for us (much like vocabulary)

*Everything* in Python is an object, and objects have a "class" (a 'type'). There's is a set of types that we can use in Python which make up the bedrock of our programs.

## Types

We need a way to communicate ideas to our Python robot. Maybe we want to print some text, do a numerical calculation or something else useful to us. To achieve this, we need some basic building blocks and we call these "types". The basic types are just classes that come out of the box with Python.

### `str`

The `str` Class is given to us in Python and we can use it to represent text.  We are given a special syntax for creating `str`s in Python,  using single or double quotes.  There are subtle differences in these but for now we can use either.

```python
# python3

"some text in here"
type("some text in here")
```

### `int`

`int` objects are ready for us to access using the numbers. We are given methods on these objects.


```python
# python3

24
type(24)
```


## Variables

### Assigning objects to variables

Lets create another `str` object

```python
# python3

"This is a string object I have told Python to create"
```

How can I get this string back?
We created this string but it was lost to us immediately. To hold on to a string we need to assign it to a variable.

```python
# python3

my_string = "A brand new string object"
```
We create the object as before, but this time we hold a reference to it and call it `my_string`.

> Draw on board the variable referencing the object. Show this for each example
> Can use analogy of cloakroom and ticket here.

We can then access the object using the variable we have assigned to it.

```python
# python3

my_string
```

We can store values in "variables" - they're variable because the values can change (we also call this 'mutability')

```python
# python3

my_string = "Another String I have defined"
my_string
```


The name of a variable is almost totally up to you to define. Pick a name, and tell it what value it equals:

Have a play with assigning objects to variables. Eg

```python
# python3

character = ""
age = 24
```

### Variable Naming Conventions

Python has fairly strong opinions about how you should write your code, but very little in the way of enforcement. So you're free to break the rules if you wish, with no real worry about consequences...

... apart from tutting and disapproving headshakes from your peers.

Keeping to style guides means that other developers can more quickly understand your code (and you theirs), and contribute quickly to a code base without making it hard for others to follow.

We use **CamelCaseForClasses**, ****, and **lower_case_snake_case_for_everything_else**.

[Python style guide naming conventions](https://visualgit.readthedocs.io/en/latest/pages/naming_convention.html)

> BREAK

## Using Objects

We've seen objects, and holding on to them with variables. We've created `str` objects to represent text, and `int` objects to represent numbers.

Okay nice, but we often want to do things with our objects.

Let's create two numbers.

```python
# python3

number_1 = 22
number_2 = 12
```

We can find the sum of this using the + operator

```python
# python3

number_1 + number_2
```

Again we have just lost this value!  What can we do with it?  Yes, store it to a variable.

```python
# python3

sum = number_1 + number_2
sum
```

`int` has many operators we can use.  Try using -, *

### Strong Typing

What do you think will happen if we do this?

```python
# python3

1 + "2"
1 + int("2")
```


### `str`

#### Combining Strings
Strings also have the `+`` operator this will combine the strings.

```python
# python3

word_1 = "hello"
word_2 = " world"
sentence = word_1 + word_2
sentence
```

### Calling Methods

The objects created by the out the box Python class have a bunch of 'things' we can do to them.

```python
# python3

my_string = "hello"
my_string.capitalize()
```

These things are called methods. ( Again what is actually going on will become clearer when we start writing our own classes next week ) We call a method on an object using . and then the name of the method we want to call. Let's see useful methods on strings.

To see all the methods available on a `str` check out the docs.

[String class](https://docs.python.org/3/library/stdtypes.html?highlight=str#str)


### Summary

We have learned about Classes, and how Python provides useful Classes out the box. How we can use Classes to create objects, and how we can assign objects to variables so we can reuse them.  We have seen that objects have methods on them which we can call using dots(.)

Creating objects from classes, and calling methods on these objects is what we as Object Orientated programmers will spend most of our time doing. It may seem strange as first but it will become second nature to us.

### Further Practice

If time, practice creating objects, assigning variables, calling methods.

Create a `str` object, assigning a variable and call a method we haven't used yet.
Create an `int` object, assigning a variable and call a method we haven't used yet.
