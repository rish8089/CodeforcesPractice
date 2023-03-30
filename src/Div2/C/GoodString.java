//package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoodString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String s = br.readLine();
            int n = s.length();
            int maxCnt = 0;
            for (int i = 0; i <= 9; i++) {
                for (int j = 0; j <= 9; j++) {
                    int cnt = 0;
                    for (int k = 0; k < s.length(); k++) {
                        int d = s.charAt(k) - '0';
                        if (cnt % 2 == 0) {
                            if (d == i)
                                cnt += 1;
                        } else {
                            if (d == j)
                                cnt += 1;
                        }
                    }
                    maxCnt = Integer.max(maxCnt, i == j ? cnt : cnt / 2 * 2);
                }
            }
            System.out.println(n - maxCnt);
            t--;
        }
    }
}
