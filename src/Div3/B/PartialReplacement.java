package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PartialReplacement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String[] nk = br.readLine().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);
            int minReplacements = 0;
            String str = br.readLine();
            StringBuilder s = new StringBuilder(str);
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == 'x') break;
                if (c == '*') {
                    s.setCharAt(i, 'x');
                    minReplacements += 1;
                    break;
                }
            }

            for (int i = str.length() - 1; i >= 0; i--) {
                char c = s.charAt(i);
                if (c == 'x') break;
                if (c == '*') {
                    s.setCharAt(i, 'x');
                    minReplacements += 1;
                    break;
                }
            }
            int[] asterikJustBefore = new int[n];
            int asterikIdx = -1;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '*')
                    asterikIdx = i;
                asterikJustBefore[i] = asterikIdx;
            }
            int prevXIdx = -1;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == 'x') {
                    if (prevXIdx != -1) {
                        int xidx = prevXIdx;
                        while (xidx + k < i) {
                            xidx = asterikJustBefore[xidx + k];
                            minReplacements += 1;
                        }
                    }
                    prevXIdx = i;
                }
            }
            System.out.println(minReplacements);
            t--;
        }
    }
}
