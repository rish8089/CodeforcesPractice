//package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TwoArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            List<Integer> a = new ArrayList<>();
            List<Integer> b = new ArrayList<>();
            String[] str = br.readLine().split(" ");
            for (int i = 0; i < n; i++)
                a.add(Integer.parseInt(str[i]));
            str = br.readLine().split(" ");
            for (int i = 0; i < n; i++)
                b.add(Integer.parseInt(str[i]));
            Collections.sort(a);
            Collections.sort(b);
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                int vala = a.get(i);
                int valb = b.get(i);
                if (vala < valb) {
                    if (valb - vala > 1) {
                        flag = false;
                        break;
                    }
                } else if (vala > valb) {
                    flag = false;
                    break;
                }
            }
            System.out.println(flag ? "YES" : "NO");
            t--;
        }
    }
}
