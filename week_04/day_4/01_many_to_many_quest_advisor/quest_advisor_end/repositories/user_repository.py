from db.run_sql import run_sql

from models.location import Location
from models.user import User

def save(user):
    sql = "INSERT INTO users( name ) VALUES ( %s ) RETURNING id"
    values = [user.name]
    results = run_sql( sql, values )
    user.id = results[0]['id']
    return user


def select_all():
    users = []

    sql = "SELECT * FROM users"
    results = run_sql(sql)
    for row in results:
        user = User(row['name'], row['id'])
        users.append(user)
    return users


def select(id):
    user = None
    sql = "SELECT * FROM users WHERE id = %s"
    values = [id]
    results = run_sql(sql, values)

    # checking if the list returned by `run_sql(sql, values)` is empty. Empty lists are 'fasly' 
    # Could alternativly have..
    # if len(results) > 0 
    if results:
        result = results[0]
        user = User(result['name'], result['id'] )
    return user


def users_for_location(location):
    users = []

    sql = "SELECT users.* FROM users INNER JOIN visits ON visits.user_id = users.id WHERE location_id = %s"
    values = [location.id]
    results = run_sql(sql, values)

    for row in results:
        user = User(row['name'], row['id'])
        users.append(user)

    return users

def user_for_visit(visit):
    sql = "SELECT * FROM users WHERE id = %s"
    values = [visit.user.id]
    results = run_sql(sql, values)[0]
    user = User(results['name'], results['id'])
    return user


def delete_all():
    sql = "DELETE FROM users"
    run_sql(sql)
