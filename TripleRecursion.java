/**
 * Created by Eesaa on 11/14/2017.
 */

import java.util.*;

public class TripleRecursion {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt(), topLeft=in.nextInt(), step = in.nextInt();
        int[][] grid = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(i==0 && j==0)
                    grid[i][j]=topLeft;
                else if(i==j)
                    grid[i][j] = grid[i-1][j-1] + step;
                else if(i>j)
                    grid[i][j]=grid[i-1][j]-1;
                else if(i<j)
                    grid[i][j]=grid[i][j-1]-1;
            }
        }
        printMatrix(grid);
        in.close();
    }
    static void printMatrix(int[][] grid) {
        for(int r=0; r<grid.length; r++) {
            for(int c=0; c<grid[r].length; c++)
                System.out.print(grid[r][c] + " ");
            System.out.println();
        }
    }
}
