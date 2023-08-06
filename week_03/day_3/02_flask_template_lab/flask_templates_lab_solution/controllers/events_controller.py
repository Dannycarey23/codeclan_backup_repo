from flask import render_template, request, redirect, Blueprint
from models.events import events, add_new_event, delete_event
from models.event import *
import datetime

events_blueprint = Blueprint('events', __name__)

@events_blueprint.route('/events')
def index():
    return render_template('index.html', title='Home', events=events)

@events_blueprint.route('/events', methods=['POST'])
def add_event():
  date = request.form['date']
  # Split the date into a list
  split_date = date.split('-')
  # create a new date object
  date = datetime.date(int(split_date[0]), int(split_date[1]), int(split_date[2]))
  name = request.form['name']
  guests = request.form['guests']
  recurring = True if 'recurring' in request.form else False
  roomLocation = request.form['roomLocation']
  description = request.form['description']
  new_event = Event(date=date, name= name, guests=guests, recurring=recurring, room_location=roomLocation, description=description)
  add_new_event(new_event)
  return redirect('/events')

@events_blueprint.route('/events/delete/<name>', methods=['POST'])
def delete(name):
  delete_event(name)
  return redirect('/events')
