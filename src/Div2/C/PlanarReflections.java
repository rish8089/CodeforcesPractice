package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlanarReflections {
    private static int LIM = 1000;
    private static int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        long[][] dp = new long[LIM + 1][LIM + 1];
        for (int i = 1; i <= LIM; i++) {
            for (int j = 0; j <= LIM; j++) {
                dp[i][j] = dp[i - 1][j] + mypow(i, j);
                if (dp[i][j] >= MOD)
                    dp[i][j] %= MOD;
            }
        }
        while (t > 0) {
            String[] nm = br.readLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            int k = Integer.parseInt(nm[1]);
            long res = 1;
            for (int i = 0; i < k - 1; i++) {
                if (i == 0)
                    res = res + n;
                else
                    res = res + dp[n - 1][i];
                if (res >= MOD)
                    res %= MOD;
            }
            System.out.println(res);
            t--;
        }
    }

    private static long mypow(int a, int b) {
        long base = a;
        long result = 1;
        while (b > 0) {
            if (b % 2 != 0) {
                result = (result * base) % MOD;
            }
            b = b >> 1;
            if (b > 0) {
                base = (base * base) % MOD;
            }
        }

        return result;
    }
}
