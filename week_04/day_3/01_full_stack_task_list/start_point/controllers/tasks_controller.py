from flask import Flask, render_template
from repositories import task_repository

from flask import Blueprint

tasks_blueprint = Blueprint("tasks", __name__)

# RESTful CRUD Routes

# INDEX
# GET '/tasks'
@tasks_blueprint.route("/tasks")
def tasks():
    tasks = task_repository.select_all() # NEW
    return render_template("tasks/index.html", all_tasks = tasks)


# NEW
# GET '/tasks/new'

# CREATE
# POST '/tasks'

# SHOW
# GET '/tasks/<id>'

# EDIT
# GET '/tasks/<id>/edit'

# UPDATE
# PUT '/tasks/<id>'

# DELETE
# DELETE '/tasks/<id>'