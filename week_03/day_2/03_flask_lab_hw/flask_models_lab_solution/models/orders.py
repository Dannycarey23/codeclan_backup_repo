from models.order import *
import datetime

order1 = Order(datetime.date(2020, 5, 17), "Luke Skywalker", 1,  'Pepperoni')
order2 = Order(datetime.date(2020, 6, 18), "Han Solo", 2, "Quatro Fromagio")
order3 = Order(datetime.date(2020, 7, 19), "Darth Vader", 1, "Pineapple")

orders = [order1, order2, order3]


