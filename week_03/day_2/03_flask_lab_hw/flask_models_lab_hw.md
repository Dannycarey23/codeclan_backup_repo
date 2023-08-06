# Flask Models Lab & Homework

Your task is to model a Flask app which will list customer orders for an online shop. What the shop sells is up to you! (Could be books, games, food, etc)

## MVP

Your application should have a single class - Order - and should contain at least the following properties:

- customer_name
- order_date
- quantity

And any other relevant properties such as:

- book_title/game_title
- food_topping
- description

Provide the following functionality in the web app:

- List all orders using an orders controller / Blueprint

### Extensions

- Create a new route to display one order. You can use the index number to obtain the order from the list.
  - Route will be a `GET` route to `/orders/<index>`
  - Create a new template called `order.html`
  - Add a link, (`<a></a>`), to each order in the list to take you to the appropriate view for that orders details.

## Extra Extra!

A some CSS to your app.

### Styling

To style a Flask app you will need to put your CSS files inside a folder called `static` inside the root directory.

Then add the following line inside the <HEAD> tag of your HTML pages.

```html
<link
  rel="stylesheet"
  href="{{ url_for('static', filename='your_file_name.css') }}"
/>
```

#### Guidance

Follow RESTful convention for your routes.
