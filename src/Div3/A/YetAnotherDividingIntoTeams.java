package Div3.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class YetAnotherDividingIntoTeams {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); //no of test cases
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = Integer.parseInt(str[i]);
            Arrays.sort(a);
            boolean oneTeam = true;
            for (int i = 0; i < n - 1; i++) {
                if (a[i + 1] - a[i] == 1) {
                    oneTeam = false;
                    break;
                }
            }
            System.out.println(oneTeam ? 1 : 2);
            t--;
        }
    }
}
