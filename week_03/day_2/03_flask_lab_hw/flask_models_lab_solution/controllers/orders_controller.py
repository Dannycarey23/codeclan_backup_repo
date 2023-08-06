from flask import render_template, Blueprint
from models.orders import orders

orders_blueprint = Blueprint("orders", __name__)

@orders_blueprint.route('/orders')
def index():
    return render_template('index.html', title='Jabba the Pizza Hutt', orders=orders)

@orders_blueprint.route('/orders/<index>')
def show(index):
  chosen_order = orders[int(index)]
  
  return render_template('order.html', order=chosen_order)
