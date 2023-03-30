//package Div3.D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BlueRedPermutation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = Integer.parseInt(str[i]);
            String s = br.readLine();
            List<Integer> red = new ArrayList<>();
            List<Integer> blue = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (a[i] >= 1 && a[i] <= n) {
                    if (s.charAt(i) == 'B')
                        blue.add(a[i]);
                    else
                        red.add(a[i]);
                }
            }
            //let's start with red, trying to shift all to right
            Collections.sort(red);
            boolean flag = true;
            int idx = n - 1;
            for (int i = red.size() - 1; i >= 0; i--, idx--) {
                int num = red.get(i);
                if (num > idx + 1) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                System.out.println("NO");
                t--;
                continue;
            }

            Collections.sort(blue);
            idx = 0;
            for (int i = 0; i < blue.size(); i++, idx++) {
                int num = blue.get(i);
                if (num < idx + 1) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                System.out.println("NO");
                t--;
                continue;
            }

            for (int i = 0; i < n; i++) {
                if ((a[i] <= 0 && s.charAt(i) == 'B') || (a[i] > n && s.charAt(i) == 'R')) {
                    flag = false;
                    break;
                }
            }
            System.out.println(flag ? "YES" : "NO");
            t--;
        }
    }
}
