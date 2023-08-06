from flask import Flask
from controllers.orders_controller import orders_blueprint

app = Flask(__name__)
app.register_blueprint(orders_blueprint)