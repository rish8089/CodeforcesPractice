//package Div2.D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WalkingBetweenHouses {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nks = br.readLine().split(" ");
        long n = Integer.parseInt(nks[0]);
        long k = Integer.parseInt(nks[1]);
        long s = Long.parseLong(nks[2]);
        long div = s / k;
        long rem = s % k;
        //max distance move
        long mmv = div + (rem > 0 ? 1 : 0);
        if (mmv + 1 > n || div < 1)
            System.out.println("NO");
        else {
            System.out.println("YES");
            long h = 1;
            StringBuilder ans = new StringBuilder();
            int cnt = 0;
            for (int i = 0; i < rem; i++) {
                if (cnt % 2 == 0) {
                    h = h + mmv;
                } else {
                    h = h - mmv;
                }
                ans.append(h).append(" ");
                cnt++;
            }
            for (int i = 0; i < k - rem; i++) {
                if (cnt % 2 == 0) {
                    h = h + div;
                } else {
                    h = h - div;
                }
                ans.append(h).append(" ");
                cnt++;
            }
            System.out.println(ans);
        }
    }
}
