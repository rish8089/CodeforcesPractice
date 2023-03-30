package Div2.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DIYWoodenLadder {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            List<Integer> list=new ArrayList<>();
            for (int i = 0; i < n; i++)
                list.add(Integer.parseInt(str[i]));
            Collections.sort(list);
            System.out.println(Integer.min(list.get(n-2) - 1, n - 2));
            t--;
        }
    }
}
