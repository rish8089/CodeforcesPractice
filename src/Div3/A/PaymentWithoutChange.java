package Div3.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PaymentWithoutChange {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); //no of test cases
        while(t>0) {
            String []str = br.readLine().split(" ");
            int a,b,n,S;
            a = Integer.parseInt(str[0]);
            b= Integer.parseInt(str[1]);
            n = Integer.parseInt(str[2]);
            S = Integer.parseInt(str[3]);

            int na = Math.min(a, S / n); //no of a coins for exchange
            if (S - na * n > b) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
            t--;
        }
    }
}
