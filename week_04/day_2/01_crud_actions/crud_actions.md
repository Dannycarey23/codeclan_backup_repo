# Completing the CRUD actions

We currently have one function in our repository called `select_all` that selects all the Task objects from our database table. Now we want to complete the rest of our CRUD actions. 

## Saving a new Task

So let's create our next function. We'll create a `save` method. This will take in a `Task` object and store its details in our `task_manager` database. We are going to use our `run_sql` function so we will need to import it.

```python
# task_repository.py

from db.run_sql import run_sql

# same as before

def save(task):

```

We can now create the SQL for our `save` function. As we are saving a new item to the database we will use an `INSERT` statement. 

One way to create our SQL would be to create a formatted string, using string interpolation to pass in the relevant data from our task object:

```python
# task_repository.py

from db.run_sql import run_sql

def save(task):
    sql = f"INSERT INTO tasks (description, assignee, duration, completed) VALUES ( '{task.description}', '{task.assignee}', {task.duration}, {task.completed} )"  # ADDED
```

> NOTE: duration and completed don't need double quotes

#### Prepared statements

Let's stop for a second! As much as we'd love to trust our fellow human beings that they won't commit anything nasty against our database, the reality is a bit grimmer.

Basically, an SQL injection attack is a type of attack (whoa) where the attacker's intention is to either retrieve or delete data from databases. We're not going to show you how to execute an SQL injection attack, let's just accept the fact that it's not that difficult, and we should protect our code from such attacks.

An SQL injection attack could be executed like this:

```python
#console.py

#same as before

task_3 = Task("Fix Car', 'Jack' ,'20", "False'); DELETE FROM tasks; --", 120)

task_repository.save(task_3)

```

SQL injections happen when a method accepts any form of input from the user without sanitising said input. To protect agains such attacks, we can use something called a prepared statement.

A prepared statement is essentially an SQL query that has a 2 step execution, rather than one. First, we prepare a statement and give it a name, which is essentially a string, and the SQL statement we want to execute. Instead of giving the values directly with the SQL statement, however, we only give it placeholders, indicating the number of values we want to insert in the SQL query.

Once the statement is prepared, we want to execute said prepared statement, this time providing the values too.

This has a number of benefits:

* By sanitising the input, we defend against SQL injection attacks
* This also let's us add apostrophes in our text values (imagine what would happen to a value like `'Bob's Guitars'` in a SQL query!)
* Plus once efficiency is a main concern, for mass updates/saves, a prepared statement is considerably faster.

Luckily, the psycopg2 library gives us an easy way of creating prepared statements!

```python
# repositories/task_repository.py

from db.run_sql import run_sql

def save(task):
    sql = "INSERT INTO tasks (description, assignee, duration, completed) VALUES (%s, %s, %s, %s)"
    values = [task.description, task.assignee, task.duration, task.completed]
```

Instead of providing the interpolated attributes of our instance, we are just flagging for PSQL that there will be 4 values we'd like to insert, indicating it with the `%s`.

Once the statement with the placeholders are prepared, we execute it by providing it the same name as the one we gave it when we prepared it, plus the values as an list.
Be careful: the values in the list should be in the same order as the placeholders indicate! In our case: `task.description, task.assignee, task.duration, task.completed`!

We can then call our `run_sql` function, passing in both `sql` and `values`

```python
# repositories/task_repository.py
from db.run_sql import run_sql

def save(task):
    sql = "INSERT INTO tasks (description, assignee, duration, completed) VALUES (%s, %s, %s, %s)"
    values = [task.description, task.assignee, task.duration, task.completed]
    run_sql(sql, values)
```

We can do this for one of our tasks in our console file.

```python
# console.py
import repositories.task_repository as task_repository # ADDED

task_1 = Task("Go for run", "Jack Jarvis", 20)

task_repository.save(task_1) # ADDED

result = task_repository.select_all()

for task in result:
    print(task.__dict__)

pdb.set_trace()
```

Run console.py from terminal. Exit from pdb and let's access our database.

In terminal:

```sql
psql -d task_manager
select * from tasks;
```

Brilliant, we have mapped a Python instance to a SQL table row.

Note that only `task_1` has been saved.

This is fine for when we get all of the Tasks in `select_all()` but we would also like to update the object - it currently doesn't have an id. 

```python
# repositories/task_repository.py

def save(task):
    sql = "INSERT INTO tasks (description, assignee, duration, completed) VALUES (%s, %s, %s, %s) RETURNING *"  # MODIFIED
    values = [task.description, task.assignee, task.duration, task.completed]
    results = run_sql(sql, values)  # MODIFIED
    id = results[0]['id']           # ADDED
    task.id = id                    # ADDED
    return task                     # ADDED
```

Remember, the ID of an object is extremely useful - it's the only unique identifier we have between the rows.


### Getting one particular task 

There will be cases where we want to get one particular row back from the database. We use a `SELECT` SQL statement for this but also need a `WHERE` clause to get a unique row, so what is unique in each row we could use to search on? The ID.

The `run_sql` function returns a list of rows (even if there is only one matching row) so if `run_sql` does not return `None` (i.e. no matching rows found) then we just want the first item in the list returned. We can then use the data in that row to create a task object which the `select` function can return

```python
# repositories/task_repository.py

def select(id):
    task = None
    sql = "SELECT * FROM tasks WHERE id = %s"  
    values = [id] 
    results = run_sql(sql, values)
     
    # checking if the list returned by `run_sql(sql, values)` is empty. Empty lists are 'fasly' 
    # Could alternativly have..
    # if len(results) > 0 
    if results:
        result = results[0]
        task = Task(result['description'], result['assignee'], result['duration'], result['completed'], result['id'] )
    return task
```

## Deleting All

Every time we run our console file, we are adding a new task. Let's clean out the database every time we run it!

```python
# repositories/task_repository.py

def delete_all():
    sql = "DELETE  FROM tasks" 
    run_sql(sql)

```

```python
# console.py

import pdb 
from models.task import Task
import repositories.task_repository as task_repository 


task_repository.delete_all()  # ADDED

# AS BEFORE

```

## Deleting One

As well as deleting all tasks, we probably also want to be able to delete a single task. Given a single task object in the database has an id then we can delete it from the database using that id.

```python
# repositories/task_repository.py

def delete(id):
    sql = "DELETE  FROM tasks WHERE id = %s" 
    values = [id]
    run_sql(sql, values)
```

## Updating

Lastly, we might want to update a model. When we do changes like this:

```python
# console.rb

task_1.mark_complete()
```

This is sitting temporarily on the little model in memory. No SQL has run to cause the database to update the entries, so it gets lost if we exit pdb. Therefore we need to create an `update` function, which takes in a task object and updates the relevant row in the database:

```python
# repositories/task_repository.py

def update(task):
    sql = "UPDATE tasks SET (description, assignee, duration, completed) = (%s, %s, %s, %s) WHERE id = %s"
    values = [task.description, task.assignee, task.duration, task.completed, task.id]
    run_sql(sql, values) 

```
Now let's add to our console.py to call our update method so that our database is updated with this new information.

```python
# console.rb

task_1.mark_complete()
task_repository.update(task_1)
```

## Conclusion

We are now able to map instances of our task objects written in Python to rows in our SQL database. We can write SQL statements in our Python code and using the `psycopg2` library, have our SQL statements run on the database.
