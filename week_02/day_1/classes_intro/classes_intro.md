# Python Classes

### Learning Objectives

- Understand the basic idea of Object Orientation
- Be able to create a class
- Be able to create an instance of a class
- Understand the difference between a class and an object
- Be able to add properties to class
- Be able to add methods to class
- Understand the difference between a function and a method
- Understand that classes both store data and have behaviour.

## Intro

We have been creating objects from the 'out the box' classes Python provides for us.

Let's recap some of these classes.

```python
l = []
s = ""
d = {}
```

We have been calling methods on these objects also.

```python
l.append(1)
l.clear()
```

Today we are going to see how we can create our own objects, with their own methods.

**Fundamentally, object-oriented programming sees the world as data, modelled in code by "objects."** Coupled together with their behaviour - methods.

**In OOP, the programmer focuses on designing 'classes'** that define the properties and behaviours of 'objects' that will be instantiated from our classes.

> Draw a house being cobbled together from lots of components

## Function Recap

We have been writing functions to achieve the behaviour we desire. Passing in the data we want to be updated and getting the function to return the result we want back.

Our programs have thus far had our data, often in lists and dictionaries, and functions.

Let's get our code set up. We'll start by creating a package called `modules`. As it's a package we'll need an empty `__init__.py`

```bash
# terminal
mkdir modules
touch modules/__init__.py
```

We'll create an `app.py` file to run our code:

```
bash
# terminal
touch app.py
```

In this file we'll create a dictionary to with the details for a bank account. We'll call a function to get the name of the account holder:

```python
# app.py

account = {
    "holder_name": "John",
    "balance": 500,
    "type": "business",
}

print(get_account_name(account))

```

We don't have a `get_account_name` function so we'll put the `get_account_name` into a file which deals with the bank account.   

```bash
# terminal

touch modules/bank_account.py
```

```python
# bank_account.py

def get_account_name(account): # ADDED
    return account["holder_name"]
```

In our `app.py` file we'll need to get the code for the function:

```python
# app.py

from modules.bank_account import * # ADDED

account = {
    "holder_name": "John",
    "balance": 500,
    "type": "business",
}

print(get_account_name(account))
```

You can see here the data dictionary and function are coupled in their behaviour. However, our account name function is sort of just floating around in the middle of nowhere - the dictionary and the function are not linked in anyway even though we know they are used together.

Object orientated programming takes the step of grouping the behaviour and the data together in an object. This way, we can have nicely bundled pieces of related code that can be reused.

Often, we don't just want one object but many of that type. Think about `str`s, lists, `int`s and in this case Bank Accounts. It is for this reason that when defining the behaviour, we don't do it for a single object, but for a class of objects.

## Real World Example - Person

Let's think about a real life example.

In the classroom, we have many people. We all have different names, hair colour and favourite colours. However, we all have a name, we all have hair and we all have favourite colours. We know that a person has these traits, and that since we are all people we have our own instances of these things.

In Python, we could say that a Person is a class, a template, a blueprint and that John is an instance - he has specific implementations of the properties we know that a person has. I have brown hair, my name is John and my favourite colours are black and gold.

Similarly, we know that all people can walk, talk and sleep. We all do this, in our own way. You walk differently to your neighbour, and they talk differently to their mum. But we all walk and talk because we are People.

We can also represent this in our code, by attaching "behaviours" to classes as well as properties. These are represented by functions, or "methods". More on this later.

## Object Orientated Code

Let's have a look at this in the context of a bank account example.

To make a class, we need the "class" keyword in Python. This is going to be our template where we define the properties and behaviours that our bank account objects will have.

```python
# bank_account.py

class BankAccount:
    pass
```

NOTE - we're using the `pass` keyword as a placeholder for the code which is going to be inside our class. This code is indented so that the Python interpreter knows that it is part of the class.

We're now going to create an instance of that class. To create an instance of a class we use the class name followed by parentheses `()` e.g.:

```python
# app.py

from modules.bank_account import *

bank_account = BankAccount() # MODIFIED
```

The parentheses will make a lot more sense as we add properties to our bank account.

Our code isn't actually doing anything, but at least there are no errors.

> You could also add a `print(bank_account)` to show that the object has been created.

> Make sure everyone is on par here.

## Initializing State

The bank account object we created was pretty empty. If you remember, our bank account needs a holder name, balance and a type.

We want to pass this to the object when we create it, since these are properties every bank account needs to have. We can pass this initial data to our object in the parentheses `()`, like passing arguments to a function call. It turns out that using the class name is just a special function we can use to pass initial data to our object - defining the initial state that our object has.

```python
# app.py

account = BankAccount('John', 500, 'business') # MODIFIED
```

If we run this, we will see an error. We have not actually told our class to expect a name, value or type so it doesn't know what to do with it. Let's go add them.

All classes have a special function called `__init__` that we can use to set the state of our object. This is the code that is run when we create an instance of class. This is just the way Python handles initializing state, don't worry about it too much. All you need to remember is that when we use `.new` it is the `__init__` method which is called. What we pass to the class name and what we expect to get in `__init__` must match up, just like with a normal function.

The `__init__` method, and indeed all methods inside a class always take at least one parameter, called `self`, which is used to tell Python that this parameter is a reference to the current instance of the class. Inside the class self is used to access variables that belong to the class. This `self` parameter is always the first parameter that the method takes, and we add anything else we want to pass after the `self` parameter. So as we want to pass the account holder name, balance and account type when we create an instance of `BankAccount` we write:

```python
# bank_account.py

class BankAccount:
  def __init__(self, input_holder_name, input_balance, input_type): # ADDED
      pass
```

Cool, so now we are no longer getting any errors. Note that we can replace the name, value and type of our object with anything we want. This is just one instance of a bank account.

> Do a quick demo of making another bank account then delete it.

However, we are not actually doing anything with the data. It is passed to the `__init__` method, then is lost.

> Break here

## Initialize Instance Variables

Okay, so we probably want to be able to access our name, value and type after we have first initialized them. The value of the bank is likely to change a lot for sure, so we definitely need to be able to access it and update it.

We call properties of a class which are available during the entire life of an object "instance variables". As long as our bank account exists in memory, these values will be stored and remembered. This is the object's state.

This is different to the "local" variables we saw before in functions, which live as the function executes then are lost.

Instance variables are defined by writing `self.` before the variable name. The `self` keyword is used to denote that the variable refers to this particular instance of the class e.g. `self.holder_name` stores the name of the holder of _this_ particular bank account and no other.

```python
# bank_account.py

class BankAccount:
    def __init__(self, input_holder_name, input_balance, input_type):
        self.holder_name = input_holder_name
        self.balance = input_balance
        self.type = input_type
```

This is how we setup the data on an object, and it does not get lost after initialization.

Note that the instance variable names can be the same, or different to those that are passed in from the parameters.

```python
# bank_account.py

class BankAccount:
    def __init__(self, holder_name, balance, type):
        self.holder_name = holder_name
        self.balance = balance
        self.type = type
```

We now have successfully stored the data in the object. But how do we get it back out?

## Accessing Instance Variable

We can access the instance variables in our object using dot (`.`) notation. We write the name of the variable our object is stored in, followed by a dot (`.`), followed by the name of the instance variable we want to access. So if we wanted to access the name of our account holder we would write:

```python
# app.py

from modules.bank_account import *

account = BankAccount('John', 500, 'business')
print(account.holder_name)  # MODIFIED

```

## Modifying Instance Variables

There will be times when we want to change the value of our instance variables. We access the instance variable we want to modify using dot notation and assign it a new value. Say we wanted to change the name of the account holder to 'Ada', rather than 'John', we would write:

```python
# app.py

from modules.bank_account import *

account = BankAccount('John', 500, 'business')
print(account.holder_name)  # MODIFIED

account.holder_name = 'Ada'  # ADDED
print(account.holder_name)
```

## Behaviour

So far we've been looking at the data stored in our object, but we also want to attach some behaviour. Let's add some behaviour to our bank account, to allow us to change the balance if some money is paid in:

```python
# bank_account.py

class BankAccount:
    def __init__(self, holder_name, balance, type):
        self.holder_name = holder_name
        self.balance = balance
        self.type = type

    def pay_in(self, amount):
        self.balance += amount
```

Note that, like the `__init__` function, the first parameter of the `pay_in` function is `self`, to say that it is attached to this instance of the `BankAccount` class. That means that it is called on an instance of the `BankAccount` class, we cannot just call it on it's own.

```python
# app.py

from modules.bank_account import *

account = BankAccount('John', 500, 'business')
print(account.holder_name)

# ...

account.pay_in(50)
print(account.balance)

```

When functions are attached to classes, they are called _methods_.

In the example above we are not simply updating the value or retrieving the value. It's modifying it with some logic.

## Conditional State

We sometimes want instances to behave slightly differently depending on their state (instance variables). Let's make a little pay monthly method, which subtracts 50 off the value of the account.

> [Task:] Make a pay_monthly_fee method, which reduces the value of the account by 50. Try calling it in `app.py`

> SOLUTION:

```python
# bank_account.py

def pay_monthly_fee(self):
    self.balance -= 50
```

```python
# app.py

from modules.bank_account import *

account = BankAccount('John', 500, 'business')
print(account.holder_name)

# ...
account.pay_monthly_fee()  # ADDED
print(account.balance)
```

Our bank account currently isn't very fair, since personal users pay the same fee as a business user. Change the monthly fee method to deduct only 10 for a personal account, and 50 for a business account.

> [Task:] Take a few minutes to do this. You will need to create more than one bank account to try it out

> SOLUTION:

```python
# app.py

from modules.bank_account import *

account = BankAccount('John', 500, 'business')
print(account.holder_name)

account.pay_monthly_fee()
print(account.balance)

account_1 = BankAccount('Ada', 100, 'personal')
account_1.pay_monthly_fee()
print(account_1.balance)
```

```python
# bank_account.py

def pay_monthly_fee(self):
    if self.type == "business":
        self.balance -= 50
    elif self.type == "personal":
        self.balance -= 10
```

## Internal variables

Sometimes in our classes we may want to have instance variables which are used in methods inside the class but the world outside the class does not need to see them. 

For example, for our `pay_monthly_fee` method, let's say, rather than using an `if..elif` statement we wanted to look up a set of 'rates' which stored the fees for each type of account. We could use a dictionary for this, where the key is the type of account (personal, business, etc) and the value is the monthly fee for that type of account e.g

```python
rates = {
    "personal": 10,
    "business": 50
}
```

We could add this as a property to our class as we have done before, and look it up in our `pay_monthly_fee` but this means that it can be seen by the outside world, and could be modified by the outside world. We want this variable to only be used by the methods inside the class. We want the user of this class to know this so how can we distinguish this instance variable from the ones we can want users to be able to access outside the class - we can do this by adding and underscore (`_`) before the variable name i.e.: 

```python
# bank_account.py

def __init__(self, holder_name, balance, type):
    self.holder_name = holder_name
    self.balance = balance
    self.type = type
    self._rates = {       # ADDED
        "personal": 10,
        "business": 50
    }

def pay_monthly_fee(self):
    self.balance -= self._rates[self.type]  # MODIFIED
```

This tells the user that `_rates` can be accessed and used inside the class, but should not be used outside the class.

## Classes have both data and behaviour

So now we have a bank account class which has both data (instance variable) and behaviour (methods) attached to it. In some cases we may just have functions which we want to group together, but that group may not have specific data attached to it. In other languages we would also group these functions in a class but where that class does not have instance variables. The 'Python' way is not to put these functions in a class, but to group them together in a module.

## Recap

What is the difference between a class and an object?
<details>
<summary>Answer</summary>
A class is a template or blueprint whereas an object is an actual instance created from that template.
</details>

What goes before the name of a variable inside a class to show it is an instance variable?
<details>
<summary>Answer</summary>
`self`
</details>

How do we access an instance variable in an object?
<details>
<summary>Answer</summary>
We use the name of the object followed by a dot `.` followed by the instance variable name e.g. `account.balance`
</details>

What is the first parameter in any method in a class?
<details>
<summary>Answer</summary>
`self`
</details>

What is the difference between a function and method?
<details>
<summary>Answer</summary>
A function is standalone whereas a method is attached to a class. A function can be called on it's own, but a method must be called on an instance of a class i.e. an object.
</details>

How can we denote a property that should only be accessed from within the class?
<details>
<summary>Answer</summary>
By prefixing the property name with an underscore e.g. `self._rates`
</details>

## Summary

In this lesson we have covered the basics of object oriented programming. We have seen that classes can be seen as a template and that objects are instances of these classes. We can create classes in Python and have data and behaviours associated with these classes. We can create Python objects from these classes, give them initial data and access that data and the behaviours of those objects.
