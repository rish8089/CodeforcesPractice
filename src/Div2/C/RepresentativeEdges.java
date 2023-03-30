//package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RepresentativeEdges {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = Integer.parseInt(str[i]);
            int minOperations = n - 1;

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int diff = a[j] - a[i];
                    int g = gcd(diff, j - i);
                    int num = diff / g;
                    int den = (j - i) / g;
                    int cnt = 0;
                    for (int k = 0; k < i; k++) {
                        int fracNum = den * a[k] + (i - k) * num;
                        int fracDen = den;
                        g = gcd(fracNum, fracDen);
                        fracNum = fracNum / g;
                        fracDen = fracDen / g;
                        if (fracDen != 1 || fracNum != a[i])
                            cnt++;

                    }
                    for (int k = i + 1; k < n; k++) {
                        int fracNum = den * a[i] + (k - i) * num;
                        int fracDen = den;
                        g = gcd(fracNum, fracDen);
                        fracNum = fracNum / g;
                        fracDen = fracDen / g;
                        if (fracDen != 1 || fracNum != a[k])
                            cnt++;
                    }
                    if (minOperations > cnt)
                        minOperations = cnt;
                }
            }
            System.out.println(minOperations);

            t--;
        }
    }

    private static int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

}
