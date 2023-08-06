from flask import Flask, render_template, request, redirect
from flask import Blueprint
from models.location import Location
import repositories.location_repository as location_repository

locations_blueprint = Blueprint("locations", __name__)

@locations_blueprint.route("/locations")
def locations():
    locations = location_repository.select_all() # NEW
    return render_template("locations/index.html", locations = locations)

@locations_blueprint.route("/locations/<id>")
def show(id):
    location = location_repository.select(id)
    return render_template("locations/show.html", location=location)
