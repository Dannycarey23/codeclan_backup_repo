# One to Many Lab

Your task is to model a Flask app which contains 2 classes that have a One To Many relationship.

- Authors and Books

## MVP

In your application you should be able to perform the following actions:

* View all Books along with detail of the Author (name/title/etc)
* Delete a Book

### Extensions

* Be able to create a new Book
* View a single Book

## Advanced Extensions

* Edit a Book
* Style the app using CSS


#### Guidance

* Plan your app with class diagrams, table diagrams, wireframes, etc

* You could write your models first, then add all the database code and finally all your routes and templates. Or..

* ... if you prefer you could create just enough in the back-end to move to the front-end. E.g. -

    - Create your models / tables
    - Create `save` methods
    - Seed some Authors and Books
    - Create `select_all`
    - Make the route to show all Books
    - Create template to show all Books
    - And repeat, moving from back-end to front-end as you complete CRUD

* Remember to seed the database in a console file.

* A `delete_all` method could be helpful to give you a clean slate each time you run your `console.py`




