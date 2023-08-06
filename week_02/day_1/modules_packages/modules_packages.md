# Modules & Packages

**Lesson Duration: 30 minutes**

### Learning Objectives

- Know what modules are in Python
- Understand why modules are used
- Be able to create a module
- Be able to import a module into our code
- Be able to access code from an imported module
- Know what packages are in Python
- Be able to create a package
- Be able to import a module from a package
- Be able to organise our files into modules and packages

## Modules

When we start writing larger programs it gets difficult to read if we have lots of code in the same file. That is where we can start to use modules. Modules help us to organise our code into more manageable chunks. If we write some code which we may want to use in other programs then we can also use modules for this.

### What is a module?

A module is a file which contains Python code. This code may contain functions, or other objects. The module gets its name from the name of the Python file which contains the code.

### Creating a Module

Let's create module which is going to contain some python functions

```bash
touch calculator.py
```

```python
# calculator.py

def add(num1, num2):
    return num1 + num2

def subtract(num1, num2):
    return num1 - num2

def multiply(num1, num2):
    return num1 * num2

def divide(num1, num2):
    return num1 // num2
```

Now if we wanted to run the code in these functions we could simply add some calls to the functions in our `calculator.py` file. But let's say we wanted to use these functions in other python files. We could simply copy and paste the code, but there is another way. When we want to use our functions in another file we can tell the Python interpreter that we want to access the code in another file i.e. the module.

### Using a Module

Let's create another Python file. In this Python file we are going to call the functions we have created in our `calculator.py` file.

```bash
touch runner.py
```

It is in this file we are going to make calls to the functions in our `calculator.py` file. So let's try calling the `add` function

```python
# runner.py

print(add(10, 20))
```

When we try to run our code we get an error:

```
NameError: name 'add' is not defined
```

This is because, at the moment the `runner.py` file has no knowledge of the `add` function and does not know which file it is in.

### Importing a Module

We need to tell our `runner.py` file where to get the code for the `add` function from. We need to get `runner.py` to 'import' the code from `calculator.py`. We use the `import` keyword followed by the name of our module, which is the name of the file containing the code we want to import but without the `.py` file extension.

```python
# runner.py
import calculator # ADDED

print(add(10, 20))
```

When we try to run our code we still get the error

```
NameError: name 'add' is not defined
```

Why? What if we had imported another module which contained a function called `add` - our code would not know which one to use. We want to tell our code to access the `add` function defined in our `calculator` module. We do this by __prepending__ our call to `add` with the name of the module i.e.:

```python
# runner.py
import calculator # ADDED

print(calculator.add(10, 20))
```

#### Other ways to import code

We can import our module so that we do not have to prepend the call to `add` with the function name. We do this by specifically saying which functions we want to import:

```python
# runner.py
from calculator import add # MODIFIED

print(add(10, 20))
```

Note that this only imports the `add` function from the `calculator` module. If want to access other functions in the calculator module we still need to import the `calculator` module and prepend the functions call with the name of the module e.g. if we wanted to call the `multiply` function:

```python
# runner.py
import calculator #ADDED
from calculator import add

print(add(10, 20))

print(calculator.multiply(10, 20)) # ADDED
```

If we want to import more than one function from a module we can import them as a comma separated list e.g.

```python
# runner.py
from calculator import add, multiply  #MODIFIED

print(add(10, 20))

print(multiply(10, 20)) # ADDED
```

If we want to import everything from a module without having to prepend things with the module name we can simply use `*` (for everything), rather than a comma-separated list

```python
# runner.py
from calculator import *  #MODIFIED

print(add(10, 20))

print(multiply(10, 20)) 
```

### Aliasing

When importing a module we can give the module another name, which we can use when accessing the module. To do this we use the `as` keyword e.g.

```python
#runner.py
import calculator as calc

print(calc.add(10, 20))
```

### Modules Can Contain Objects And Functions With the Same Name

By using modules we can have functions and objects with the same name in different modules. It is the module we import which determines which version we use. For example, we could have another module which contains a `divide` function but it would depend on the module we access to call it would determine which version is called. e.g.

```python
import calculator
import math

print(math.divide(5, 2))
print(calculator.divide(5, 2))

```

## Packages

At the moment, we are importing modules using files which are in the same folder. In larger projects we may have lots of files and this get a bit untidy so we often would like to gather related files into directories. In python, these directories are called packages.

```bash

mkdir modules
```

We also need to let Python know that this directory is being used for a package. To do this we create an empty file called `__init__.py` in that folder

```bash
touch modules/__init__.py
```

So let's now move our `calculator` module into the `modules` package:

```bash
mv calculator.py modules
```

If we try to run our code now we will get a `ModuleNotFoundError`. This is because we have moved our code into a package. When importing a module we now need to tell Python which package our module is by prepending the module name with the name of the package.

```python
import <PACKAGE>.<MODULE>
```

```python
# runner.py
from modules.calculator import *
```

Using packages means that we can actually have modules with the same name, as long as they are in different packages. It is the package we choose which determines which module with that name we import.

## Recap

What is a module?
<details>
<summary>Answer</summary>
A file which contains Python code
</details>
</br>

Why do we use modules?
<details>
<summary>Answer</summary>
To help organise our code
</details>
</br>

Which keyword do we use to get access to the code in an module?
<details>
<summary>Answer</summary>
The `import` keyword e.g. `import calculator`
</details>
</br>

How do we access the code imported from a module?
<details>
<summary>Answer</summary>
1. By putting the module name before the code e.g. `calculator.add`
2. By specifically saying that we want to import the code e.g. `from calculator import add`
</details>
</br>

What file do we need in our directory to let Python know that it is being used as a package?
<details>
<summary>Answer</summary>
An empty `__init__.py` file
</details>
</br>

How do we import a module from a package?
<details>
<summary>Answer</summary>

By putting the package name before the module e.g. `import modules.calculator`
</details>
</br>

## Conclusion

We have seen that modules are files containing Python code and that we use them to organise our code. We have also seen that, by using the `import` keyword in our Python files we can access code in other modules. 
We can also organise our modules into packages and be able to import modules from packages.

