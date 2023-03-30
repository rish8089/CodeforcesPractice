//package Div2.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AbsentRemainder {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            List<Integer> a = new ArrayList<>();
            for (int i = 0; i < n; i++)
                a.add(Integer.parseInt(str[i]));
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++)
                min = Integer.min(min, a.get(i));
            int cnt = n / 2;
            for (int i = 0; i < n && cnt > 0; i++) {
                if (min != a.get(i)) {
                    System.out.format("%d %d\n", a.get(i), min);
                    cnt--;
                }
            }
            t--;
        }
    }
}
