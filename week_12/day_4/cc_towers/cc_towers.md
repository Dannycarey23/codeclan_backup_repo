# CodeClan Towers

You are being asked to build a booking system for the new CodeClan Towers hotel.

Use TDD in Junit to model the Hotel with Java classes, with separate test files for each class.

## MVP

- Create a `Guest` class, they should have a name, feel free to add more attributes later if you want. 
- Create a `RoomType` enum of bedroom types (e.g. Single/Double) that has a capacity attribute. 
- Create a `Room` abstract class with a capacity and collection of `Guest`s
- Create 2 different types of rooms that inherit from `Room`:
  - `Bedroom`s will additionally have a room number and `RoomType` (hint you can use the value of the `capacity` attribute attached to the RoomType Enum and pass it to the `super()` function)
  - `ConferenceRoom`s will additionally have a name and any other properties you wish.
- Create a `Hotel` class, which has a collection of `Bedroom`s and a collection of `ConferenceRoom`s.
- The `Hotel` will be able check guests in/out of rooms.

### Extensions

- Create a `Booking` class which contains a `Bedroom` and a number of nights booked.
- Create a `bookRoom` method in your `Hotel`. This should book a given `Bedroom` for a number of nights. This should return a new `Booking` object.
- Add a nightly rate to your `Bedroom`s and write a method to return the total bill for the `Booking`.
- Add a `DiningRoom` class with a name, capacity, and collection of guests
- Hotel will have a `HashMap` based collection of `DiningRoom`s.
- <details>
  <summary>Hint ^</summary>
  <code>HashMap&ltString, DiningRoom&gt</code>
  <p>The String here could be from calling <code>.getName()</code> on the instance of DiningRoom</p>
</details>

### Advanced Extensions

- Add a static method to Room to calculate it's size (return type is double) , input would be length (double) and width (double).
- Using inheritance and the static method above test the size of a Bedroom, DiningRoom and Conference room
- Add functionality to the `Hotel` so it can return a collection of only the vacant `Bedroom`s.
- Update the check-in process so that `Hotel` will only be able to check guests into empty `Bedroom`s.
- Any other extensions you can think of!
