//package Div3.D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CorruptedArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            List<Integer> a = new ArrayList<>();
            for (int i = 0; i < n + 2; i++)
                a.add(Integer.parseInt(str[i]));
            Collections.sort(a);
            //let's assume that b(n+1) is now second last
            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += a.get(i);
            }
            if (sum == a.get(n)) {
                for (int i = 0; i < n; i++)
                    System.out.print(a.get(i) + " ");
                System.out.println();
            } else {
                //let's assume b(n+1) is last
                sum += a.get(n);
                int excludedPos = -1;
                for (int i = 0; i < n + 1; i++) {
                    if (sum - a.get(i) == a.get(n + 1)) {
                        excludedPos = i;
                        break;
                    }
                }
                if (excludedPos == -1)
                    System.out.println(-1);
                else {
                    for (int i = 0; i < n + 1; i++) {
                        if (excludedPos != i)
                            System.out.print(a.get(i) + " ");
                    }
                    System.out.println();
                }
            }
            t--;
        }
    }
}
