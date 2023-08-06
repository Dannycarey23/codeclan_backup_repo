from db.run_sql import run_sql
from models.visit import Visit
import repositories.user_repository as user_repository
import repositories.location_repository as location_repository

def save(visit):
    sql = "INSERT INTO visits ( user_id, location_id, review ) VALUES ( %s, %s, %s ) RETURNING id"
    values = [visit.user.id, visit.location.id, visit.review]
    results = run_sql( sql, values )
    visit.id = results[0]['id']
    return visit


def select_all():
    visits = []

    sql = "SELECT * FROM visits"
    results = run_sql(sql)

    for row in results:
        user = user_repository.select(row['user_id'])
        location = location_repository.select(row['location_id'])
        visit = Visit(user, location, row['review'], row['id'])
        visits.append(visit)
    return visits


def delete_all():
    sql = "DELETE FROM visits"
    run_sql(sql)

def delete(id):
    sql = "DELETE FROM visits WHERE id = %s"
    values = [id]
    run_sql(sql, values)
