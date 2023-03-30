//package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class PhoenixAndTowers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String[] nmx = br.readLine().split(" ");
            int n = Integer.parseInt(nmx[0]);
            int m = Integer.parseInt(nmx[1]);
            int x = Integer.parseInt(nmx[2]);
            String[] str = br.readLine().split(" ");
            List<Integer> h = new ArrayList<>();
            for (int i = 0; i < n; i++)
                h.add(Integer.parseInt(str[i]));
            PriorityQueue<Tower> pq = new PriorityQueue<>((t1, t2) -> Integer.compare(t1.height, t2.height));
            for (int i = 0; i < m; i++)
                pq.add(new Tower(0, i + 1));
            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                //find a tower of minimum height
                Tower minHeightTower = pq.poll();
                minHeightTower.height += h.get(i);
                res[i] = minHeightTower.idx;
                pq.add(minHeightTower);
            }
            StringBuilder ans = new StringBuilder();
            System.out.println("YES");
            for (int i = 0; i < n; i++)
                ans.append(res[i]).append(" ");
            System.out.println(ans);
            t--;
        }
    }

    private static class Tower {
        int height;
        int idx;

        Tower(int height, int idx) {
            this.height = height;
            this.idx = idx;
        }
    }
}
