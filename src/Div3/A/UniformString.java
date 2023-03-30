package Div3.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UniformString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String[] nk = br.readLine().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < n; i++) {
                ans.append((char)('a'+i % k));
            }
            System.out.println(ans);
            t--;
        }
    }
}
