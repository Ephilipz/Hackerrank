/**
 * Created by Eesaa on 11/2/2017.
 */

import java.util.*;
import java.util.regex.*;

public class strongPassword {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String password = in.next();
        int answer = minimumNumber(n, password);
        System.out.println(answer);
        in.close();
    }

    private static int minimumNumber(int n, String password)
    {
        int res = 0;
        boolean hasNumber, hasSpecial, hasLower, hasUpper;
        //check if string has number
        hasNumber = password.matches(".*\\d+.*");

        //check if string has special
        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(password);
        hasSpecial = p.matcher(password).find();

        //check if string has lower case letters
        hasLower = password.matches(".*[a-z].*");

        //check if string has uppercase
        hasUpper = password.matches(".*[A-Z].*");

        boolean isPassword = hasLower && hasUpper && hasSpecial && hasNumber;
        if(isPassword)
            return password.length()<6?6-password.length():0;
        if(!hasNumber)res++;
        if(!hasLower)res++;
        if(!hasSpecial)res++;
        if(!hasUpper)res++;
        int len = res+password.length();
        return len<6?res+(6-len):res;
    }
}
