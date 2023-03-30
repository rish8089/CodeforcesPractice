//package Div2.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BANBAN {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(n / 2 + n % 2);
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < n / 2; i++) {
                ans.append(3 * i + 2).append(" ").append((n - 1 - i) * 3 + 3).append("\n");
            }
            if (n % 2 == 1) {
                ans.append(3 * (n / 2) + 2).append(" ").append(3 * (n / 2) + 3);
                ans.append("\n");
            }
            System.out.print(ans);
            t--;
        }
    }
}
