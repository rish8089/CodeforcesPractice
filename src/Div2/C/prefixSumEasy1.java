//package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class prefixSumEasy1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            StringBuilder src = new StringBuilder(br.readLine());
            StringBuilder dest = new StringBuilder(br.readLine());
            List<Integer> prefixes = new ArrayList<>();
            for (int i = n - 1; i >= 0; i--) {
                char c1 = src.charAt(i);
                char c2 = dest.charAt(i);
                if (c1 != c2) {
                    if (i > 0) {
                        if (src.charAt(0) != c1) {
                            prefixes.add(1);
                            invertAndReverse(src, 0 ,0);
                        }
                        prefixes.add(i + 1);
                        invertAndReverse(src, 0, i);
                    } else {
                        prefixes.add(1);
                        invertAndReverse(src, 0 ,0);
                    }
                }

            }
            StringBuilder ans = new StringBuilder();
            ans.append(prefixes.size()).append(" ");
            for (int i = 0; i < prefixes.size(); i++)
                ans.append(prefixes.get(i)).append(" ");
            System.out.println(ans);
            t--;
        }
    }

    private static void invertAndReverse(StringBuilder sb, int i, int j) {
        while (i <= j) {
            char c1 = sb.charAt(i);
            char c2 = sb.charAt(j);
            sb.setCharAt(i, c2 == '0' ? '1' : '0');
            sb.setCharAt(j, c1 == '0' ? '1' : '0');
            i++;
            j--;
        }
    }
}
