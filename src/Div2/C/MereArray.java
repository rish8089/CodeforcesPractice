package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MereArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            List<Integer> a = new ArrayList<>();
            for (int i = 0; i < n; i++)
                a.add(Integer.parseInt(str[i]));
            List<Integer> b = new ArrayList<>();
            for (int i = 0; i < n; i++)
                b.add(a.get(i));
            Collections.sort(b);
            t--;
        }
    }
}
