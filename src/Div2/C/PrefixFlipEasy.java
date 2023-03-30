//package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PrefixFlipEasy {
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
                        }
                        prefixes.add(i + 1);
                        invert(src, 0);
                        invert(src, i);
                        swap(src, 0, i);
                        if (i > 2) {
                            invert(src, 1);
                            invert(src, i - 1);
                            swap(src, 1, i - 1);
                        } else if (i > 1) {
                            invert(src, 1);
                        }
                    } else {
                        prefixes.add(1);
                        invert(src, 0);
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

    private static void invert(StringBuilder sb, int pos) {
        if (sb.charAt(pos) == '1')
            sb.setCharAt(pos, '0');
        else
            sb.setCharAt(pos, '1');
    }

    private static void swap(StringBuilder sb, int pos1, int pos2) {
        char temp = sb.charAt(pos1);
        sb.setCharAt(pos1, sb.charAt(pos2));
        sb.setCharAt(pos2, temp);
    }
}
