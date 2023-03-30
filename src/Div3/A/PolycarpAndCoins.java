package Div3.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PolycarpAndCoins {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); //no of test cases
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            if (n % 3 == 0) {
                System.out.println(n / 3 + " " + n / 3);
            } else {
                if (n % 3 == 1)
                    System.out.println((n / 3 + 1) + " " + n / 3);
                else
                    System.out.println(n / 3 + " " + (n / 3 + 1));
            }
            t--;
        }
    }
}
