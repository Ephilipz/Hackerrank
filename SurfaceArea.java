/**
 * Created by Eesaa on 11/15/2017.
 */

import java.util.*;

public class SurfaceArea {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int H = in.nextInt();
        int W = in.nextInt();
        int[][] A = new int[H][W];
        for (int A_i = 0; A_i < H; A_i++) {
            for (int A_j = 0; A_j < W; A_j++) {
                A[A_i][A_j] = in.nextInt();
            }
        }
        int result = surfaceArea(A);
        System.out.println(result);
        in.close();
    }

    static int surfaceArea(int[][] A) {
        if(A.length==1 && A[0].length==1)
            return A[0][0]*6;
        int res = A.length * A[0].length * 2; //bottom and top rectangle area
        ArrayList <Integer> oneD = new ArrayList<>();
        if(A.length==1 || A[0].length==1) //one dimensional horizontal array
        {
            if(A.length==1) {
                for (int i = 0; i < A[0].length; i++) {
                    oneD.add(A[0][i]);
                }
            }
            else {
                for (int i = 0; i < A.length; i++) {
                    oneD.add(A[i][0]);
                }
            }

            for (int i = 0; i < oneD.size(); i++) {
                if(i==0)//first number
                {
                    int curr = oneD.get(i),right = oneD.get(i+1);
                    res+=curr*3;
                    if(curr>right)res+=curr-right;
                }
                else if (i==oneD.size()-1)//last number
                {
                    int curr = oneD.get(i), left = oneD.get(i-1);
                    res+=curr*3;
                    if(curr>left)res+=curr-left;
                }
                else //middle
                {
                    int curr = oneD.get(i), left = oneD.get(i-1), right = oneD.get(i+1);
                    res+=curr*2;
                    if(curr>left)res+=curr-left;
                    if(curr>right)res+=curr-right;
                }
            }
        }
        else {
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[0].length; j++) {
                    //check if it's a corner piece (2 surrounding numbers )
                    if ((i == 0 && j == 0 && A.length != 1)) {
                        res += A[i][j] * 2;
                        int right = A[0][j + 1], bottom = A[1][0];
                        if (A[i][j] > right) res += (A[i][j] - right);
                        if (A[i][j] > bottom) res += (A[i][j] - bottom);
                    } else if (i == 0 && j == A[0].length - 1) {
                        int left = A[0][j - 1], bottom = A[1][j];
                        res += A[i][j] * 2;
                        if (A[i][j] > left) res += (A[i][j] - left);
                        if (A[i][j] > bottom) res += (A[i][j] - bottom);
                    } else if (i == A.length - 1 && j == 0) {
                        res += A[i][j] * 2;
                        int right = A[i][j + 1], top = A[i - 1][j];
                        if (A[i][j] > right) res += (A[i][j] - right);
                        if (A[i][j] > top) res += (A[i][j] - top);
                    } else if (i == A.length - 1 && j == A[0].length - 1) {
                        res += A[i][j] * 2;
                        int top = A[i - 1][j], left = A[i][j - 1];
                        if (A[i][j] > left) res += (A[i][j] - left);
                        if (A[i][j] > top) res += (A[i][j] - top);
                    }

                    //check if it's side piece (3 surrounding numbers)
                    else if (j == 0) //left edge
                    {
                        res += A[i][j];
                        int top = A[i - 1][0], right = A[i][j + 1], bottom = A[i + 1][0];
                        if (A[i][j] > top) res += (A[i][j] - top);
                        if (A[i][j] > right) res += (A[i][j] - right);
                        if (A[i][j] > bottom) res += (A[i][j] - bottom);
                    } else if (i == A.length - 1) //bottom edge
                    {
                        res += A[i][j];
                        int top = A[i - 1][j], left = A[i][j - 1], right = A[i][j + 1];
                        if (A[i][j] > top) res += (A[i][j] - top);
                        if (A[i][j] > right) res += (A[i][j] - right);
                        if (A[i][j] > left) res += (A[i][j] - left);
                    } else if (j == A[0].length - 1) //right edge
                    {
                        res += A[i][j];
                        int top = A[i - 1][j], bottom = A[i + 1][j], left = A[i][j - 1];
                        if (A[i][j] > left) res += (A[i][j] - left);
                        if (A[i][j] > top) res += (A[i][j] - top);
                        if (A[i][j] > bottom) res += (A[i][j] - bottom);
                    } else if (i == 0) //top edge
                    {
                        res += A[i][j];
                        int bottom = A[i + 1][j], left = A[i][j - 1], right = A[i][j + 1];
                        if (A[i][j] > left) res += (A[i][j] - left);
                        if (A[i][j] > right) res += (A[i][j] - right);
                        if (A[i][j] > bottom) res += (A[i][j] - bottom);
                    }

                    //in the middle
                    else {
                        int bottom = A[i + 1][j], left = A[i][j - 1], right = A[i][j + 1], top = A[i - 1][j];
                        if (A[i][j] > left) res += (A[i][j] - left);
                        if (A[i][j] > right) res += (A[i][j] - right);
                        if (A[i][j] > bottom) res += (A[i][j] - bottom);
                        if (A[i][j] > top) res += (A[i][j] - top);
                    }
                }
            }
        }
        return res;
    }
}
