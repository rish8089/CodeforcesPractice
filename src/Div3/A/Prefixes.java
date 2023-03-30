package Div3.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prefixes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String s = br.readLine();
        int a = 0;
        int cnt = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a')
                a = a + 1;
            if (i % 2 != 0) {
                if (a != i + 1 - a) {
                    cnt++;
                    if (a > i + 1 - a) ans.append('b');
                    else ans.append('a');
                } else ans.append(c);
                a = (i + 1) / 2;
            } else ans.append(c);
        }
        System.out.println(cnt);
        System.out.println(ans);
    }
}
