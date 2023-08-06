# Multiple Classes Lab

Your task is to model a Bus which can pick up and drop off passengers.

The app.py has been written for you, now you need to write the code to make it work.
You can use this to make sure that your code is doing what you want it to do as you work through the brief. Un-comment one section at a time, as you work through each point in the brief.

## Part A

### Step 1

- Create a Person class.
- The Person class should have attributes of a name and age.

### Step 2

- Create a Bus class. 
- The Bus should have a route number (e.g. 22) and a destination (e.g. "Ocean Terminal").
- The Bus should have a drive method that returns a string (e.g. "Brum brum").

## Part B

- Give the Bus class a new property, 'passengers'. This should be a list, which starts off empty. 
- Add a method to the Bus class which returns how many passengers are on the bus. 
- Add a method to the Bus class which takes in a Person and appends it to the list of passengers. The method could look something like `bus.pick_up(self, passenger_1)` 
- Add a method that drops off a passenger and removes them from the list. This could look like `bus.drop_off(self, passenger_2)`
- Add an 'empty()' method to remove all of the passengers - this might be used when the bus reaches its destination, or if the bus breaks down. It should remove all of the passengers from the list.

## Extension

- Create a new class called BusStop. This should have a name attribute.
- Add an attribute to the BusStop called 'queue'. This should be an empty list that will get filled with instances of the Person class.
- Add a method that adds a person to the queue.
- Add a method that removes all people from the queue.

Now imagine that our bus is travelling along the route. For now we will imagine that there is only one bus that goes on this route, so every passenger waiting at each stop wants to get on the bus. 

- Try writing a method that the bus would call, to collect all of the passengers from a stop. This might look like `bus.pick_up_from_stop(self, bus_stop_1)`. This should take all of the passengers waiting in line at the stop, and put them inside of the bus. So the stop will now have nobody in the queue, and the number of people on the bus will increase by however many people the stop had at it.
