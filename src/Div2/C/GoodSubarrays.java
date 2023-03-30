package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class GoodSubarrays {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = str.charAt(i) - '0';
            Map<Integer, Integer> mp = new HashMap<>();
            //prefix sum
            int sum = 0;
            long ans = 0;
            for (int i = 0; i < n; i++) {
                sum += a[i];
                if (!mp.containsKey(sum - i - 1))
                    mp.put(sum - i - 1, 1);
                else
                    mp.put(sum - i - 1, mp.get(sum - i - 1) + 1);
                if (sum - i - 1 == 0)
                    ans += 1;
            }
            sum = 0;
            for (int i = 1; i < n; i++) {
                //remove the prefix sum from 1 to i-1
                sum += a[i - 1];
                mp.put(sum - i, mp.get(sum - i) - 1);
                if (mp.get(sum - i) == 0)
                    mp.remove(sum - i);
                else {
                    ans += mp.get(sum - i);
                }
            }
            System.out.println(ans);
            t--;
        }
    }
}
