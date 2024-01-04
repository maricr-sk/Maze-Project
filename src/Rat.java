public class Rat {

    private int r, c;
    private Maze.Direction direction;

    public Rat(int r, int c){
        this.r = r;
        this.c = c;
        this.direction = Maze.Direction.North;
    }

    public int getR() { return r; }

    public void setR(int r) { this.r = r; }

    public int getC() { return c; }

    public void setC(int c) { this.c = c; }

    public Maze.Direction getDirection() { return direction; }

    public void setDirection(Maze.Direction direction) { this.direction = direction; }

    @Override public String toString(){ return "(" + this.r + "," + this.c + ")";}

}
