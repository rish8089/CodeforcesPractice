package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OddGrasshopper {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String[] str = br.readLine().split(" ");
            long x = Long.parseLong(str[0]);
            long n = Long.parseLong(str[1]);
            if(n==0){
                System.out.println(x);
                t--; continue;
            }
            long div = n / 4;
            long fp;
            long j = 0;
            if (div >= 1) {
                j = div * (-4);
            }
            if (div > 0) {
                if (4 * div + 1 > n)
                    j += 4 * div + 1;
            }

            for (long i = 4 * div + 2; i <= n; i++) {
                j += i;
            }

            if (abs(x) % 2 == 0) {
                fp = x - 1;
                fp += j;


            } else {
                fp = x + 1;
                fp -= j;
            }
            System.out.println(fp);
            t--;
        }
    }

    private static long abs(long x) {
        return x > 0 ? x : -x;
    }
}
