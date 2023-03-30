//package Div2.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AndItsNonZero {
    private static int LIM=200000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [][]cnt=new int[LIM+1][32];
        for (int i = 1; i <= LIM; i++) {
            for (int j = 0; j < 32; j++) {
                cnt[i][j]=cnt[i-1][j];
                if (((1 << j) & i) == 0){
                    cnt[i][j]+=1;
                }
            }
        }
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String[] lr = br.readLine().split(" ");
            int l = Integer.parseInt(lr[0]);
            int r = Integer.parseInt(lr[1]);
            int nb = getNoOfBits(r);

            int ans = -1;
            for (int i = 0; i < nb; i++) {
                if (ans == -1 || ans > cnt[r][i]-cnt[l-1][i])
                    ans = cnt[r][i]-cnt[l-1][i];
            }
            System.out.println(ans);
            t--;
        }
    }

    private static int getNoOfBits(int x) {
        int cnt = 0;
        while (x > 0) {
            cnt = cnt + 1;
            x /= 2;
        }
        return cnt;
    }
}
