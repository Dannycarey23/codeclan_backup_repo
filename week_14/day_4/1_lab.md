# All Day Lab - Build a Course Booking System

## Intro

For this lab, we will build a simple course booking back-end. At the end of the lab we should have a RESTful API that allows connected clients to create course bookings and find useful information about the bookings created.

The API should be built from scratch with Spring using Spring Boot Initialiser.


## Making sure the database is clean and ready to use

Open Postico go to the database courseservice (If it exists).
If it does exist then right click on it and say delete to remove it so that you are starting from a fresh start point.
Open a terminal and type in ```createdb courseservice``` to create a fresh Database.
Note that this is only needed for the purposes of lessons ordinarily you would use the same Database and not delete it every time.

NB: If you had to change the username by which you connect to the database in the previous lessons you will need to change it again in the application.properties under the main->resources folder.


## MVP

### Models
The course reservations API needs to be built with three models with the following properties:

* Course
  * name - the name of the course eg: Intro to Python
  * town - the town/city/village where the course is located. We will not bother with full address yet.
  * star rating - Out of 5, each course has a rating
* Booking
   * date - a **string** in the form "dd-mm-yy" for the booking date. Dates can be in the future or in the past

* Customer
   * name - **string** containing customer's name
   * town - a **string** containing the town where the customer lives. We will not record an address at this stage
   * age - the customers age. Useful for marketing purposes

The relationships should be:

* A Course has many Bookings
* A Booking has a Course
* A Customer has many bookings
* A booking has a customer

### Queries + Custom Routes

Write queries using the derived method we've shown. Connect these to suitable RESTful endpoints and decide whether you should use a filter or not for all of:

* Get all courses with a given rating
* Get all customers for a given course
* Get all courses for a given customer
* Get all bookings for a given date


## Extensions


### Extension Queries + Routes

* Get all customers in a given town for a given course
* Get all customers over a certain age in a given town for a given course

You need to write and test these queries.

### Other Extensions
* Correctly handle case-insensitive routes with Spring RestController or the `IgnoreCase` in derived queries.


## Tips / Reminders

* Stick to the RESTful routes for each resource:
   * GET `/resources`
   * GET `/resources/{id}`
   * GET `/resources?property=value`
   * POST `/resources`
   * PUT `/resources/{id}`
   * DELETE `/resources/{id}`

* You're allowd to create routes outside of this structure, but you need to be able to justify the design decision.  We of course reccomend you stick with this RESTful way of doing things.

* Clearly understand the relationships before coding. Draw it out.
* Write tests for your queries.
* Use a ddl-auto setting of `update` when doing development.
* Provide a data loader to seed some initial seed data, remember to comment out the `@Component` after you have run your server the first time otherwise it will create duplicates in your database.
* Reminder on which dependencies to use with spring Initialiser:
  * Web
  * JPA
  * Postgres
  * DevTools
  


