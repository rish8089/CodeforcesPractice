//package Div2.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DivideAndMultiply {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = Integer.parseInt(str[i]);
            int operations = 0;
            for (int i = 0; i < n; i++) {
                int power = 0;
                while (a[i] % 2 == 0) {
                    power += 1;
                    a[i] /= 2;
                }
                operations += power;
            }
            int max = 0;
            int maxIdx = -1;
            for (int i = 0; i < n; i++) {
                if (a[i] % 2 != 0 && max < a[i]) {
                    max = a[i];
                    maxIdx = i;
                }
            }
            long sum = max * (1L << operations);
            for (int i = 0; i < n; i++) {
                if (maxIdx != i)
                    sum += a[i];
            }
            System.out.println(sum);

            t--;
        }
    }
}
