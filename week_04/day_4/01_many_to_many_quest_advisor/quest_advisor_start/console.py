import pdb
from models.location import Location
from models.user import User
from models.visit import Visit

import repositories.location_repository as location_repository
import repositories.user_repository as user_repository
import repositories.visit_repository as visit_repository

visit_repository.delete_all()
location_repository.delete_all()
user_repository.delete_all()

user1 = User('Samwise Gamgee')
user_repository.save(user1)

user2 = User('Frodo Baggins')
user_repository.save(user2)

user3 = User('Gollum')
user_repository.save(user3)

location1 = Location('Mordor', 'Attractions')
location_repository.save(location1)

location2 = Location('The Prancing Pony', 'Tavern')
location_repository.save(location2)

visit1 = Visit(user1, location1, '0 stars, far too hot')
visit_repository.save(visit1)

visit2 = Visit(user3, location1, '5 stars, would visit again if I could')
visit_repository.save(visit2)

visit3 = Visit(user1, location2, '4 stars, plenty of beer available')
visit_repository.save(visit3)

visit4 = Visit(user2, location2, '3 stars, too crowded, could not find my wizard friend')
visit_repository.save(visit4)

pdb.set_trace()
