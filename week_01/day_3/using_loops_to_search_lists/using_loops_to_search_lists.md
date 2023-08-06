# Using Loops to Search Lists

**Lesson Duration: 30 minutes**

### Learning Objectives
- Understand how to use a loop to search through a list

## Combining Loops and Functions

Often we will find that we need to find a specific element of a list using a loop. Let's say we wanted to find a chicken object if we're given the name of the chicken.

Consider the following. Why would the find_chicken_by_name function not work as we expect?

```python
# search_funcion.py

chickens = [
  { "name": "Margaret", "age": 2, "eggs": 0 },
  { "name": "Hetty", "age": 1, "eggs": 2 },
  { "name": "Henrietta", "age": 3, "eggs": 1 },
  { "name": "Audrey", "age": 2, "eggs": 0 },
  { "name": "Mabel", "age": 5, "eggs": 1 },
]

def find_chicken_by_name( list, chicken_name ):
  for chicken in list:
    if chicken["name"] == chicken_name:
      return chicken
    else:
      return None
```

If we try it with "Margaret", it works! But if we try it with any other name, it doesn't. Why?

```python
# AS ABOVE

print(find_chicken_by_name(chickens, "Margaret")) # {'name': 'Margaret', 'age': 2, 'eggs': 0}

print(find_chicken_by_name(chickens, "Audrey")) # None
```

The function will **always** return after the first iteration of the loop. It doesn't matter if the chicken is found or not. So we end up checking the first item in the list but not the others.

# The Fix

How do we fix it? We could get rid of the else and return outside the loop.

```python

def find_chicken_by_name( list, chicken_name ):
  for chicken in list:
    if chicken["name"] == chicken_name:
      return chicken

  return None
```

Another solution would be to create a variable to return and set it if we find the chicken.

```python

def find_chicken_by_name( list, chicken_name ):
  found_chicken = None
  for chicken in list:
    if chicken["name"] == chicken_name:
      found_chicken = chicken

  return found_chicken
```

# Try it for yourself

Given a list of users, write a function to find a user by id. Test your function works with a specific id (e.g. 4).

```python
users = [
  { "user_id": 1, "first_name": "Guido", "last_name": "van Rossum" },
  { "user_id": 2, "first_name": "Katherine", "last_name": "Johnson" },
  { "user_id": 3, "first_name": "Dorothy", "last_name": "Vaughan" },
  { "user_id": 4, "first_name": "Hen", "last_name": "Solo" },
  { "user_id": 5, "first_name": "Mary", "last_name": "Jackson" },
]
```

### Solution

```python

def find_user_by_id( list, user_id ):
  found_user = None
  for user in list:
    if user["user_id"] == user_id:
      found_user = user

  return found_user

print(find_user_by_id(users, 4))
```
