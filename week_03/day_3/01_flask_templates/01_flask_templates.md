# Flask Templates

**Duration: 90 minutes**

## Learning Objectives

- Understand how to use conditional rendering with Jinja
- Understand how we can use template inheritance to avoid duplicate code
- Add a new task to the list.

## Introduction

Now that we have Flask and templates set up we will continue working on the same application, and in particular, generate more elaborate web pages that have a complex structure and many dynamic components.

To do this we are going to expand our Templates.

> Download and open the start point. start the app and go to http://localhost:4999

So here we have the same task app with a slight difference. In the Task class we have added a boolean value to signify if the task is complete or not.

We are going to modify our tasks view to show an icon if the task is completed.

To do this we will use Jinja and conditional rendering.

## Conditional Rendering

With our tasks we may want to show if the task has been completed.

We can achieve this with conditionals. We will display a green tick (using UTF-8 code) if the tasks completed value is True.

As well as offering us the ability to code `for loops` inside our template we can also add `if` statements.

We can then use these if statements to decide whether specific HTML elements are rendered or not.

The syntax for this is as follows:

```html
{% if condition %}
<p>This will only render if condition is true</p>
{% endif %}
```

So in our case we want the green tickto render only if the task has been completed. So if `task.done == True`.

Let's add this in our template!

```html
<!-- index.html -->

<html>
  <head>
    <title>{{ title }}</title>
  </head>
  <body>
    <h1>{{ title }} !!!</h1>
    {% for task in tasks %}
    <div>
      <p>
        {{ task.title }}: <b>{{ task.description }}</b> {% if task.done %}
        <!-- ADDED -->
        <span> &#9989;</span>
        <!-- ADDED -->
        {% endif %}
        <!-- ADDED -->
      </p>
    </div>
    {% endfor %}
  </body>
</html>
```

So now we should be able to see a green tick next to all the tasks that have been completed!

## Template Inheritance

Most web applications these days have a navigation bar at the top of the page with a few frequently used links, such as a link to edit your profile, to login, logout, etc.

We **could** add a navigation bar to the index.html template with some more HTML, but what happens if we add more pages to the site and want the same nav bar in each. We don't really want to have several copies of the navigation bar in many HTML templates, it is a good practice to not repeat yourself if that is possible.

`Jinja2` has a template inheritance feature that specifically addresses this problem. This allows us to move the parts of the view that are common to all templates to a base template, from which all other templates extend.

Let's create a new template called `base.html` in the templates folder.

```bash
touch templates/base.html
```

And we will move the common view code into this template. this will also have our Navigation. For now we will just have a link to the home page.

To define where the view from our templates will go we use another Jinja2 construct called a block.

Blocks are given a unique name, which templates can reference when they provide their content.

We will call this block `content`.

```html
<!--base.html -->

<html>
  <head>
    <title>{{ title }}</title>
  </head>
  <body>
    <ul>
      <li><a href="/tasks">Home</a></li>
    </ul>
    <hr />
    {% block content %} {% endblock %}
  </body>
</html>
```

Now we can simplify index.html by making it inherit from `base.html`:

```html
<!-- index.html -->

{% extends "base.html" %} {% block content %}
<h1>{{ title }}</h1>
{% for task in tasks %}
<div>
  <p>
    {{ task.title }}: <b>{{ task.description }}</b>
    {% if task.done %}
    <span> &#9989;</span>
    {% endif %}
  </p>
</div>
{% endfor %} {% endblock %}
```

Our `index.html` now only has the main content of this specific page.

The extends statement establishes the inheritance link between the two templates, so that Jinja2 knows that when it is asked to render index.html it needs to embed it inside base.html.

The two templates have matching block statements with name content, and this is how Jinja2 knows how to combine the two templates into one.

So if we create additional pages for the application, we can create them as templates that inherit from the same `base.html` template, and all the pages of the application share the same look and feel without duplication.

### Adding a new task

We can also add a new task to our list using a form. Again, as we aren't using databases these won't persist if we stop the server but will show the concept of getting data from a form.

Let's start by adding a form to the top of our list. This form will make a `POST` request to a route we will code up later.

> To follow the RESTful conventions this route will also be `/tasks`. But since this is a `POST` request it will not conflict with our other route which, by default, uses `GET`.

```html
<!-- index.html -->

{% extends "base.html" %} 
{% block content %}
<h1>{{ title }}</h1>

<form action="/tasks" method="post">
  <!-- ADDED -->
  <label for="title">Title</label>
  <input type="text" name="title" id="title" />
  <label for="description">Description</label>
  <textarea name="description" id="description" rows="2" cols="30"></textarea>
  <input type="submit" value="Add Task" />
</form>

{% for task in tasks %}
<div>
  <p>
    {{ task.title }}: <b>{{ task.description }}</b>
    {% if task.done %}
    <span> &#9989;</span>
    {% endif %}
  </p>
</div>
{% endfor %} 
{% endblock %}
```

So when we submit the form we will send a post request through which our controller file will handle.

In our new view we want to:

1. Create a new task using the data from the form
2. Add the new task
3. Render the updated task list.

Let's start by telling the controller that we will have a post request coming through.

As this needs to be a POST method we will inform the decorator of this. We can declare which methods are used for this route. This is passed as a list. We only want POST for this route. For now we will just return a string to make sure we can get this working.

```python
# tasks_controller.py

@tasks_blueprint.route('/tasks', methods=['POST'])
def add_task():
  return "Done"
```

Next we need to access the form data to create the new task.

To access the form in our `tasks_controller.py` file we will need to get access to the request that is being made.

Fortunately for us Flask makes that simple. Flask comes with a request object that we can import into our file.

```python
# tasks_controller.py

from flask import render_template, request # MODIFIED
```

And now in our route we can access the form by calling request.form.

Let's print it out and see what we get.

```python
#tasks_controller.py

@tasks_blueprint.route('/tasks', methods=['POST'])
def add_task():
  print(request.form)
  return 'Done'
```

IF we submit the form and look at the terminal we can see that the request.form is a type of dictionary, `ImmutableMultiDict`. The good news is that we can access the data like a normal dictionary. The keys in the dictionary relate to the `name` that we gave the input. So..

```html
<input type="text" name="name" />
```

Would give us a key of `name` in the dictionary and the value would be whatever the user typed in.

We should see the form values as key value pairs. So we can access these using the keys and create a new task.

We will need to import the `Task` class at the top of the file as well.

```python
#tasks_controller.py

from models.task_list import tasks
from models.task import Task # ADDED

@tasks_blueprint.route('/tasks', methods=['POST'])
def add_task():
  task_title = request.form['title'] # ADDED
  task_desc = request.form['description']
  new_task = Task(task_title, task_desc, False)

  return 'Done'
```

Now we can add the task to our task list. In the task model we will add a function to add a new task to the list.

```python
# models/task_list.py

def add_new_task(task):
    tasks.append(task)

```

Now we can import this function into our controller and call it in our route.

```python
#tasks_controller.py

from models.task_list import tasks, add_new_task # MODIFIED

... AS BEFORE

@tasks_blueprint.route('/tasks', methods=['POST'])
def add_task():
  task_title = request.form['title'] # ADDED
  task_desc = request.form['description']
  new_task = Task(task_title, task_desc, False)
  add_new_task(new_task) # ADDED
  return 'Done'
```

Now that we have added it our tasks should be updated. We can now re-use the index template and re-render the list.

```python
#tasks_controller.py

@tasks_blueprint.route('/tasks', methods=['POST'])
def add_task():

  task_title = request.form['title'] # ADDED
  task_desc = request.form['description']
  new_task = Task(task_title, task_desc, False)
  add_new_task(new_task)
  return render_template('index.html', title='Home', tasks=tasks) # MODIFIED
```

Now if we use the form to add the task we can see it in our list.

Unfortunately this isn't persisted so if we restart the server it will disappear.

Next week we will show you how we would save to a database so that our data will be persisted even if the server stops running.

## Summary

Templates allow us to separate the logic and presentation of our app.

We can pass any specific content of the back end to the view by creating key-value pairs passed into the render_template function.

These can be referenced inside our templates.

Jinja2 allows us to have more control in our templates with if and for loops.

Templates can inherit other templates to allow shared view content across multiple pages without duplicating the code.
