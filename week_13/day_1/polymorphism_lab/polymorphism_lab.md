# Polymorphism - Lab
Duration: 45 - 60 minutes.

Take the start code and have a look through it. You will see that there is a `Wallet` class which has ___four___ ArrayLists, one each for `DebitCard`s, `CreditCard`s, `LoyaltyCard`s and `Ticket`s. This code is a bit smelly so you are going to use polymorphism to freshen it up.

## MVP

Create an `IScan` interface and have all the classes implement it. This interface should have a `Scan` method which has no parameters and returns a `String`.

Replace the four ArrayLists with one ArrayList which contains all the items in the wallet. Which type will this ArrayList contain?

Replace all the overloaded versions of the `addItem` method with one method which adds an item to the newly created ArrayList. 

## Extension

Question:
Thinking of the `DebitCard` and `CreditCard` classes and that there are things common to both classes, can you think of a way to refactor the code so that the common code is in one place, but not breaking the refactoring you've already done.

If you want to, and have time, have a go at this refactor.

