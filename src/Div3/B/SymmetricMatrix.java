package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SymmetricMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String[] nm = br.readLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);
            int[][][] tile = new int[n][2][2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2; j++) {
                    String[] str = br.readLine().split(" ");
                    int a = Integer.parseInt(str[0]);
                    int b = Integer.parseInt(str[1]);
                    tile[i][j][0] = a;
                    tile[i][j][1] = b;
                }
            }
            int st = 0;//symmetric tiles
            for (int i = 0; i < n; i++)
                st += tile[i][0][1] == tile[i][1][0] ? 1 : 0;
            System.out.println(m % 2 != 0 || st == 0 ? "NO" : "YES");
            t--;
        }
    }
}
