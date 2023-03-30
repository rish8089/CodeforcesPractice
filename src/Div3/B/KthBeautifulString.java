package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KthBeautifulString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); //no of test cases
        while (t > 0) {
            String[] nk = br.readLine().split(" ");
            int n = Integer.parseInt(nk[0]);
            long k = Long.parseLong(nk[1]);
            int cnta;
            cnta = 0;
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < n; i++) {
                //calculate combinations starting with 'a'
                long c = ncr(n - i - 1, n - 2 - cnta - 1);
                if (k <= c) {
                    res.append('a');
                    cnta += 1;
                } else {
                    res.append('b');
                    k = k - c;
                }
            }
            System.out.println(res);
            t--;
        }

    }

    private static long ncr(long n, long r) {
        if (n < r || r < 0) {
            return 0;
        }
        int diff = (int) (n - r);
        switch (diff) {
            case 0:
                return 1;
            case 1:
                return n;
            default:
                return n * (n - 1) / 2;
        }
    }
}
