package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class SocialNetworkB1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        String[] str = br.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(str[i]);
        Deque<Integer> dq = new LinkedList<>();
        Map<Integer, Boolean> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!mp.containsKey(a[i])) {
                if (dq.size() >= k) {
                    mp.remove(dq.peekLast());
                    dq.removeLast();
                }
                mp.put(a[i], true);
                dq.addFirst(a[i]);
            }
        }
        System.out.println(dq.size());
        for (int e : dq)
            System.out.print(e + " ");
        System.out.println();
    }
}
