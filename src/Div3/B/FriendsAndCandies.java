package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FriendsAndCandies {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); //no of test cases
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += a[i];
            }
            if (sum % n != 0) {
                System.out.println(-1);
            } else {
                int equalDist = sum / n;
                int cnt = 0;
                for (int i = 0; i < n; i++) {
                    if (a[i] > equalDist) {
                        cnt += 1;
                    }
                }
                System.out.println(cnt);
            }
            t--;
        }
    }
}
