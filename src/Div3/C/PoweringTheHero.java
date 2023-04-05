//package Div3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class PoweringTheHero {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = Integer.parseInt(str[i]);
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            long ans = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] == 0) {
                    if(!pq.isEmpty())
                        ans+=pq.poll();
                } else {
                    pq.add(a[i]);
                }
            }
            System.out.println(ans);
            t--;
        }
    }
}
