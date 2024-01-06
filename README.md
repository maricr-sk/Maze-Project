# Maze-Project
Directions: 
You must create code to guide a rat through a maze to find a piece of cheese which is indicated by a value of -1. In the maze value of 1 means a location that can be occupied by the rat whereas a zero value indicates a square that is blocked, and as such, cannot be occupied. 

The rat should always start in position (0,0) in the maze. This is the upper left corner of the maze. You must use a manual stack to track the position of the mouse and where it has been. You must do a depth first search by checking if the cheese can be located by moving NORTH, WEST, SOUTH, or EAST. In this algorithm, you need to keep track of a visited matrix that will tell you if the square you want to go to has already been exhausted earlier in the search. 

Note that the algorithm for this lab does NOT involve recursion. Instead, we are creating and maintaining a stack manually to find a solution. You only need to find one solution or state in your program if no solution exists by printing the word "UNSOLVABLE".

The solution/output for that matrix is:

(0,0)->(1,0)->(1,1) -> (2,1)->(3,1)->(3,2)->(3,3)->(2,3) 
