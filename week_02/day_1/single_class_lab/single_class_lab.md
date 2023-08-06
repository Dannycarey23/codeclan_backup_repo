# Classes Lab 

In this lab, we'd like you to make some classes of your own. Below we've outlined a few scenarios to be modelled as classes. 

## Learning Objectives

- Be able to create your own class
- Be able to create objects
- Be able to add properties to a class
- Be able to access and modify properties
- Be able to add methods to a class
- Be able to modify the value of properties in methods

### Part A

For this part we want you to make a class that represents a CodeClan student.

The files for this section can be found in `single_class_lab_start_code/student_class`

To run: `python3 app.py`. You will initially get some errors. Follow the error messages as you write your code and run `app.py` frequently.

You should write your code in the the `src/student.py` file.


##### Tasks

- Create a class called Student that has the properties `name` (`str`) and `cohort` (`str`).
- Create an `__init__` method that takes in a name (`str`) and a cohort (`str` - e.g "E41", "G19", etc) to initialise the properties when a new student is created.
- Create a `talk` method that gets the student to talk, returning "I can talk!".
- Create a method, `say_favourite_language` that takes in a students favourite programming language and returns it as part of a string (eg. `student.say_favourite_language("Python")` -> "I love Python").

### Part B

Now we would like you to make a class that represents a sports team.

The files for this section can be found in `single_class_lab_start_code/team_class`

To run: `python3 app.py`. You will initially get some errors. Follow the error messages as you write your code and run `app.py` frequently.

You should write your code in the the `src/team.py` file.


##### Tasks

- Create a class called Team that has the properties properties `name` (`str`), `players` (list of `str`s) and a `coach` (`str`).
- Create an `__init__` method that takes in a name (`str`), a list of player names (as `str`s) and a coach(`str`) to initialise the properties when a new team is created.
- Create a method `add_player` that takes in a string of a new players's name and adds that new player to the players list.
- Add a method `has_player` that takes in a string of a player's name and checks to see if they are in the players list. It should return `True` if the player's name is in the list and `False` otherwise.

### Extension 

- Add a points property into your class that starts at 0 without adding it as a parameter inside your __init__ function. 

- Create a method, `play_game` that takes in whether the team has won(`True`) or lost(`False`) and adds 3 to the points property for a win.



### Part C

Create a class diagram for each of the classes you've written: `Student` and `Team`. Make sure you include the class name, property names and types, and method names and any parameter and return types.
