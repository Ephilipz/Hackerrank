/**
 * Created by Eesaa on 11/10/2017.
 */

import java.util.*;

public class onceInATram {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt() + 1;
        while(!sumsEqual(x)) {
            x++;
        }
        System.out.println(x);
        in.close();
    }

     private static int sumDigits(int i) {
        return i == 0 ? 0 : i % 10 + sumDigits(i / 10);
    }

     private static boolean sumsEqual(int n)
    {
        String s = Integer.toString(n);
        int sumF = Integer.parseInt(s.substring(0,3)), sumS = Integer.parseInt(s.substring(3));
        sumF = sumDigits(sumF);
        sumS = sumDigits(sumS);
        return sumF == sumS;

    }
}
