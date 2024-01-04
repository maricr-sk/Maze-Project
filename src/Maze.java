import java.util.*;

public class Maze {
    Stack<Rat> stack;
    Rat rat;
    private int[][] maze;

    private static boolean[][] visited;

    enum Direction {

        North(0),
        South(1),
        East(2),
        West(3);

        private int direction;

        Direction(int d) {
            direction = d;
        }
    }

    public Maze(int[][] maze, int r, int c) {
        this.visited = new boolean[maze.length][maze[0].length];
        this.maze = maze;
        this.rat = new Rat(r, c);
        this.stack = new Stack<Rat>();
        visited[rat.getR()][rat.getC()] = true;
        stack.push(rat);
    }

    public boolean isValid(int r, int c) {
        if (r < 0 || c < 0) return false;
        if (r >= maze.length || c >= maze[0].length) return false;
        return true;
    }

    public void solve() {
        Rat nextMove = findD(rat);
        while (!stack.isEmpty() && maze[stack.peek().getR()][stack.peek().getC()] != -1 ) {
            if (foo(stack.peek(), nextMove)) {
                while (!stack.isEmpty() && visited[nextMove.getR()][nextMove.getC()]) { // && visited[nextMove.getX()][nextMove.getY()]
                    stack.pop();
                    nextMove = findD(nextMove);
                }
            } else {
                rat = nextMove;
                nextMove = findD(nextMove);
                stack.push(rat);
            }
            //check to see if the new coordinates that is provided is already in the stack
            //if it is, you need pop until you get back to the last intersection
            //if there is no intersection that means its unsolvable
            //visited array - we need to check if the coordinates they go to is "true"
        }

        if (maze[rat.getR()][rat.getC()] == -1) {
            printSolution();
        } else {
            System.out.println("UNSOLVABLE");
        }
    }
    //make a stack of rats
    // need a visited matrix
    // 0 is blocked
    //1 is open
    // -1 is cheese

    public void printSolution() {
        Stack<Rat> temp = new Stack<Rat>();
        while (!stack.isEmpty()) {
            temp.push(this.stack.pop());
        }
        while (!temp.isEmpty()) {
            System.out.print(temp.pop());
            if(temp.size()>0){
                System.out.print("->");
            }
        }
        System.out.println();
    }


    public Rat findD(Rat r) {
        //return a rat to keep track of coordinate

        if (isValid(r.getR() + 1, r.getC()) && maze[r.getR() + 1][r.getC()] != 0 && !visited[r.getR() + 1][r.getC()]) {
            visited[r.getR() + 1][r.getC()] = true;
            r.setDirection(Direction.North);
            return new Rat(r.getR() + 1, r.getC());
        } else if ((isValid(r.getR(), r.getC() + 1) && maze[r.getR()][r.getC() + 1] != 0) && !visited[r.getR()][r.getC() + 1]) {
            visited[r.getR()][r.getC() + 1] = true;
            r.setDirection(Direction.East);
            return new Rat(r.getR(), r.getC() + 1);
        } else if ((isValid(r.getR() - 1, r.getC()) && maze[r.getR() - 1][r.getC()] != 0) && !visited[r.getR() - 1][r.getC()]) {
            visited[r.getR() - 1][r.getC()] = true;
            r.setDirection(Direction.South);
            return new Rat(r.getR() - 1, r.getC());
        } else if ((isValid(r.getR(), r.getC() - 1) && maze[r.getR()][r.getC() - 1] != 0) && !visited[r.getR()][r.getC() - 1]) {
            visited[r.getR()][r.getC() - 1] = true;
            r.setDirection(Direction.West);
            return new Rat(r.getR(), r.getC() - 1);
        }
        return r;
    }

    public boolean foo(Rat r, Rat t) { return r.getR() == t.getR() && r.getC() == t.getC(); }
}