//package Div2.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class CommonSubsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String[] nm = br.readLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);
            int[] a = new int[n];
            int[] b = new int[m];
            String[] str = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            str = br.readLine().split(" ");
            for (int i = 0; i < m; i++)
                b[i] = Integer.parseInt(str[i]);
            Set<Integer> s = new HashSet<>();
            for (int i = 0; i < m; i++)
                s.add(b[i]);
            boolean flag = false;
            int ans = -1;
            for (int i = 0; i < n; i++) {
                if (s.contains(a[i])) {
                    flag = true;
                    ans = a[i];
                    break;
                }
            }
            if (!flag)
                System.out.println("NO");
            else {
                System.out.println("YES");
                System.out.format("%d %d\n", 1, ans);
            }
            t--;
        }
    }
}
