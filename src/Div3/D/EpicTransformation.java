//package Div3.D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class EpicTransformation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = Integer.parseInt(str[i]);
            Map<Integer, Integer> mp = new HashMap<>();
            for (int i = 0; i < n; i++) {
                if (!mp.containsKey(a[i]))
                    mp.put(a[i], 1);
                else
                    mp.put(a[i], mp.get(a[i]) + 1);
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for (int key : mp.keySet())
                pq.add(mp.get(key));
            int elementsRemoved = 0;
            while (pq.size() > 1) {
                int val1 = pq.poll();
                int val2 = pq.poll();
                elementsRemoved += 2;
                val1 -= 1;
                val2 -= 1;
                if (val1 > 0)
                    pq.add(val1);
                if (val2 > 0)
                    pq.add(val2);
            }
            System.out.println(n - elementsRemoved);
            t--;
        }
    }
}
