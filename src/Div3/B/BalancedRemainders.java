package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BalancedRemainders {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = Integer.parseInt(str[i]);
            int[] c = new int[3];
            for (int i = 0; i < n; i++)
                c[a[i] % 3]++;

            int cnt = 0;//will change to 3 once all gets balanced
            int i = 0;
            int equalVal = n / 3;
            int moves = 0;
            while (cnt != 3) {
                if (c[i] > equalVal) {
                    c[(i + 1) % 3] = c[(i + 1) % 3] + c[i] - equalVal;
                    moves += c[i] - equalVal;
                    c[i] = equalVal;
                }
                if (c[i] == equalVal)
                    cnt++;
                i = (i + 1) % 3;
            }
            System.out.println(moves);
            t--;
        }
    }
}
