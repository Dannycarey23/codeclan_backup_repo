from flask import Flask, render_template, request, redirect
from flask import Blueprint
from models.user import User
import repositories.user_repository as user_repository

users_blueprint = Blueprint("users", __name__)

@users_blueprint.route("/users")
def users():
    users = user_repository.select_all() # NEW
    return render_template("users/index.html", users = users)

@users_blueprint.route("/users/<id>")
def show(id):
    user = user_repository.select(id)
    return render_template("users/show.html", user=user)
