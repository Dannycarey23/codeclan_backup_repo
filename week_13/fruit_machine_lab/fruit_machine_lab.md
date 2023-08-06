# Fruit Machine Lab

You have been asked to create a simple piece of software that will operate a fruit machine.

Create an Enum that holds some of the classic fruit machine symbols - e.g Cherry, Bar, Bell, Seven... Each entry in the enum should have a corresponding integer value, winnings.

## MVP

Your FruitMachine class should be well tested, and should have a `spin()` method that returns an integer value - the amount of winnings from the Enum's value, if three identical symbols are spun. 

If three identical symbols aren't spun, you should return 0.

_Hint:_ Make sure you have method on your FruitMachine class that returns a random symbol. This will make the class easier to test using Mockito.

## Extensions

* Extend to 5 reels

## Advanced Extension
* Using console input and output allow the user to play the game by putting in coins. If 3 identical symbols are return the win amount should be a multiplier of the amount of coins you entered. eg. win amount for 3 cherries is 8 and if they put in three coins then the total win is 24.
* Allow for 10 spins per play.
* Accumulate your winnings per spin (if any)
* At the end of the game(spins) print out the winnings total or a message if they didn't win to indicate they won nothing this round.
* Include Exception handling that if you encounter a exception or perhaps multiple different types of exceptions it should elegantly print to screen a useful message rather than the default exception.

## Reminder
* Remember to git commit regularly and practice PR's in GitHub