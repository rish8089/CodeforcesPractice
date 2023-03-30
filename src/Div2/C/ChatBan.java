//package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChatBan {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String[] kx = br.readLine().split(" ");
            long k = Long.parseLong(kx[0]);
            long x = Long.parseLong(kx[1]);
            if (k * k <= x)
                System.out.println(2 * k - 1);
            else {
                if (x > k * (k + 1) / 2) {
                    x = x - k * (k + 1) / 2;
                    System.out.println(k + searchForFalling(x, k - 1, 1));
                } else {
                    System.out.println(searchForIncreasing(x, 1, k));
                }
            }
            t--;
        }

    }

    private static long searchForIncreasing(long x, long u, long v) {
        long idx = -1;
        while (u <= v) {
            long mid = u + (v - u) / 2;
            if (mid * (mid + 1) / 2 >= x) {
                idx = mid;
                v = mid - 1;
            } else
                u = mid + 1;
        }
        return idx;
    }

    private static long searchForFalling(long x, long u, long v) {
        long idx = -1;
        long tempu = u;
        while (u >= v) {
            long mid = v + (u - v) / 2;
            long num = tempu - mid + 1;
            long val = num * (2 * tempu - num + 1) / 2;
            if (val >= x) {
                idx = num;
                v = mid + 1;
            } else
                u = mid - 1;
        }
        return idx;
    }
}
