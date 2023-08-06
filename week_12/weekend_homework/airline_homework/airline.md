# Airline!

Your task is to model a system for the world renowned airline __JavaAir__, to allow them to manage their flights. You should use the tools you have learnt this week _where appropriate and useful_. Remember to **TDD**!

JavaAir doesn't really exist (sadly) - don't stress about how a "real" example of this would work differently. This is just an exercise to practice some different concepts.

**Assumptions**:

* Each passenger bag weighs the same
* Planes reserve half of their total weight for passenger bags
* The weight of bag per person is the weight reserved for passenger bags divided by the capacity
* Passengers exist for a single flight only

## MVP
A `Passenger` has:

* a name
* a number of bags

A `CabinCrewMember` has:

* a name
* a rank (e.g Captain/First Officer/Purser, Flight Attendant)
<details>
    <summary>Hint</summary>
    <p>Perhaps use an `enum` for this</p>
  </details>

A `Pilot` has:

* a name
* a rank
* a pilot licence number (you can use a `String` for this)
  

A `Plane` has:

* an plane type (e.g. *BOEING747*) which stores capacity and total weight
<details>
  <summary>Hint</summary>
  <p>Perhaps use an `enum` for this</p>
</details>

A `Flight` has:

* at least one `Pilot`
* a list of `CabinCrewMembers` (you can decide the number)
* an empty list of booked `Passenger`'s
* a `Plane`
* flight number (i.e. "FR756")
* destination (i.e. GLA, EDI)
* departure airport (i.e. GLA, EDI)
* departure time (use a String)

The `Flight`  should be able to:

* return the number of available seats
* book a passenger (if there are remaining seats)

A `Pilot` should be able to:

* fly the plane (a simple method which returns a String is sufficient)

A `CabinCrewMember` should be able to:

* relay messages to the passengers(a simple method which returns a String is sufficient)

### Extensions
Create a `FlightManager` which can:

* calculate how much baggage weight should be reserved for each passenger for a flight
* calculate how much baggage weight is booked by passengers of a flight
* calculate how much overall weight reserved for baggage remains for a flight

### More Extensions
* Refactor the Flight's departure time to use the Date class (*HINT*: Look into **Type Migration** in IntelliJ to refactor faster)
* Add a 'flight' property to the `Passenger` which is assigned when a passenger is added to a flight
* Add a 'seat number' property to the `Passenger` as an integer. Set it to a random number which is assigned when a `Passenger` is booked on a flight
* Make sure the flight doesn't double book the same seat number to more than one passenger

### PDA Reminder:

As part of this homework you are required to take screenshots of the following:

```
- An example of encapsulation in a program.
```

Demonstrate testing in your program. Take screenshots of:

```
- Example of test code
- The test code failing to pass
- Example of the test code once errors have been corrected
- The test code passing
```

- Submit your PDA evidence (screenshots, etc.) to Canvas

- PDA Reference: I.T 1, P18
