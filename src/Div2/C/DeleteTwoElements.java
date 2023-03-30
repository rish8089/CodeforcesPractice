//package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeleteTwoElements {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            List<Integer> a = new ArrayList<>();
            for (int i = 0; i < n; i++)
                a.add(Integer.parseInt(str[i]));
            Collections.sort(a);
            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += a.get(i);
            }
            if (2 * sum % n != 0) {
                System.out.println(0);
            } else {
                long cnt=0;
                int twoTimesK = (int)(2*sum/n);
                for (int i = 0; i < n; i++) {
                    int lidx = lowerMostOccurrence(a, i + 1, twoTimesK - a.get(i));
                    int uidx = upperMostOccurrence(a, i + 1, twoTimesK - a.get(i));
                    if (lidx != -1 && uidx != -1)
                        cnt += uidx - lidx + 1;

                }
                System.out.println(cnt);
            }
            t--;
        }
    }

    private static int lowerMostOccurrence(List<Integer> list, int ss, int x) {
        int u = ss;
        int v = list.size() - 1;
        int idx = -1;
        while (u <= v) {
            int mid = (u + v) / 2;
            int val = list.get(mid);
            if (val >= x) {
                if (val == x)
                    idx = mid;
                v = mid - 1;
            } else
                u = mid + 1;
        }
        return idx;
    }

    private static int upperMostOccurrence(List<Integer> list, int ss, int x) {
        int u = ss;
        int v = list.size() - 1;
        int idx = -1;
        while (u <= v) {
            int mid = (u + v) / 2;
            int val = list.get(mid);
            if (val <= x) {
                if (val == x)
                    idx = mid;
                u = mid + 1;
            } else
                v = mid - 1;
        }
        return idx;
    }
}