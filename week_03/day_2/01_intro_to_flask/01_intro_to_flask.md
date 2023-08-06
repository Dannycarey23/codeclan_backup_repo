# Intro to Flask

**Duration: 60 minutes**

## Learning Objectives

- Be able to use pip to install packages
- Understand how to set up lightweight server with Flask
- Set up a basic Flask project.

## Introduction

If you're developing a web app in Python, chances are you will be using a framework.

A framework "is a code library that makes a developer's life easier when building reliable, scalable, and maintainable web applications" by providing reusable code or extensions for common operations. There are a number of frameworks for Python, including Flask, Tornado, Pyramid, and Django.

Exactly what is implemented in the framework and what is left for the developer to write varies from framework to framework. Flask is a very lightweight framework compared to the likes of and Django. The biggest difference between Flask and Django is:

- Flask implements a bare-minimum and leaves the bells and whistles to add-ons or to the developer

- Flask is also easy to get started with as a beginner because there is little boilerplate code needed for getting a simple app up and running.

- Django follows a "batteries included" philosophy and gives you a lot more out of the box.

We will be looking at Flask and setting up a simple web application.

### Initial setup

In order to get our application up and running, there are a few steps to follow.

```bash
# terminal

mkdir my_web_app
cd my_web_app
```

### Pip

Now we can start to use the power of pip! Pip is a package manager that allows us to use all sorts of external packages in our apps.

We want to be using pip for python3 so we will use the command `pip3` to install our dependancies.

Since we're going to make a simple web server, we're going to use [Flask](http://flask.pocoo.org/), a micro-framework that is similar to Ruby's Sinatra, or JavaScript's Express.

The first thing we'll do is download and install Flask:

```bash
# terminal

pip3 install Flask
```

Now that we have Flask set up, let's set up a simple base structure for our app and make sure that we can connect to the server.

### A Basic Webserver

Let's create a file called app.py. This will host the application. Make sure you are in the `my_web_app` directory and then run the following command:

```bash
# terminal

touch app.py
```

Open the project in VS code and go to `app.py` and add the following code

```python
# app.py

from flask import Flask

app = Flask(__name__)

```

The code above simply creates the application object as an instance of class Flask imported from the flask package.

The app variable is used as an instance of Flask. Once we have that instance we should be able to have flask run our server and allow us to connect to it via our browser.

The `__name__` variable passed to the Flask class is a Python predefined variable, which is set to the name of the module in which it is used.

Flask uses the location of the module passed here as a starting point when it needs to load associated resources such as template files.

Passing `__name__` is almost always going to configure Flask in the correct way.

#### Testing our app

We've already written enough code to start a webserver, let's see if we can make a request to it -

```bash
# terminal

flask run

# * Running on http://127.0.0.1:5000

```

Now in Chrome we can go to http://localhost:5000 (localhost is an alias (AKA domain name) to our local machine which has an IP address of 127.0.0.1)

Oh oh -

![403 Error](/week_03/day_3/01_intro_to_flask/403.png)

Recent versions of macOS already use Flask's default port (5000) and so we need to specify a different one. We'll do this with a environment variable, a variable much like a Python one, but which takes effect in the terminal.

```bash
# terminal

export FLASK_RUN_PORT=4999
flask run

# * Running on http://127.0.0.1:4999
```

If we try this new url in Chrome we'll get a response from the webserver - **Not Found (404)**. But this is the expected error as we've not defined any routes - in this case a route for the 'homepage' of our site.

### Our first Route

Routes are the different URLs that the application implements. In Flask, handlers for the routes are written as Python functions, called view functions.

This will deal with requests that come in to the application and determine what view functions will run based on the url that the user requests.

View functions are mapped to one or more URLs so that Flask knows what logic to execute when a client requests a given URL

We'll add a new 'homepage' route at `/` and below write the view function that will execute when we request that route in the browser.

```python
# app.py

# ⬇️ ADDED
@app.route('/')
def index():
    return "Hello, World!"
```

This view function will just return a greeting as a string.

The `@app.route` line above the function is what is known as a decorator.

Decorators in Python are used to add extra functionality to a function without having to write that functionality ourselves.

Flask comes with several in-built decorators that we can leverage to make our app run smoothly.

> We **could** write our own decorators but to do that we need an understanding of higher order functions and callbacks. (More on that later though!)

In our case, the `@app.route` decorator creates an association between the URL and the function.

In this example the decorator associates the URL `/` to this function. This means that when a web browser requests this URL, Flask is going to execute this function and pass the return value of it back to the browser as a response. If this does not make complete sense yet, it will in a little bit when you run this application.

If we restart our server -

```bash
# terminal

# CTRL-C

flask run
```

Now if we refresh our browser we should see Hello World! in the browser window!

But it's a bit strange just to return an unformatted string, our browser expects HTML. Let's update our code

```python
@app.route('/')
def index():
    return f"<h1>Hello {name}</h1>" # 📝 UPDATED
```

And restart our server -

```
# terminal

# CTRL-C

flask run
```

If we refresh our browser now, we'll see our Hello World as an `h1`.

### A better development experience

It's getting a bit annoying that we have to restart our webserver every time we make a change to our code. Fortunately we have the option to run in debug mode and any time we save the webserver will restart itself! We'll also get helpful error messages to help us debug our code!

Flask allows you to register environment variables that you want to be automatically imported when you run the flask command.

To use this option we'll have to install the `python-dotenv` package:

```bash
# terminal

pip3 install python-dotenv
```

Then we can just write the environment variable names and values in a .flaskenv file in the top-level directory of the project:

```bash
# terminal

touch .flaskenv
```

```bash
# .flaskenv

FLASK_DEBUG=true
```

Additionally...since environment variables aren't retained across terminal sessions, you may find it a bit tedious to always have to set the `FLASK_RUN_PORT` environment variable when you open a new terminal window. We can add that to the `.flaskenv` file too.

```bash
# .flaskenv

FLASK_DEBUG=true
FLASK_RUN_PORT=4999  # ⬅️ ADDED
```

If we refresh the browser nothing happens. We have to restart the server in terminal one last time to pick up this configuration change. Once we've restarted we should see -

```bash

# terminal

 * Debug mode: on
WARNING: This is a development server. Do not use it in a production deployment. Use a production WSGI server instead.
 * Running on http://127.0.0.1:4999
Press CTRL+C to quit
 * Restarting with stat
 * Debugger is active!
```

> **Task**: Make a small change to the HTML your `index` route returns and refresh to see that the server has restarted and picked up the change.

### Route parameters

We may also want to pass in some parameters from our url.

For, example we may take in a name and return a string of "Hello " plus the name

To do this we need to declare these path variables in our route using `<>` arrows with the name of our variable inside.

We then pass that variable to the function.

Let's create a new route.

```python
# app.py

...

# ⬇️ ADDED
@app.route('/<name>')
def greet(name):
    return f"<h1>Hello {name}</h1>"
```

Now if we go to `http://localhost:4999/Bob` we should see `Hello Bob` displaying!

Try hitting the url with different names. i.e. `http://localhost:4999/Alice`, etc

Regardless of the name we use in the url we always hit the greet route and the name is used to build up the string.

## Recap

<details>
<summary>Why do we use frameworks when developing apps?</summary>
  Frameworks provide reusable code or extensions for common operations.
</details>

<details>
<summary>What are the purpose of routes?</summary>
  To deal with requests that come in to the application and determine what view functions will run based on the url
</details>

<details>
<summary>How do we tell Flask what port the application should start on?</summary>
  We define a FLASK_RUN_PORT environment variable
</details>

<details>
<summary>How do we tell Flask what to automatically restart the application when we save?</summary>
  We set the FLASK_DEBUG environment variable to true
</details>

## Summary

Flask is a simple, lightweight server that allows us to quickly set up web applications and gives us the tools to create routes and run flask instances from the terminal.
