package Div3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MAXMEXCut {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            char[][] mat = new char[2][n];
            for (int i = 0; i < 2; i++) {
                String s = br.readLine();
                for (int j = 0; j < n; j++)
                    mat[i][j] = s.charAt(j);
            }
            int preval = -1;
            int ans = 0;
            for (int i = 0; i < n; i++) {
                boolean containsOne = containsOne(mat, i);
                boolean containsZero = containsZero(mat, i);
                if (containsOne && containsZero) {
                    ans += 2;
                    if (preval == 0) {
                        ans += 1;
                    }
                    preval = -1;
                } else if (containsOne) {
                    if (preval == 0) {
                        ans += 2;
                        preval = -1;
                    } else
                        preval = 1;
                } else {
                    if (preval == -1)
                        preval = 0;
                    else if (preval == 0) {
                        ans += 1;
                    } else {
                        ans += 2;
                        preval = -1;
                    }
                }
            }
            if (preval == 0)
                ans += 1;
            System.out.println(ans);
            t--;
        }
    }

    private static boolean containsOne(char[][] mat, int col) {
        return mat[0][col] == '1' || mat[1][col] == '1';
    }

    private static boolean containsZero(char[][] mat, int col) {
        return mat[0][col] == '0' || mat[1][col] == '0';
    }
}
