# Many to many associations

## Objectives

* Have an awareness of the different types of relationships that exist in a relational database
* Describe and provide an example of a many to many relationship and when we would use one
* Draw and 'model' many to many relationship

## Recap

> DRAW ON BOARD:

Until now we have learned 2 associations:

* one to one; for example a Person and NI number
* one to many; Team has many players; Bank has many accounts...

There is one other relationship we need to learn about.

## Many to many

When modelling data there will be occasions when one or more rows in a table are associated with one or more rows in another table.

For example:

> DRAW ON BOARD:

Let's say we are going to build a review site for travellers to show locations that they have visited and include reviews. A location can be visited by many users, and a user can visit many locations. I could visit Paris, London and New York, and Paris could be visited by me, you and someone else.

User:

* name

Location:

* name
* category (e.g. restaurants, hotels, attractions, museums)

When we have a many to many association like this we require a third table in the mix. We call this a join table. A join table will have two foreign keys; one for each model. It will also have its own ID, and can contain extra fields.

So we need a third model. General convention is that if there is no better name for it, we give it the name table1_table2. For our example, 'visits' is probably a good name, but we could call it 'users_locations'.

Visit:

* id
* user_id
* location_id
* review

Here's the twist.. we're going to make this a bit more fun and imagine this review site is for fantasy characters, and it's going to be called QuestAdvisor.

## Models and our database

> Hand out Quest_Advisor_start code.

Let the students have a read through the code for 15 minutes then talk through the structure.

What's missing?

The SQL to create our visits table. It needs TWO foreign keys, let's write it:

```sql
-- quest_advisor.sql

CREATE TABLE visits (
  id SERIAL PRIMARY KEY,
  user_id INT REFERENCES users(id) ON DELETE CASCADE,
  location_id INT REFERENCES locations(id) ON DELETE CASCADE,
  review TEXT
);

-- at top
DROP TABLE visits;
```

What is this ON DELETE CASCADE doing? It means that if an entry in the linked table which matches the id of this foreign key is deleted, all of its corresponding records are deleted. E.g. if a user is deleted, all of the visits with their user_id are deleted too.

Now let's start by creating our database:

```bash
#terminal

dropdb quest_advisor
createdb quest_advisor
psql -d quest_advisor -f db/quest_advisor.sql
```

## In-depth with the join model

Now that we have nice and DRY code, let's look at how to improve our join model!

Right now, if you look at a visit page, you can see useful information about it. We can see the user, the location and the review for each visit. this is because we have direct access to these properties through our Visit model. 

But... if you look at a single location or user at the moment we can only really see the basic details of each. (i.e. name, category, etc.)

Wouldn't it be nice to get some more details about where the users have been or who has visited a particular location?

## Mapping our join

In order to do this we will have to use a join to get the information from each table using the visits table. This is because there is no direct link between users and locations (i.e. not location_id foregn key in the users table.). 

Therefore we can't directly get location data for a user. We have to go through the visit table to find all locations for a user and vice versa.

To do this we will need a couple of methods in the repective repositories. 


* user_repository.locations(user) would return all the locations that person has visited
* location_repository.users(location) would return all users who have visited there

> DRAW ON BOARD:

Let's first write the SQL in the postgres terminal and work it out.

First, we need a valid user id. We can do this when we run our console.py. For example to get the first user:

```python
#  console.py

print(user_repository.select_all()[0].id)
```

And run the console file in terminal

```bash
# terminal

python3 console.py
```

Take a note of a valid user id from your database.

> Quick review of inner joins. Show the join below without the 'where' part to show the whole joined up table that has been created.

```bash
#terminal
psql -d quest_advisor
```

```sql
SELECT locations.*
FROM locations
INNER JOIN visits
ON visits.location_id = locations.id
WHERE user_id = 1
```

Cool now we need to teleport this into our repository.

```python
# location_repository.py

def locations_for_user(user):
    locations = []

    sql = "SELECT locations.* FROM locations INNER JOIN visits ON visits.location_id = locations.id WHERE user_id = %s"
    values = [user.id]
    results = run_sql(sql, values)

    for row in results:
        location = Location(row['name'], row['category'], row['id'])
        locations.append(location)

    return locations

```

Now in the terminal we can see a user's visited locations.

```python
#  console.py

locations = location_repository.locations_for_user(user1)

for location in locations:
    print(location.__dict__)
```

> TASK: Add the users(location) method to location_repository.

```python
# user_repository.py

def users_for_location(location):
    users = []

    sql = "SELECT users.* FROM users INNER JOIN visits ON visits.user_id = users.id WHERE location_id = %s"
    values = [location.id]
    results = run_sql(sql, values)

    for row in results:
        user = User(row['name'], row['id'])
        users.append(user)

    return users
```

Now in the terminal we can see a location's users.

```python
#  console.py

users = user_repository.users_for_location(location2)

for user in users:
  print(user.__dict__)

```

## Viewing the data

Great we can now see this data. Let's get it displayed in our show pages for both!

Let's start with getting locations for a user. In the `user_controller`s show method we need to get the users and pass to the template:

```python
# user_controller.py

@users_blueprint.route("/users/<id>")
def show(id):
    user = user_repository.select(id)
    locations = user_repository.locations(user) # ADDED
    return render_template("users/show.html", user=user, locations = locations) # MODIFIED

```

And in the `show.html` we can now loop through the locations and display them. 

```html
<!-- users/show.html -->
<h3>Visited:</h3>

<!-- ADDED -->
<ul>
  {% for location in locations  %}
  <li>{{location.name}}</li>
  {% endfor %}
</ul> 

```

Now if we refresh our page and click on a user we shold be able to see all the locations that user has visited!


#### Task

Add in the code that will show a list of users for a particular location!

```python
# location_controller.py

@locations_blueprint.route("/locations/<id>")
def show(id):
    location = location_repository.select(id)
    users = user_repository.users_for_location(location) # ADDED
    return render_template("locations/show.html", location=location, users=users) # MODIFIED

```

```html
<h3>Visited by:</h3>

<!-- ADDED -->
<ul>
  {% for user in users  %}
  <li>{{user.name}}</li>
  {% endfor %}
</ul>
```

## Summary

We created a many to many relationship using a join table called `visits`. This table contains a location_id, a user_id and a review. Each user can leave a review for a location for each visit that they make.

We then added methods to the `visit_repository` to give us the location and user for a particular visit.

We also added methods to our location and user repositories to make it easy for us to retrieve a locations users and a users locations given a user object or a location object.