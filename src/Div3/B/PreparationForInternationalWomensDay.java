package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PreparationForInternationalWomensDay {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        String[] str = br.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(str[i]);
        }
        int[] hash = new int[k];
        for (int i = 0; i < n; i++)
            hash[a[i] % k]++;
        int cnt = 0;
        for (int i = 1; i <= k / 2; i++) {
            if (i % k != (k - i) % k) {
                cnt += Math.min(hash[i], hash[k - i]) * 2;
            } else {
                cnt += (hash[i] / 2) * 2;
            }
        }
        System.out.println(cnt + (hash[0]/2)*2);
    }
}
