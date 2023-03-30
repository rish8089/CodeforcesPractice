//package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddOne {
    private static int MOD = 1000000007;
    private static int LIM = 200000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        long[][] dp = new long[LIM + 1][10];
        dp[0][9] = 1;
        for (int i = 1; i <= LIM; i++) {
            for (int j = 0; j < 10; j++) {
                if (j < 9)
                    dp[i][j + 1] = dp[i - 1][j];
                else {
                    dp[i][1] = dp[i][1] + dp[i - 1][9];
                    dp[i][0] = dp[i][0] + dp[i - 1][9];
                    if(dp[i][0]>=MOD)
                        dp[i][0]%=MOD;
                    if(dp[i][1]>=MOD)
                        dp[i][1]%=MOD;
                }
            }
        }
        long []res = new long[LIM + 1];
        for (int i = 0; i <= LIM; i++) {
            long cnt = 0;
            for (int j = 0; j < 10; j++) {
                cnt = cnt + dp[i][j];
                if(cnt>=MOD)
                    cnt%=MOD;
            }
            res[i] = cnt;
        }
        StringBuilder ans=new StringBuilder();
        while (t > 0) {
            String[] nm = br.readLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);
            long cnt = 0;
            while (n > 0) {
                int x = n % 10;
                if (m < 9 - x)
                    cnt = cnt + 1;
                else
                    cnt = cnt + res[m - 9 + x];
                if (cnt >= MOD)
                    cnt %= MOD;
                n /= 10;
            }
            ans.append(cnt).append("\n");
            t--;
        }
        System.out.println(ans);
    }
}
