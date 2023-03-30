package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimumProduct {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); //no of test cases
        while(t>0){
            String []str=br.readLine().split(" ");
            long a = Long.parseLong(str[0]);
            long b = Long.parseLong(str[1]);
            long x = Long.parseLong(str[2]);
            long y = Long.parseLong(str[3]);
            long n = Long.parseLong(str[4]);

            long mina = Math.max(a-n,x);
            long minb = Math.max(b-n,y);
            if(mina<=minb){
                System.out.println(minimumProduct(mina, b, y, n-(a-mina)));
            }else {
                System.out.println(minimumProduct(minb, a, x, n-(b-minb)));
            }
            t--;
        }
    }

    private static long minimumProduct(long mina, long b, long y, long n){
        return mina*Math.max(b-n,y);
    }
}
