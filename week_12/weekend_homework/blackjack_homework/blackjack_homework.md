## Weekend Homework - Blackjack

:star: This is a PDA Homework :star:


Extend your High/Low card game
Using your existing code (fork it!) simulate a game of "BlackJack".

To start off with you should be working in a TDD fashion and creating tests for your classes.

## MVP

- Deal two cards to a dealer and a player
- Compare the hands
- Determine the winner from who has the highest value hand

## Extension

- Allow the player to "twist" or "stick" (Player go bust if hand value exceeds 21 and they automatically lose the round).
- Dealer will twist if hand < 16
- Compare hands once both dealer and player have stuck.
- Allow for more players to play.


### BlackJack rules

- Aces may be counted as 1 or 11 points, 2 to 9 according to card value, and tens and face cards count as ten points.

- The value of a hand is the sum of the point values of the individual cards.

- Except, a "blackjack" is the highest hand, consisting of an ace and any 10-point card, and it outranks all other 21-point hands.

- To start dealer will give two cards to each player and two cards to himself. One of the dealer cards is dealt face up.

- Play begins with the player to the dealer's left. The following are the choices available to the player:
  * Stand: Player stands pat with his cards.
  * Twist: Player draws another card (and more if he wishes). If this card causes the player's total points to exceed 21 (known as "breaking" or "busting") then he loses.
- After each player has had his turn, the dealer will turn over his hole card. If the dealer has 16 or less, then he will draw another card.

- If the dealer goes over 21 points, then any player who didn't already bust will win.

- If the dealer does not bust, then the higher point total between the player and dealer will win.



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

- Go to your [PDA Checklist](https://github.com/codeclan/pda/tree/master/Evidence%20Gathering%20Portfolio)

- Submit your PDA evidence (screenshots, etc.) to your own PDA repo

- PDA Reference: I.T 1, P18
