# Setting up the data for testing. Declare and initialise 5 dictionaries representing people
person1 = {
    "name": "Shaggy",
    "age": 12,
    "monies": 1,
    "friends": ["Velma", "Fred", "Daphne", "Scooby"],
    "favourites": {
        "tv_show": "Friends",
        "snacks": ["charcuterie"]
    }
}

person2 = {
    "name": "Velma",
    "age": 15,
    "monies": 2,
    "friends": ["Fred"],
    "favourites": {
        "tv_show": "Baywatch",
        "snacks": ["soup", "bread"]
    }
}

person3 = {
    "name": "Scooby",
    "age": 18,
    "monies": 20,
    "friends": ["Shaggy", "Velma"],
    "favourites": {
        "tv_show": "Pokemon",
        "snacks": ["Scooby snacks"]
    }
}

person4 = {
    "name": "Fred",
    "age": 18,
    "monies": 20,
    "friends": ["Shaggy", "Velma", "Daphne"],
    "favourites": {
            "tv_show": "X-Files",
            "snacks": ["spaghetti", "ratatouille"]
    }
}

person5 = {
    "name": "Daphne",
    "age": 20,
    "monies": 100,
    "friends": [],
    "favourites": {
            "tv_show": "X-Files",
            "snacks": ["spinach"]
    }
}

# Add the people dictionaries to a list
people = [person1, person2, person3, person4, person5]

# TASKS

# Test all your functions by printing out their return value unless otherwise stated.

# 1. Define a function called get_name(person) that returns the given person's name
# INPUT: person5
# OUTPUT: "Daphne"


# 2. Define a function called get_favourite_tv_show(person) that returns the given person's favourite TV show
# INPUT: person2
# OUTPUT: "Baywatch"


# 3. Define a function called likes_to_eat(person, food) that returns True or False
# INPUT: person2, "bread"
# OUTPUT: True
#
# INPUT: person3, "spinach"
# OUTPUT: False


# 4. Define a function called add_friend(person, new_friend) that appends a new friend to the person's list of friends
# INPUT: person2, "Scrappy-Doo"
# OUTPUT: None
# Test your function by calling it and then printing our person2's list of friends


# 5. Define a function called remove_friend(person, old_friend) that removes a friend from the person's list of friends
# INPUT: person2, "Fred"
# OUTPUT: None
# Test your function by calling it and then printing our person2's list of friends


# 6. Define a function called total_money(people) that returns the total of everyone's money
# INPUT: people
# OUTPUT: 143


# 7. Define a function called lend_money(lender, borrower, amount) that removes a given amount from the lender and adds it to the borrower
# INPUT: person2, person1, 2
# OUTPUT: None
# Test your function by calling it and then printing out person1's and person2's monies


# 8. Define a function called all_favourite_foods(people) that returns a list of everyone's favourite food.
# INPUT: people
# OUTPUT: ["charcuterie", "soup", "bread", "Scooby snacks", "spaghetti", "ratatouille", "spinach"]


# 9. Define a function called find_no_friends(people) that returns a list of all the people that have a friends list of length 0.
# INPUT: people
# OUTPUT: [{'name': 'Daphne', 'age': 20, 'monies': 100, 'friends': [], 'favourites': {'tv_show': 'X-Files', 'snacks': ['spinach']}}]


# 10. Define a function called unique_favourite_tv_shows(people) that returns a list of all the tv_shows (without duplicates).
# INPUT: people
# OUTPUT: ['Friends', 'Baywatch', 'Pokemon', 'X-Files']


# BONUS: Try to refactor the previous function to use Python's built-in set() function.
