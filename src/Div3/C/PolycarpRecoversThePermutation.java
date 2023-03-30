//package Div3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PolycarpRecoversThePermutation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            List<Integer> a = new ArrayList<>();
            String[] str = br.readLine().split(" ");
            for (int i = 0; i < n; i++)
                a.add(Integer.parseInt(str[i]));
            int max = 0;
            for (int i = 0; i < n; i++) {
                max = Integer.max(max, a.get(i));
            }
            if (a.get(0) == max || a.get(n - 1) == max) {
                StringBuilder ans = new StringBuilder();
                List<Integer> res = new ArrayList<>();
                if (max == a.get(0)) {
                    res.add(a.get(0));
                    for (int i = n - 1; i > 0; i--)
                        res.add(a.get(i));
                } else {
                    for (int i = n - 2; i >= 0; i--)
                        res.add(a.get(i));
                    res.add(a.get(n - 1));
                }
                for (int num : res)
                    ans.append(num).append(" ");
                System.out.println(ans);
            } else {
                System.out.println(-1);
            }
            t--;
        }
    }
}
