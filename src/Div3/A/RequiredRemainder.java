package Div3.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RequiredRemainder {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); //no of test cases
        while (t > 0) {
            String[] str = br.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            int n = Integer.parseInt(str[2]);
            int div = n / x;
            if (div * x + y <= n) {
                System.out.println(div * x + y);
            } else {
                System.out.println((div - 1) * x + y);
            }
            t--;
        }
    }
}
