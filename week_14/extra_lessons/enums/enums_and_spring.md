# Enums and Spring

## Learning Objectives

Use Spring JPA to persist enum types to database.

## Introduction

So far we have just been saving primitive types, Strings and collections to the database and trusting Spring to convert to the correct SQL type for us.

But what about Enums?

Hibernate treats enums slightly differently from primitive types in that we can't just ask Hibernate to map these to a table directly.

## Creating an Enum.

> Open Start Point

Here we have our start point. As you can see we are using our pirateService app for this.

So where will Enums fit in?

A logical use of Enums here is a type for each ship. Ships could be one of `Galleon`, `Dreadnought`, `Cutter` or `Schooner`.

Let's start by creating the enum file.

>Task 5 Mins

 - Right click on models and create a new Enum file `ShipType`.
 - Add the above ship types.

<details>
<summary>Solution</summary>

```java

 // ShipType.java

 package com.codeclan.example.pirateservice_d1_starter.models;

 public enum ShipType {

     GALLEON,
     DREADNOUGHT,
     CUTTER,
     SCHOONER
 }
```
</details>

## Setting up the ENUM in JPA

Now let's amend our Ship class and have it take in a ship type as well as a name.

Remember that we will need a getter and setter.

```java
// Ship.java

@Column(name = "name")
private String name;

private ShipType shipType; // ADDED

@JsonIgnore
@OneToMany(mappedBy = "ship")
private List<Pirate> pirates;

public Ship(String name, ShipType shipType) { // MODIFIED
  this.name = name;
  this.shipType = shipType;
  this.pirates = new ArrayList<>();
}

// AS BEFORE


public void setId(Long id) {
  this.id = id;
}

public ShipType getShipType() {
  return shipType;
} // ADDED

public void setShipType(ShipType shipType) {
  this.shipType = shipType;
} // ADDED

```

> Task 10 mins

Now in our `DataLoader` and test files we will need to change the creation of our ships to take in a ship type.

Give the Black Pearl a type of `GALLEON` and The dutchman a type of `DREADNOUGHT`

<details>
<summary>Solution</summary>

```java
// DataLoader.java

Ship dutchman = new Ship("The Flying Dutchman", ShipType.DREADNOUGHT); // MODIFIED
shipRepository.save(dutchman);

Ship pearl = new Ship("The Black Pearl", ShipType.GALLEON); // MODIFIED
shipRepository.save(pearl);
```

```java
// PirateserviceD1StarterApplicationTests

@Test
public void createPirateAndShip(){
  Ship ship = new Ship("The Flying Dutchman", ShipType.DREADNOUGHT); // MODIFIED
  shipRepository.save(ship);

  Pirate pirate1 = new Pirate("Jack", "Sparrow", 32, ship);
  pirateRepository.save(pirate1);
}

@Test
public void addPiratesAndRaids(){
  Ship ship = new Ship("The Flying Dutchman", ShipType.DREADNOUGHT); // MODIFIED
  shipRepository.save(ship);

  Pirate pirate1 = new Pirate("Jack", "Sparrow", 32, ship);
  pirateRepository.save(pirate1);

  Raid raid1 = new Raid("Tortuga", 100);
  raidRepository.save(raid1);

  raid1.addPirate(pirate1);
  raidRepository.save(raid1);

}
```
</details>


Great we now have a ship with a specific type.

So how do we tell hibernate to save this.

## Mapping using Ordinal.

The first way we could map our enum is to use the ordinal.

Ordinal is basically an index of the enums starting at 0.

So in our ShipType, `GALLEON` has an ordinal of 0, `DREADNOUGHT` has ordinal of 1, etc.

Whatever way we do this we have to annotate the property as being of an `Enumerated` type. Then tell hibernate what we want to use to save.

Let's do this in the `Ship` class.

```java
// Ship.java

@Column(name="type")
@Enumerated(value = EnumType.ORDINAL)
private ShipType shipType;

```

Let's run our application now.

 - Right click on `PirateserviceD1StarterApplication` and select run `PirateserviceD1StarterApplication.main()`

 If we now jump into psql and SELECT * FROM ships we will see that each ship has a shipType of an integer value. Black pearl should have 0 and dutchman has 1.

 ```
 pirateservice=> select * from ships;
  id |         name         | type
 ----+----------------------+---
   1 | The Flying Dutchman  | 0
   2 | The Black Pearl      | 1       

 ```

 And if you go to `localhost:8080/ships` you will see that when we get our ships back we get the correct ship type associated with them.

 ```json
 {
   "name": "The Flying Dutchman",
   "shipType": "DREADNOUGHT",
   "_embedded": {
     "pirates": []
   },
   "_links": {}
 }
 ```

 So when we then request the ships back from the database Hibernate maps the ship type back to the enum with the ordinal which matches the integer save in the database.

 This is all fine and well but what happens if we add a new ShipType at the start of the enums. e.g.

```java
// ShipType

public enum ShipType {
    BRIG,
    GALLEON,
    DREADNOUGHT,
    CUTTER,
    SCHOONER
}

```

Now BRIG has the ordinal 0.... so when we get our already save ships back the black pearl would then be mapped over to a `BRIG` and dutchman mapped to `GALLEON`, because all ordinals have been moved up one.

> Note you won't be able to see this here as the data is reseeded every time! You would need to comment out code in DataLoader.

This isn't great.

Surely there must be a better way to map the enums??

## Mapping Enum as a String


Of course there is!

We can map the Enums back as Strings.

This is a simple change in the Ship class.

```java
// Ship.java

@Column(name="type")
@Enumerated(value = EnumType.STRING) // MODIFIED
private ShipType shipType;
```

Run the application again and check the ships table in psql.

```
pirateservice=> select * from ships;
 id |         name        | type
----+---------------------+------
  1 | The Flying Dutchman | DREADNOUGHT
  2 | The Black Pearl     | GALLEON      

```

Ace! Our ships now have a `VARCHAR` for the ship type.

Again when hibernate maps the ships back over to Java objects it will assign the enum matching the string.

So now it doesn't matter if we change the order or add new ship types they will always be assigned the correct type.

The only thing to be aware of is if you change the spelling of any of the enums... so check that carefully before you save any ships!

### Summary

So mapping Enums is actually fairly straightforward.

The choice of using Ordinal or String is at developers discretion but be aware of pitfalls for both.
