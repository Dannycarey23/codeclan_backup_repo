# One to Many Intro

#### Objectives

* Explain what a one to many relationship is
* Demonstrate setting up a SQL database and tables with a foreign key

So far we have just been relating one model with one database table. However the power of relational databases like Postgres is that you can have relationships, or associations, between different tables, and then we can reflect this in our Python modelling.

Today we will be looking at a 'one-to-many' relationship. This is where one row in one table is related to many rows in another.

In last night's homework we were creating a database of tasks. However if a user were to be assigned several tasks, there's no way to keep a record of all the task this user has been assigned to. What if we separated out the 'name' column on the Tasks table to be their own table of Users?

### What's the relationship?

User has many Tasks

Task belongs to one User

What are the benefits of having this relationship?

* The user could go back and look at previous tasks to remember what they have done
* A user could create an account and not have to enter their name each time they create a task

...and many more. When there's a relationship between two things it makes sense to represent this in our database.

### Setup

We're going to use a start point for this, just to make sure everyone's code is the same and in a nice working state. 

> Give out the start code and give them a minute to look over it

You'll see that this is the same as the end point of last night's homework. We're basically going to be building on that.

## Create Users table

Let's set up our user's table in our SQL file. We're going to give each user a first name and a last name.

```sql
-- db/task_manager.sql

DROP TABLE IF EXISTS tasks;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  first_name VARCHAR(255),
  last_name VARCHAR(255)
);

CREATE TABLE tasks (
  id SERIAL PRIMARY KEY,
  description VARCHAR(255),
  -- delete the assignee from tasks
  duration INT,
  completed BOOLEAN
);

```

Now run the sql file:

```bash
# terminal 

psql -d task_manager -f db/task_manager.sql
```

So at the moment, our models are completely unrelated. Tasks know nothing about Users and Usrs know nothing about Tasks. How can we relate a user to a set of tasks?

We can use a foreign key in the tasks table. We do this with the `references` keyword, and specify which column of another table it is linked to. Every time a task is created, it should be given a relevant users's id that it is attached to.

```sql
-- db/task_manager.sql

CREATE TABLE tasks (
  id SERIAL PRIMARY KEY,
  description VARCHAR(255),
  duration INT,
  completed BOOLEAN,
  user_id INT NOT NULL REFERENCES users(id) -- ADDED
);

```

We are dropping the tasks table first because it references some users so it can't exist without the users table.

Revision from Monday: Why do we use the `references` keyword instead of just having a user_id that's an INT? It ties it to a primary key in another table, and makes sure we can't just write nonsense or reference a user that doesn't exist. It makes sure it's UNIQUE and NOT NULL.

## Models

Let's make a User model:

```bash
# terminal

touch models/user.py

```

```python
# models/user.py

class User:
    def __init__(self, first_name, last_name, id = None):
        self.first_name = first_name
        self.last_name = last_name
        self.id = id
```

So we now have our model. We want to use that model to communicate with our database, so now we need to create our repository file:

```bash
# terminal

touch repositories/user_repository.py

```

> TASK: Create the repository functions for the CRUD operations. Test using `console.py` 
> 
> WARNING: If you are using the code from last night as a start point, empty out your console.py and start again. Your code for making new Task objects will not work.

```python
#repositories/user_repository.py

from db.run_sql import run_sql

from models.user import User


def save(user):
    sql = "INSERT INTO users (first_name, last_name) VALUES (%s, %s) RETURNING *"
    values = [user.first_name, user.last_name]
    results = run_sql(sql, values)
    id = results[0]['id']
    user.id = id
    return user


def select_all():
    users = []

    sql = "SELECT * FROM users"
    results = run_sql(sql)

    for row in results:
        user = User(row['first_name'], row['last_name'], row['id'] )
        users.append(user)
    return users


def select(id):
    user = None
    sql = "SELECT * FROM users WHERE id = %s"
    values = [id]
    result = run_sql(sql, values)[0]

    if result is not None:
        user = User(result['first_name'], result['last_name'], result['id'] )
    return user


def delete_all():
    sql = "DELETE  FROM users"
    run_sql(sql)


def delete(id):
    sql = "DELETE  FROM users WHERE id = %s"
    values = [id]
    run_sql(sql, values)


def update(user):
    sql = "UPDATE users SET (first_name, last_name) = (%s, %s) WHERE id = %s"
    values = [user.first_name, user.last_name, user.id]
    run_sql(sql, values)


```

```python
#console.py

import pdb
from models.task import Task
from models.user import User

import repositories.task_repository as task_repository
import repositories.user_repository as user_repository

user_repository.delete_all()
task_repository.delete_all()

user1 = User("Jack", "Jarvis")
user_repository.save(user1)
user2 = User("Victor", "McDade")
user_repository.save(user2)

user_repository.select_all()

pdb.set_trace()
```

## Linking our Two Models

Now we have to edit our Task class to take in the user when assigning a user to a Task

```python
# models/task.py

class Task:

    def __init__(self, description, user, duration, completed = False,  id = None, ): # MODIFIED
        self.description = description
        self.user = user  # MODIFIED
        self.duration = duration
        self.completed = completed
        self.id = id

    def mark_complete(self):
        self.completed = True

```

Now if we want to save a task using the user id in our db we need to modify the `save` function in `task_repository`

Note that we will be getting the ID from the task's user and saving that to the `user_id` column in the database:

```python
# repositories/task_repository.py

def save(task):
    sql = "INSERT INTO tasks (description, user_id, duration, completed) VALUES (%s, %s, %s, %s) RETURNING *" # MODIFIED
    values = [task.description, task.user.id, task.duration, task.completed] # MODIFIED
    results = run_sql(sql, values)
    id = results[0]['id']
    task.id = id
    return task
```

Let's make sure this works in our `console.py`. If we want to create a task, we need the user's id. That means we need to create a user and save it to the database before we create a task and save it:

```python
# console.py

import pdb
from models.task import Task
from models.user import User

import repositories.task_repository as task_repository
import repositories.user_repository as user_repository

task_repository.delete_all()
user_repository.delete_all()

user1 = User("Jack", "Jarvis")
user_repository.save(user1)
user2 = User("Victor", "McDade")
user_repository.save(user2)

user_repository.select_all()

task = Task("Walk Dog", user1, 60)
task_repository.save(task)

pdb.set_trace()
```


> TASK: Change the other functions in `task_repository.py` to use the user id. 

> Note that you will need to find the user by using the user_repository.select and passing in the user_id that comes back from the database. You will also need to import the user_repository at the top of the file.

```python
# repositories/task_repository.py
from models.task import Task
from models.user import User
import user_repository 

...

def select_all():
    tasks = []

    sql = "SELECT * FROM tasks"
    results = run_sql(sql)

    for row in results:
        user = user_repository.select(row['user_id'])
        task = Task(row['description'], user, row['duration'], row['completed'], row['id'] ) # MODIFIED
        tasks.append(task)
    return tasks


def select(id):
    task = None
    sql = "SELECT * FROM tasks WHERE id = %s"
    values = [id]
    result = run_sql(sql, values)[0]

    if result is not None:
        user = user_repository.select(result['user_id'])
        task = Task(result['description'], user, result['duration'], result['completed'], result['id'] ) # MODIFIED
    return task


def delete_all():
    sql = "DELETE  FROM tasks"
    run_sql(sql)


def delete(id):
    sql = "DELETE  FROM tasks WHERE id = %s"
    values = [id]
    run_sql(sql, values)


def update(task):
    sql = "UPDATE tasks SET (description, user_id, duration, completed) = (%s, %s, %s, %s) WHERE id = %s" # MODIFIED
    values = [task.description, task.user.id, task.duration, task.completed, task.id] # MODIFIED
    run_sql(sql, values)

```

## Retrieving our user from tasks

So now we have a user and a task which should be related. The power of these databases is that they link data together, so we want to be able to make use of that in our Python code.

Because of the code we have writen we can simply call task.user to get back the user for a task. But what about getting back all tasks associated with a user?

As we are using our repositories to interact with the database, it would be great to be able to call `task_repository.tasks_for_user(user)` and see a list of all the tasks assigned to them.

What could we do to get back the tasks related to our user?

This function is actually going to look quite similar to our existing functions which access the database.

> TASK: Write the `.tasks_for_user` function for our `task_repository`

Some tips:

> Write these tips on the board for the class to refer to

`.tasks_for_user` method

Our User objects know their own `id`
We can use this in our SQL statement (use SqlRunner) to get back the data for all of their tasks.
Our `.tasks_for_user` method should return a *list* of Task objects, instances of the Task class


```python
# repositories/task_repository.py
def tasks_for_user(user):
    tasks = []

    sql = "SELECT * FROM tasks WHERE user_id = %s"
    values = [user.id]
    results = run_sql(sql, values)

    for row in results:
        task = Task(row['description'], user, row['duration'], row['completed'], row['id'] )
        tasks.append(task)
    return tasks
```


Now our Python models are inter-linked, we can get the `User` from the `Task` and we can get all the `Tasks` for a `User`. So now our Python models are taking full advantage of the relationship that we set up in our database.

## Summary

We have added another table `Users` to our database and linked it to our `Tasks` table so that there is a one-to-many relationship between users and tasks. We have modelled this relationship in our Python code and been able to get the user associated with a given task, as a User object, and a list of all the tasks, as Task objects, for a given user.