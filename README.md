# Clock-Solitaire
Okay so I got bored and wondered how likely is someone to win clock solitaire, so I made this whole convoluted simulation program instead of just googling it like a normal person. Compile everything, run the Runner.java file, and the fraction it spits out at the end is your answer (experimental value for winning liklihood).

The Game:
  To actually play the game, you shuffle a standard deck (no jokers) and place them into 13 even groups of 4 in a clock-like fashion with one stack in the middle. The goal is to flip over all the cards A-Q before flipping over the last king. Start by flipping the top card from the middle stack over. Then place it on top of its respective stack (A where 1'oclock is, 2 where 2'oclock is,..., J where 11'oclock is, Q ... 12'oclock, and K in the middle. Then pull a new card from the stack you just placed the previous card under.
  
The Results:
  As it turns out (un)surprisingly, the odds of winning this deterministic game are 1/13 or 7.6923%
  There are 13 cards in a suit, so I guess that makes sense.
