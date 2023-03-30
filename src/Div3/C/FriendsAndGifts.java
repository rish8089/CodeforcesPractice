package Div3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FriendsAndGifts {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(str[i]);
        List<Integer> givers = new ArrayList<>();
        Set<Integer> receivers = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            if (a[i] == 0)
                givers.add(i + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++)
            set.add(a[i]);
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i))
                receivers.add(i);
        }
        for (int i = 0; i < givers.size(); i++) {
            int giver = givers.get(i);
            if (receivers.contains(giver)) {
                receivers.remove(giver);
                a[giver - 1] = receivers.iterator().next();
                receivers.add(giver);
                receivers.remove(a[giver-1]);
            }
        }
        for(int i=0;i<givers.size();i++){
            int giver = givers.get(i);
            if(a[giver-1]==0) {
                a[giver - 1] = receivers.iterator().next();
                receivers.remove(a[giver - 1]);
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            ans.append(a[i]).append(" ");
        }
        System.out.println(ans);
    }
}
