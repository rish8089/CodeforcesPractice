package Div3.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DoNotBeDistracted {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            boolean[] hash = new boolean[26];
            boolean suspicious = false;
            for (int i = 0; i < n; i++) {
                char c = str.charAt(i);
                if (hash[c - 'A']) {
                    suspicious = true;
                    break;
                }
                hash[c - 'A'] = true;
                while (i + 1 < n && str.charAt(i + 1) == c) {
                    i++;
                }
            }
            System.out.println(suspicious ? "NO" : "YES");

            t--;
        }
    }
}
