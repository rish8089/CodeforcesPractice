package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SnowWalkingRobot {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String path = br.readLine();
            int l, r, u, d;
            l = r = u = d = 0;
            for (int i = 0; i < path.length(); i++) {
                char c = path.charAt(i);
                if (c == 'L')
                    l = l + 1;
                else if (c == 'R')
                    r = r + 1;
                else if (c == 'U')
                    u = u + 1;
                else
                    d = d + 1;
            }
            int minLR = Math.min(l, r);
            int minUD = Math.min(u, d);
            int cnt;
            StringBuilder res = new StringBuilder();
            if (minLR > 0 && minUD > 0) {
                cnt = 2 * (minLR + minUD);
                repeat(res, 'L', minLR);
                repeat(res, 'U', minUD);
                repeat(res, 'R', minLR);
                repeat(res, 'D', minUD);
            } else {
                if (minLR > 0) {
                    cnt = 2;
                    res.append("LR");
                } else if (minUD > 0) {
                    cnt = 2;
                    res.append("UD");
                } else {
                    cnt = 0;
                }
            }
            System.out.println(cnt);
            if (cnt > 0) {
                System.out.println(res.toString());
            }
            t--;
        }
    }
    private static void repeat(StringBuilder res, char c, int n) {
        for(int i = 0; i< n; i++) {
            res.append(c);
        }
    }
}
