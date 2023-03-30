package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BooksExchange {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                if (res[i] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    int cnt = 1;
                    int j = i;
                    while (a[j] != i + 1) {
                        list.add(a[j] - 1);
                        j = a[j] - 1;
                        cnt++;
                    }
                    for (int val : list) {
                        res[val] = cnt;
                    }
                }
            }
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < n; i++) {
                ans.append(res[i]).append(" ");
            }
            System.out.println(ans);
            t--;
        }
    }
}
