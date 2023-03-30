//package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GuessingTheGreatest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int u = 0;
        int v = n - 1;
        int res = -1;
        while (u < v) {
            if (res == -1) {
                System.out.format("? %d %d\n", u + 1, v + 1);
                res = Integer.parseInt(br.readLine());
                res--;
            }
            if (v - u == 1) {
                if (res == u)
                    u++;
                else
                    v--;
            } else {
                int mid = (u + v) / 2;
                if (res <= mid) {
                    System.out.format("? %d %d\n", u + 1, mid + 1);
                    int res1 = Integer.parseInt(br.readLine());
                    res1--;
                    if (res == res1) {
                        v = mid;
                        res = res1;
                    } else {
                        u = mid + 1;
                        res = -1;
                    }
                } else {
                    System.out.format("? %d %d\n", mid + 1, v + 1);
                    int res1 = Integer.parseInt(br.readLine());
                    res1--;
                    if (res == res1) {
                        u = mid;
                        res = res1;
                    } else {
                        v = mid - 1;
                        res = -1;
                    }
                }
            }
        }
        System.out.format("! %d\n", u + 1);
    }
}
