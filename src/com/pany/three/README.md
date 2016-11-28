Summary
=======
Attempted on 2016-11-28.

Problem
=======
Either connect 4 problem ~~or dependency tree~~

Given a 2D array, find four in a row of either `x` or `o`
- vertically
- horizontally
- diagonally

```
(0,7)               (7,7)
     +-+-+-+-+-+-+-+
     | | | | | | | |
     +-+-+-+-+-+-+-+
     | | | | |o|x| |
     +-+-+-+-+-+-+-+
     |x| |o| |x|o| |
     +-+-+-+-+-+-+-+
     |x|x|x|o|x|x| |
     +-+-+-+-+-+-+-+
     |o|o|x|o|o|o|x|
     +-+-+-+-+-+-+-+
     |x|x|o|x|o|o|x|
     +-+-+-+-+-+-+-+
(x,y)               (7,0)
```
So, in the above example, algorithm should detect `((0,3),(1,2),(2,1),(3,0))` as four diagonal `x`s

1 hour to do the easiest, most dirty brute force algorithm. Next commit should start the clock.


Post-Mortem
===========
Not done yet.

1. `fake`, [started](https://github.com/ma-al/qad-java/commit/)
2. `fake`, [time-up](https://github.com/ma-al/qad-java/commit/)
3. `fake`, [stopped](https://github.com/ma-al/qad-java/commit/)