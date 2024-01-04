
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());

        for(int i = 0; i < num; ++i){ //number of test cases
            String [] dimen = scan.nextLine().split(" ");
            int [][] mazeArray = new int [Integer.parseInt(dimen[0])]
                    [Integer.parseInt(dimen[1])];

            for(int r  = 0; r < Integer.parseInt(dimen[0]); ++r){
                String [] array = scan.nextLine().split(" ");
                for(int c = 0; c < array.length; ++c){
                    mazeArray[r][c] = Integer.parseInt(array[c]);
                }
            }
            Maze maze1 = new Maze(mazeArray, 0, 0);
            maze1.solve();
        }
    }
}