//package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BalancedStoneHeaps {
    private static int LIM = 2000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = Integer.parseInt(str[i]);
            int[] b = new int[n];
            for (int i = 0; i < n; i++)
                b[i] = a[i];
            int u = 1;
            int v = LIM;
            int ans = -1;
            while (u <= v) {
                int mid = u + (v - u) / 2;
                if (canMinBeEqualToX(mid, a, b)) {
                    ans = mid;
                    u = mid + 1;
                } else {
                    v = mid - 1;
                }
            }
            System.out.println(ans);
            t--;
        }
    }

    private static boolean canMinBeEqualToX(int x, int[] a, int[] b) {
        int n = a.length;
        for (int i = 0; i < n; i++)
            a[i] = b[i];
        for (int i = 2; i < n; i++) {
            if (a[i - 2] < x || a[i - 1] < x) {
                int minD = Integer.min(a[i] / 3 * 3 / 3, Integer.max((x - a[i - 2] + 1) / 2, x - a[i - 1]));
                a[i - 1] = a[i - 1] + minD;
                a[i - 2] = a[i - 2] + 2 * minD;
                a[i] = a[i] - 3 * minD;
            }
        }
        for (int i = 0; i < n; i++) {
            if (a[i] < x)
                return false;
        }
        return true;
    }
}
