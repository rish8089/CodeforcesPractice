//package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PaintTheArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = Long.parseLong(str[i]);
            //d dividing odd position numbers and not dividing even position number
            long res = a[0];
            for (int i = 2; i < n; i += 2) {
                res = gcd(res, a[i]);
            }
            boolean flag = true;
            for (int i = 1; i < n; i += 2) {
                if (a[i] % res == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println(res);
            } else {
                res = a[1];
                for (int i = 3; i < n; i += 2) {
                    res = gcd(res, a[i]);
                }
                flag = true;
                for (int i = 0; i < n; i += 2) {
                    if (a[i] % res == 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag)
                    System.out.println(res);
                else
                    System.out.println(0);
            }
            t--;
        }
    }

    private static long gcd(long a, long b) {
        if (b == 0)
            return a;
        else return gcd(b, a % b);
    }
}
