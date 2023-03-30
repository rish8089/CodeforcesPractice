//package Div3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumExtraction {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++)
                list.add(Integer.parseInt(str[i]));
            Collections.sort(list);
            int max = list.get(0);
            for (int i = 1; i < n; i++) {
                if (max < list.get(i) - list.get(i - 1))
                    max = list.get(i) - list.get(i - 1);
            }
            System.out.println(max);
            t--;
        }
    }
}
