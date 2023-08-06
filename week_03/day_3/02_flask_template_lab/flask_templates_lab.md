# Flask Templates Lab

Your task is to model a Flask app which will list upcoming events and allow users to add events to the list.

## MVP

Your application should have a single class - Event - and should contain the following properties:
* Date (of the Python type `datetime.date`, you'll need to import `datetime`)
* Name of Event
* Number of guests
* Room Location
* Description

Provide the following functionality:
* List all events
* Create an event in the event planner.

### Extensions

* Add a 'recurring' boolean property to the `Event` class.
* Give the user visual feedback on what events are recurring
* Use an HTML date picker instead of a text input for the new event date.
* Style the app using CSS

## Advanced Extensions

* Delete the items from the list (either use index or event name to do this)
    * Because we can't use the `DELETE` HTTP method you will need to create a `POST` route to `/events/delete/<index>` in order to avoid conflicts!
* Anything else you can think of


#### Guidance

To style a Flask app you will need to put your CSS files inside a folder called `static` inside the `app` package.

Then add the following line inside the <HEAD> tag of your `base.html`

```html
    <link rel="stylesheet" href="{{ url_for('static', filename='your_file_name.css') }}">
```

When deleting the event use a form and the event name to identify which one is to be deleted.

An HTML checkbox input value will only be included in the form dictionary if the box is checked. It will by default return the string 'On'
