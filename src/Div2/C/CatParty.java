//package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CatParty {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(str[i]);
        int ans = 0;
        Map<Integer, Integer> mp = new LinkedHashMap<>();
        Map<Integer, Integer> rmp = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            if (!mp.containsKey(a[i]))
                mp.put(a[i], 1);
            else
                mp.put(a[i], mp.get(a[i]) + 1);

            //updating the latest count
            int cnt = mp.get(a[i]);
            if (!rmp.containsKey(cnt))
                rmp.put(cnt, 1);
            else
                rmp.put(cnt, rmp.get(cnt) + 1);

            //removing the old count
            if (rmp.containsKey(cnt - 1)) {
                if (rmp.get(cnt - 1) == 1)
                    rmp.remove(cnt - 1);
                else
                    rmp.put(cnt - 1, rmp.get(cnt - 1) - 1);
            }

            if (rmp.size() == 1) {
                Set<Integer> s = rmp.keySet();
                Iterator<Integer> it = s.iterator();
                int first = it.next();
                if (first == 1 || rmp.get(first) == 1)
                    ans = i + 1;
            } else if (rmp.size() == 2) {
                Set<Integer> s = rmp.keySet();
                Iterator<Integer> it = s.iterator();
                int first = it.next();
                int second = it.next();
                if (rmp.get(first) == 1 || rmp.get(second) == 1) {
                    if (rmp.get(first) == 1) {
                        if (first == 1 || first - second == 1) {
                            ans = i + 1;
                        }
                    }
                    if (rmp.get(second) == 1) {
                        if (second == 1 || second - first == 1) {
                            ans = i + 1;
                        }
                    }
                }

            }
        }
        System.out.println(ans);
    }

    private static int abs(int val) {
        return val < 0 ? -val : val;
    }
}
