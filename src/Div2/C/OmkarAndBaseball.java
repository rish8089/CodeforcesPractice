//package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OmkarAndBaseball {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = Integer.parseInt(str[i]);
            int i = 0;
            while (i < n && a[i] == i + 1)
                i++;
            int j = n - 1;
            while (j >= 0 && a[j] == j + 1)
                j--;
            if (i >= j)
                System.out.println(0);
            else {
                int cnt = 0;
                for (int k = i; k <= j; k++) {
                    if (a[k] == k + 1) {
                        cnt += 1;
                        while (k + 1 <= j && a[k + 1] == k + 2)
                            k++;
                    }
                }
                System.out.println(cnt + 1);
            }
            t--;
        }
    }
}
