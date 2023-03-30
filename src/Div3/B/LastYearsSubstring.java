package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LastYearsSubstring {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); //no of test cases
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            if (s.startsWith("2020") || s.endsWith("2020")) {
                System.out.println("YES");
            } else {
                if (substringsExistsInBeginningAndLast(s, "2", "020") || substringsExistsInBeginningAndLast(s, "202", "0") || substringsExistsInBeginningAndLast(s, "20", "20")) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
            t--;
        }
    }

    private static boolean substringsExistsInBeginningAndLast(String s, String str1, String str2) {
        int idx1 = s.indexOf(str1);
        int idx2 = s.lastIndexOf(str2);
        return idx1 == 0 && idx2 == s.length() - str2.length() && idx1 + str1.length() < idx2;
    }
}
