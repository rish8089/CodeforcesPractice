package Div3.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StoneGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            int min = -1;
            int minIdx = -1;
            for (int i = 0; i < n; i++) {
                if (min == -1 || min > a[i]) {
                    min = a[i];
                    minIdx = i;
                }
            }
            int max = -1;
            int maxIdx = -1;
            for (int i = 0; i < n; i++) {
                if (max == -1 || max < a[i]) {
                    max = a[i];
                    maxIdx = i;
                }
            }
            int m1 = Math.max(minIdx, maxIdx) + 1;
            int m2 = Math.max(n - minIdx, n - maxIdx);
            int m3;
            if (minIdx < maxIdx) {
                m3 = (minIdx + 1) + n - maxIdx;
            } else {
                m3 = (maxIdx + 1) + n - minIdx;
            }
            System.out.println(Math.min(Math.min(m1, m2), m3));
            t--;
        }
    }
}
