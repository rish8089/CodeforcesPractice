package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FairDivision {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); //no of test cases
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            String[] str = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            int cnt1 = 0;
            int cnt2 = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] == 1) cnt1++;
                else cnt2++;
            }
            int sum = 2 * cnt2 + cnt1;
            if (sum % 2 != 0) {
                System.out.println("NO");
            } else {
                int equalSum = sum / 2;
                if (equalSum % 2 == 0) {
                    System.out.println("YES");
                } else {
                    if (cnt1 >= 2) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                }
            }
            t--;
        }
    }
}
