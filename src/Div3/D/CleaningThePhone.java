package Div3.D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CleaningThePhone {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String[] nm = br.readLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            long m = Long.parseLong(nm[1]);
            String[] str = br.readLine().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = Integer.parseInt(str[i]);
            str = br.readLine().split(" ");
            int[] b = new int[n];
            for (int i = 0; i < n; i++)
                b[i] = Integer.parseInt(str[i]);
            List<Long> normalApps = new ArrayList<>();
            List<Long> importantApps = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (b[i] == 1)
                    normalApps.add((long) a[i]);
                else
                    importantApps.add((long) a[i]);
            }
            Collections.sort(normalApps);
            Collections.sort(importantApps);
            int i = normalApps.size() - 1;
            int j = importantApps.size() - 1;
            int ans = 0;
            while (i >= 0 && j >= 0 && m > 0) {
                if (normalApps.get(i) >= m) {
                    m = 0;
                    ans += 1;
                    break;
                } else {
                    if (i - 1 >= 0) {
                        if (normalApps.get(i) + normalApps.get(i - 1) >= importantApps.get(j)) {
                            if (normalApps.get(i) + normalApps.get(i - 1) >= m) {
                                m = 0;
                                ans += 2;
                                break;
                            } else if (normalApps.get(i) + importantApps.get(j) >= m) {
                                m = 0;
                                ans += 3;
                                break;
                            } else {
                                m = m - (normalApps.get(i) + normalApps.get(i - 1));
                                ans += 2;
                                i -= 2;
                            }
                        } else {
                            if (importantApps.get(j) >= m) {
                                m = 0;
                                ans += 2;
                                break;
                            } else if (i - 2 >= 0 && normalApps.get(i) + normalApps.get(i - 1) + normalApps.get(i - 2) >= m) {
                                m = 0;
                                ans += 3;
                                break;
                            } else {
                                m -= importantApps.get(j);
                                ans += 2;
                                j -= 1;
                            }
                        }
                    } else {
                        m -= importantApps.get(j);
                        ans += 2;
                        j--;
                    }
                }
            }
            while (i >= 0 && m > 0) {
                m -= normalApps.get(i);
                ans += 1;
                i--;
            }
            while (j >= 0 && m > 0) {
                m -= importantApps.get(j);
                ans += 2;
                j--;
            }
            System.out.println(m > 0 ? -1 : ans);
            t--;
        }
    }
}
