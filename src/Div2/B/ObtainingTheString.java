//package Div2.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ObtainingTheString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        StringBuilder sb = new StringBuilder(s);
        String t = br.readLine();
        List<Integer> res = new ArrayList<>();
        boolean flag = true;
        for (int i = n - 1; i >= 0; i--) {
            char c1 = sb.charAt(i);
            char c2 = t.charAt(i);
            if (c1 != c2) {
                //try to go backwards and search for c1
                int pos = -1;
                for (int j = i - 1; j >= 0; j--) {
                    if (sb.charAt(j) == c2) {
                        pos = j;
                        break;
                    }
                }
                if (pos == -1) {
                    flag = false;
                    break;
                }
                for (int j = pos; j < i; j++) {
                    swap(sb, j, j + 1);
                    res.add(j);
                }
            }
        }
        if (!flag)
            System.out.println(-1);
        else {
            System.out.println(res.size());
            for (int elem : res)
                System.out.print((elem+1) + " ");
            System.out.println();
        }
    }

    private static void swap(StringBuilder sb, int i, int j) {
        char temp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, temp);
    }
}
