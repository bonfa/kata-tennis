# kata-tennis in TDD

Tennis kata solved in TDD.
The specifications of the exercise and some personal comments follow.
As usual in these kata, also the commit sequence may be of interest.

## kata-tennis specifications

This Kata is about implementing a simple tennis game. I came up with it while thinking about Wii tennis, where they have
simplified tennis, so each set is one game.

The scoring system is rather simple:

Each player can have either of these points in one game “love” “15” “30” “40”

- If you have 40, and you win the point you win the game, however there are special rules.
- If both have 40 the players are “deuce”.
- If the game is in deuce, the winner of a point will have advantage
- If the player with advantage wins the ball he wins the game
- If the player without advantage wins they are back at deuce.

Source here: https://codingdojo.org/kata/Tennis/

## personal comments on the exercise

I started by increasing the points of a single player, then of the other.
This helped me isolate the basic logic to format the points of one player.
Later I found out that probably I could have started immediately with the points
of both players as I had to write several tests similar to what I haad already
written for one player.
After the first complete implementation, I tried to separate the "business logic"
of keeping the score from the "formatting".
Another attempt I made was to represent the game score through a set of states,
each one leading to the next one basing on which player would score. 