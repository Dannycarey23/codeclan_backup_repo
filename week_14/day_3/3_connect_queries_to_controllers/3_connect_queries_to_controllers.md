# Connect Queries To Controllers

**Lesson Duration: 30 minutes**

### Learning Objectives
- Be able to connect a query defined in a JPA Repository (derived or otherwise) to a controller.

## Making sure the database is clean and ready to use

Open Postico go to the database pirates (If it exists).
If it does exist then right click on it and say delete to remove it so that you are starting from a fresh start point.
Open a terminal and type in ```createdb pirates``` to create a fresh Database.
Note that this is only needed for the purposes of lessons ordinarily you would use the same Database and not delete it every time.

NB: If you had to change the username by which you connect to the database in the previous lessons you will need to change it again in the application.properties under the main->resources folder.

## Create a custom route for finding ships that have pirates named

Let's create a new custom route in `ShipController` that allows anyone using our API to use the `findByPiratesFirstName` query we creted earlier.



### Using Query Strings

Query strings are arguments we can give to a URL.

For example in a URL you often see something like `http://example.com/over/there?name=ferret` - the `name=ferret` part is called a query string. It's a way of passing extra arguments into a URL.


An example of this as a query string looks arguably nicer:

* Query String route is cleaner: `localhost:8080/ships/pirates?named=Maggie`. ✅
* Without query string `localhost:8080/ships/pirates/named/Maggie`. ❌

**Since the Query String** version makes for the *better API design*, we'll go with that. To implement a query string we need to use a `@RequestParam` annotation on the method argument.

We give the `@RequestParam` annotation a value to look for which is the *key* for the query string param:

```@RequestParam(name="named") String name```
Will look for a query string with **key** `named`. Like `?named=Maggie`, for example.

The method will look like this:

```java
//ShipController.java
  // This is the same as above, but with a Query String instead.
    @GetMapping(value = "/ships/pirates")
    public ResponseEntity<List<Ship>> findShipsThatHavePiratesNamedQueryString(
            @RequestParam(name="named") String name){
        return new ResponseEntity<>(shipRepository.findByPiratesFirstName(name), HttpStatus.OK);
    }

```

> At this point if the longer path version of the route is still in the code, just delete it - we want to go with the query string.

Note on the route for the query string we should leave off the trailing slash `/`, as it will cause problems if it's left in.

### Query Strings are great
We should use query strings to filter on existing routes. This means we can create fewer endpoints in our code. It does mean our controller code for each route that has various optional query strings will need to be a little smarter. This also allows is to stick to ReSTful routes in our design.




## Task (10 mins): Create a controller for "find / filter raid by location name"


> This task can be quite challenging. Not many students will 'get it' allow them to get to the error and then talk them through the solution.

* Write a controller that connects into the "find raid by location" query we completed in the last lesson
* TIP: Think about what controller it should be in. We're dealing with raids... so `RaidController.java`
* TIP: Consider using a query string to create a filter.
* TIP: Consider what might happen when our route clashes with the existing GET on `/raids`.

<details>
<summary>
Solution
</summary>

If we just implement another GET on `/raids` and add on the `RequestParam`, then we will get an **error** becuase there's already a route setup on `/raids`. So for this solution we need to merge the two queries into one controller.

The error will show something like:

```
{[/raids],methods=[GET]}: There is already 'raidController' bean method

```
It's possible to make use of the `@RequestParam`s `required` attribute. By default this is set to true. If it's set to `false` this makes it so there's a single route for `/raids` that can be used for both:

* GET `/raids` - return a list of all raids
* GET `/raids?location=Tortuga` - filter out tortuga

To do this, we'll check if the `location` provided by the RequestParam is not null. If it's not null the `findRaidByLocation(location)` query should be called and returned.

Otherwise, call the `findAll()` method which would normally be called for any GET `/raids` requests.

This is known as a filter. It's happening on the  existing `/raids route. Make sure the other GET `/raids` route is deleted.


```java
// RaidController.java

@GetMapping(value = "/raids")
public ResponseEntity<List<Raid>> findRaidsFilterByLocation(
        @RequestParam(name="location", required = false) String location) {
    if (location != null) {
        return new ResponseEntity<>(raidRepository.findRaidByLocation(location), HttpStatus.OK);
    }
    return new ResponseEntity<>(raidRepository.findAll(), HttpStatus.OK);
}
	
```
</details>


## Summary

We now know how to:

* Connect a JPA query we've written to a controller
* Make use of `@RequestParam` annotation to make a query string on routes to allow us to create a filter.
* Get one controller route to  decide to call between two different database queries.
