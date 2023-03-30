//package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AnuHasAFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(str[i]);
        int[] cnt = new int[32];
        for (int i = 0; i < n; i++) {
            int num = a[i];
            int j = 0;
            while (num > 0) {
                cnt[j] += (num % 2 == 0 ? 0 : 1);
                num /= 2;
                j++;
            }
        }
        int max = 0;
        int maxIdx = -1;
        for (int i = 0; i < n; i++) {
            int num = a[i];
            int j = 0;
            int res = 0;
            while (num > 0) {
                int rem = num % 2;
                if (rem == 1 && cnt[j] == 1) {
                    res += (1 << j);
                }
                num /= 2;
                j++;
            }
            if (max < res) {
                max = res;
                maxIdx = i;
            }
        }
        StringBuilder ans = new StringBuilder();
        if(maxIdx == -1){
            for(int i=0;i<n;i++)
                ans.append(a[i]).append(" ");
        }else{
            ans.append(a[maxIdx]).append(" ");
            for(int i=0;i<n;i++) {
                if(i != maxIdx){
                    ans.append(a[i]).append(" ");
                }
            }
        }
        System.out.println(ans);
    }
}
