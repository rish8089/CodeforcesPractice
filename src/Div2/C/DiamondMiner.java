//package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiamondMiner {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0) {
            int n = Integer.parseInt(br.readLine());
            List<Integer> diamonds = new ArrayList<>();
            List<Integer> miners = new ArrayList<>();
            for (int i = 1; i <= 2 * n; i++) {
                String[] xy = br.readLine().split(" ");
                int x = Integer.parseInt(xy[0]);
                int y = Integer.parseInt(xy[1]);
                if (x == 0)
                    miners.add(y<0?-y:y);
                else
                    diamonds.add(x<0?-x:x);
            }
            Collections.sort(diamonds);
            Collections.sort(miners);
            double ans = 0;
            for (int i = 0; i < n; i++)
                ans += Math.sqrt((long)miners.get(i) * miners.get(i) + (long)diamonds.get(i) * diamonds.get(i));
            System.out.println(ans);
            t--;
        }
    }
}
