# Flask MVC

**Duration: 60 minutes**

## Learning Objectives

- Understand how to set up templates / Blueprints with Flask
- Understand how Flask's architecture relates to MVC
- Create Views and Controllers in Flask

## Introduction

Now that we have Flask set up we will continue working on the same application, and in particular, generate more elaborate web pages that have a complex structure and many dynamic components.

To do this we are going to use Templates and Blueprints

> Download and open the start point. start the app and go to http://localhost:4999

We have a start point for a simple task list. There are 2 files in the model folder. A `task` class which stores a title, description and a boolean value to signify if the task is complete or not.

We also have a `task_list` script that gives us some dummy data.

We are going to code up our route to view all of the tasks and have them rendered using an HTML template.

### Model-View-Controller

Following the MVC pattern we want to break down the responsibilities of our application -

- **M**odel - the `list` of `tasks` that makes up the data of our application (and in a more complicated app - logic too)
- **V**iew - Flask Templates - what Flask uses to create the pages a user interacts with
- **C**ontroller - The intermediary between Model and View - processes requests, reads/updates the model. Defined as a set of routes.

### Naming routes

So far the view function in the application returns a simple Hello World string. What we **could** do now is expand that returned string into a complete HTML page that displays the tasks.

But it makes no real sense to have the route to this is just `/`. What we should be doing is following what is known as RESTful routing. This is where we define routes for specific resources and actions we want to perform.

So for example the resource we want to request is all of the tasks to be displayed. So our route should be something like `/tasks`. This makes sense as we are requesting the tasks. Think about the BBC website. When we want to get the news we go to `bbc.co.uk/news`. If we want the weather we go to `bbc.co.uk/weather`. RESTful routes allow us to structure our web app in a logical way. There are defined RESTful routes depending on what you want to do (i.e. view all, add new, edit, delete, etc). These are detailed below but we will talk through them all in due course.

| Action     | Route     | HTTP method |
| ---------- | --------- | ----------- |
| View all   | /tasks    | GET         |
| View one   | /tasks/id | GET         |
| Create     | /tasks    | POST        |
| Update     | /tasks/id | PUT         |
| Delete one | /tasks/id | DELETE      |

<br>

You will notice that some of the routes follow the same pattern (i.e. `/tasks`). This is acceptable as the routes use different HTTP methods (GET/POST) so there is no conflict. If we had 2 routes with the same pattern and HTTP method then we would start to get bugs in our app. (Flask would always go to the first coded route in the controller.)

### Our tasks Controller - (Controller)

Rather than write all our routes in `app.py` we'll start to create controllers - one for each resource in our app. In this app we have one resource - `tasks`. So we'll have a `tasks_controller`

Let's make a folder to hold our controllers, and create our `tasks_controller` -

```bash
# terminal

mkdir controllers
cd controllers
touch tasks_controller
```

Flask includes a [Blueprint](https://flask.palletsprojects.com/en/2.3.x/tutorial/views/) class which helps us implement the functionality often associated with controllers in other frameworks. We can pretty much consider Blueprints to be Flask's take on Controllers in the MVC pattern. Let's make use of `Blueprint` by importing it -

```python
# controllers/tasks_controller.py

from flask import Blueprint
```

Let's make a blueprint for our tasks -

```python
# controllers/tasks_controller.py

# ADDED ⬇️
tasks_blueprint = Blueprint("tasks", __name__)
```

Much like the `Flask` class The `Blueprint` constructor expects to be passed the current module name to help it find related resources.

We can now attach routes to the blueprint in much the same way as we did with `app`

```python
# controllers/tasks_controller.py

...
# ADDED ⬇️
@tasks_blueprint.route("/tasks")
def index():
  return "<h1>I will show all the tasks</h1>"
```

If we try and access `http://localhost:4999/tasks` in the browser now, well get a 404 error. But this makes sense, `flask run` knows to run `app.py` but there's no reference to the `tasks_controller` in `app.py`.

We need to import the controller -

```python
# app.py

from flask import Flask
from controllers.tasks_controller import tasks_blueprint # ⬅️ ADDED
```

And register it with the `app` -

```python
# app.py

...
app = Flask(__name__)
app.register_blueprint(tasks_blueprint) # ⬅️ ADDED
```

If we refresh now we'll see our rendered HTML.

### Templates - (View)

While returning an HTML string from our view functions works, it will quickly become unwieldy. Enter [Templates](https://flask.palletsprojects.com/en/2.3.x/templating/).

In Flask, templates are a mix of HTML and Jinja2. Jinja is templating language that brings dynamism to HTML. Jinja's Python-like syntax allows us to write simple code like loops and conditionals. Code that is run by Flask to create HTML. The value of this will become clear shortly...

Flask expects our templates to be stored in a templates folder that is inside the application package. Create a templates directory in the root of your application to store the templates:

> Code along from this point, stopping server (ctrl+c) if it is running

```bash
mkdir templates
```

And in here let's create a new template for the index page.

```bash
touch templates/index.html
```

Now we will add some HTML code in this template.

```jinja
<!-- templates/index.html -->

<html>
  <head>
    <title>{{ title }}</title>
  </head>
  <body>
    <h1>{{ title }} !!!</h1>
  </body>
</html>
```

This is mostly a standard HTML page. The interesting thing in this page is that there are a couple of placeholders for the dynamic content, enclosed in `{{ ... }}` delimiters. These placeholders represent the parts of the page that are variable and will only be known at runtime.

Now the view function can be simplified.

To use this template we will need to import a function from Flask called `render_template`.

This function takes a template filename and a series of template arguments. It returns the same template, but with all the placeholders in it replaced with the values stored in the arguments.

```python
# controllers/tasks_controller.py

from flask import render_template # ⬅️ ADDED
from app import app

tasks_blueprint = Blueprint("tasks", __name__)

@tasks_blueprint.route("/tasks")
def index():
    return render_template('index.html', title="My Task List") # 📝 MODIFIED
```

Now if we start the server and go to http://localhost:4999/tasks we should see the tab title change.

### More Dynamic Content

It would be nice if the user could see their task list on `/tasks`, so we will extend the application to support that.

We will import the `task_list` (**Model**) mentioned earlier into the controller (**Controller**) and pass it to the page template (**View**)

```python
# controllers/tasks_controller.py

...

from models.task_list import tasks # ⬅️ ADDED

...

def index():
    return render_template('index.html', title="My Task List", tasks=tasks) # 📝 MODIFIED
```

On the template side we have to solve a new problem. We want to go through the `task_list` and _for_ each task render an HTML element to represent that task.

For this type of problem, `Jinja2` offers a `for` loop control structure.

### Loops

You have seen how Jinja2 replaces placeholders with actual values during rendering, but this is just one of many powerful operations Jinja2 supports in template files.

Templates also support control flow statements, such as if statements and for loops.

These are coded inside blocks - in this case a `for`, `endfor`. They use a slightly different syntax with the innermost curly brackets replaced by `%`

```jinja
{% for element in list %}
  ...
{% endfor }
```

These statements are **NOT** rendered to the final HTML. They are used solely to control the flow of code. But we do want to use `{{ ... }}` to render each task -

```jinja
<!-- templates/index.html -->
...

<h1>{{ title }} !!!</h1>
<!-- ADDED ⬇️ -->
<ul>
  {% for task in tasks %}
    <li>{{ task.title }}: <b>{{ task.description }}</li>
  {% endfor %}
</ul>

...
```

So now that we have passed the list of tasks to the template we can access it and loop over each task to display a new li for each one. This will work regardless of how many tasks are passed through.

## Recap

<details>
<summary>What folder must our HTML files go inside?</summary>
  templates
</details>

<details>
<summary>Why use a RESTful route convention?</summary>
  To deal with requests in a structured and consistent way. 
</details>

<details>
<summary>What is the syntax for looping inside a template?</summary>
  <pre>
    <% for element in list %>
    ...
    <% endfor %>
  </pre>
</details>

## Summary

Templates allow us to structure our views in a well organised way using HTML.

Jinja allows us to be more dynamic in our content by giving us the ability to pass through variables from the controller to be rendered. We can also use Jinja to write Python-like code such as for loops.
