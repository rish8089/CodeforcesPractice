//package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BerlandRegional {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            int[] u = new int[n];
            for (int i = 0; i < n; i++)
                u[i] = Integer.parseInt(str[i]);
            int[] skill = new int[n];
            str = br.readLine().split(" ");
            for (int i = 0; i < n; i++)
                skill[i] = Integer.parseInt(str[i]);
            List<List<Integer>> usd = new ArrayList<>();
            for (int i = 0; i < n; i++)
                usd.add(new ArrayList<>());
            for (int i = 0; i < n; i++) {
                usd.get(u[i] - 1).add(skill[i]);
            }
            for (int i = 0; i < n; i++)
                Collections.sort(usd.get(i), Collections.reverseOrder());
            List<List<Long>> suffixSum = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                List<Long> suffixList = new ArrayList<>();
                suffixSum.add(suffixList);
                List<Integer> skills = usd.get(i);
                for (int j = skills.size() - 1; j >= 0; j--) {
                    if (suffixList.size() == 0)
                        suffixList.add((long)skills.get(j));
                    else
                        suffixList.add(skills.get(j) + suffixList.get(suffixList.size() - 1));
                }
            }
            long[] strength = new long[n + 1];
            for (int i = 0; i < n; i++) {
                List<Integer> skills = usd.get(i);
                List<Long> suffixList = suffixSum.get(i);
                for (int k = 1; k <= skills.size(); k++) {
                    int rem = skills.size() % k;
                    if (rem != 0) {
                        strength[k] += suffixList.get(skills.size() - 1) - suffixList.get(rem - 1);
                    } else
                        strength[k] += suffixList.get(skills.size() - 1);
                }
            }
            StringBuilder ans = new StringBuilder();
            for (int i = 1; i <= n; i++)
                ans.append(strength[i]).append(" ");
            System.out.println(ans);
            t--;
        }
    }
}
