from db.run_sql import run_sql

from models.location import Location
from models.user import User

def save(location):
    sql = "INSERT INTO locations(name, category) VALUES ( %s, %s ) RETURNING id"
    values = [location.name, location.category]
    results = run_sql( sql, values )
    location.id = results[0]['id']
    return location


def select_all():
    locations = []

    sql = "SELECT * FROM locations"
    results = run_sql(sql)

    for row in results:
        location = Location(row['name'], row['category'], row['id'])
        locations.append(location)
    return locations


def select(id):
    location = None
    sql = "SELECT * FROM locations WHERE id = %s"
    values = [id]
    result = run_sql(sql, values)[0]

    if result is not None:
        location = Location(result['name'], result['category'], result['id'] )
    return location


def locations_for_user(user):
    locations = []

    sql = "SELECT locations.* FROM locations INNER JOIN visits ON visits.location_id = locations.id WHERE user_id = %s"
    values = [user.id]
    results = run_sql(sql, values)

    for row in results:
        location = Location(row['name'], row['category'], row['id'])
        locations.append(location)

    return locations


def location_for_visit(visit):
    sql = "SELECT * FROM locations WHERE id = %s"
    values = [visit.location.id]
    results = run_sql(sql, values)[0]
    location = Location(results['name'], results['category'], results['id'])
    return location


def delete_all():
    sql = "DELETE FROM locations"
    run_sql(sql)
