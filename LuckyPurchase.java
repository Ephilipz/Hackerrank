/**
 * Created by Eesaa on 11/13/2017.
 */

import java.util.*;

public class LuckyPurchase {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), minprice;
        ArrayList <Integer> prices = new ArrayList<>();
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = in.next();
            int price = in.nextInt();
            if(isMirror(price) && price > 0) {
                prices.add(price);
                map.put(price, name);
            }
        }
        if(prices.isEmpty())
        {
            System.out.println(-1);
            return;
        }
        minprice = Collections.min(prices);
        System.out.println(!map.get(minprice).isEmpty()?map.get(minprice):-1);
        in.close();
    }

    static boolean isMirror(int n)
    {
        int count7=0, count4=0;
        String s = Integer.toString(n);
        for(char c : s.toCharArray())
        {
            if(c!='7'&&c!='4')return false;
            if(c=='7')count7++;
            if(c=='4')count4++;
        }
        return count4==count7 && count4 !=0;
    }
}
