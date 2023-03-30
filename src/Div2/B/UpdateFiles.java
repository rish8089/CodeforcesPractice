package Div2.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UpdateFiles {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String[] nk = br.readLine().split(" ");
            long n = Long.parseLong(nk[0]);
            long k = Long.parseLong(nk[1]);
            long rem = n - 1;//remaining computers
            long cables = 1; //no of cables which can be used right now
            long h = 0;
            while (rem > 0 && cables <= k) {
                rem = Math.max(0, rem - cables);
                h += 1;
                cables *= 2;
            }
            System.out.println(h + (rem / k + (rem % k == 0 ? 0 : 1)));
            t--;
        }

    }
}
