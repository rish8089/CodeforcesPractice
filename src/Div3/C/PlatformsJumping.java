package Div3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlatformsJumping {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nmd = br.readLine().split(" ");
        int n = Integer.parseInt(nmd[0]);
        int m = Integer.parseInt(nmd[1]);
        int d = Integer.parseInt(nmd[2]);
        String[] str = br.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < m; i++)
            a[i] = Integer.parseInt(str[i]);
        //placing all wooden platforms at the end
        int[] b = new int[n];
        int currPos = n - 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < a[i]; j++) {
                b[currPos] = i + 1;
                currPos -= 1;
            }
        }
        //traversing across the river
        boolean flag = false;
        currPos = -1;
        while (true) {
            currPos = Integer.min(currPos + d, n);
            if (currPos == n) {
                flag = true;
                break;
            }
            //check if wooden platform is not present
            if (b[currPos] == 0) {
                //try to find some wooden platform
                boolean found = false;
                int foundPos = -1;
                for (int j = currPos + 1; j < n; j++) {
                    if (b[j] != 0) {
                        found = true;
                        foundPos = j;
                        break;
                    }
                }
                if (found) {
                    //drag this wooden platform behind
                    int wpi = b[foundPos];//indexed from 1
                    for (int j = foundPos; j < foundPos + a[wpi - 1]; j++)
                        b[j] = 0;
                    for (int j = currPos; j < currPos + a[wpi - 1]; j++)
                        b[j] = wpi;
                    currPos = currPos + a[wpi - 1] - 1;
                } else {
                    break;
                }
            }
        }
        if (flag) {
            System.out.println("YES");
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < n; i++)
                ans.append(b[i]).append(" ");
            System.out.println(ans);
        } else {
            System.out.println("NO");
        }

    }
}
