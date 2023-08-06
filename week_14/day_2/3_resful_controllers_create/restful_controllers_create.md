# RESTful Controllers - create + Insomnia

## Learning Objectives
* Learn how to create REST Controllers that allow us to POST data that gets saved int the database)
* Learn how to use Insomnia to simulate using a front-end or client to make the HTTP POST requests.

## Making sure the database is clean and ready to use

Open Postico go to the database pirates (If it exists).
If it does exist then right click on it and say delete to remove it so that you are starting from a fresh start point.
Open a terminal and type in ```createdb pirates``` to create a fresh Database.
Note that this is only needed for the purposes of lessons ordinarily you would use the same Database and not delete it every time.

## Introduction

We know how to use HTTP GET to get data from our RESTful API.

We need to be able to save data into our database through our JPA ORM. We do this by creating REST Endpoints that allow us to perfrom HTTP POST actions.

From our RESTful routes we will implement the `create` action.

## REST "Create" Controller Endpoints

Let's use Insomnia to POST a new pirate to `/pirates` with this body:
```json
{
	"firstName": "Pete",
	"lastName": "Glasseye",
	"age": 33,
	"ship": {
  	  "id": 2,
  	  "name": "The Black Pearl"
  }
}

```

> Do this. It will give an error, as we need to create build the "create" route.

We get a Method Not Allowed error from our back-end.

That's because the mappings we have in our controllers are so-far only `GetMapping`s. We need to add `PostMapping` controllers to allow us to POST data to that endpoint.

**Let's start with PirateController**. Before we do, we need to think about what we want to give as a response to a POST.

> Ask the class for ideas on what a POST response should be.
>
> Ask them what status code specifically it should have. Remember to look at [https://www.restapitutorial.com/httpstatuscodes.html ](https://www.restapitutorial.com/httpstatuscodes.html)

Should it be:

* An empty response with 201 (Created)?
* A response with a body containing a message saying "success" or something and have a 201 (Created) status code?
* A response with a body that is the JSON of the object we just posted and a 201 (Created) status.

There's no actual correct way.. But it's common using REST principles to do the latter: **A response with a body that is the JSON of the object we just posted and a 201 (Created) status.** This is what we'll do.

Let's be clear on what we want this postPirate method to do. It will.

* Accept POST requests on `/pirates`
* Grab a request body payload which we presume to be a JSON of a pirate object.
* Use the pirateRepository to save that object.
* Return that same object with a `ResponseEntity` and HTTP Code 201 Created. ( `HttpStatus.CREATED` )

We need to use annotation `@RequestBody` to grab the `Pirate` object.

```java
//PirateController.java


 @PostMapping(value = "/pirates")
    public ResponseEntity<Pirate> postPirate(@RequestBody Pirate pirate){
        pirateRepository.save(pirate);
        return new ResponseEntity<>(pirate, HttpStatus.CREATED);
    }

```

## Manually Testing POST - Insomnia

Launch the Mac desktop app Insomnia. If it's not installed install it with `brew cask install insomnia`.

> Show students how to create a GET action on `http://localhost:8080/pirates`

Create a POST request with the following body:

```json
{
	"firstName": "Pete",
	"lastName": "Glasseye",
	"age": 33,
	"ship": {
  	  "id": 2,
  	  "name": "The Black Pearl"
  }
}

```

**Note: IMPORTANT**: If we post a `ship` property that doesn't exist in the DB already, we'll get problems.

Notice that the **response** we see in Insomnia has the `id`, as it's been passed to the DB and indexed.

```json
{
  "firstName": "Pete",
  "lastName": "Glasseye",
  "age": 33,
  "id": 11,
  "ship": {
    "id": 2,
    "name": "The Black Pearl"
  },
  "raids": null
}
```

### Task: 15 mins-ish

Write and (using Insomnia) test the **create** route for `Raid` and `Ship` in `RaidController` and `ShipController` respectively.

#### Solution

```java
//ShipController.java

  @PostMapping(value = "/ships")
    public ResponseEntity<Ship> createShip(@RequestBody Ship ship){
        shipRepository.save(ship);
        return new ResponseEntity<>(ship, HttpStatus.CREATED);
    }
```

JSON Body to test with:

```json
{
	"name": "Boaty Mc Boatface"
}

```
------

```java
// RaidController.java

 @PostMapping(value = "/raids")
    public ResponseEntity<Raid> createRaid(@RequestBody Raid raid){
        raidRepository.save(raid);
        return new ResponseEntity<>(raid, HttpStatus.CREATED);
    }

```

JSON Body to test with:

```json
{
	"location": "Port of Leith",
	"loot": 100
}

```


## Summary

We've created POST or "create" routes that conform the the RESTful design principles.

* We've seen how to use `@RequestBody` to accept a JSON of that object and allow Spring to automatically de-serialize into a Java object.
* Use the appropriate repository to save the object into the DB.
* We know how to return a response entity with the appropriate body and the 201 created HTTP status code.
