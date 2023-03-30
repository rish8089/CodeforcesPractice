package Div3.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CardsForFriends {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String[] whn = br.readLine().split(" ");
            int w = Integer.parseInt(whn[0]);
            int h = Integer.parseInt(whn[1]);
            int n = Integer.parseInt(whn[2]);
            int wcnt = 0;
            while (w % 2 == 0) {
                wcnt++;
                w /= 2;
            }
            int hcnt = 0;
            while (h % 2 == 0) {
                hcnt++;
                h /= 2;
            }
            System.out.println((int) Math.pow(2, wcnt) * Math.pow(2, hcnt) >= n ? "YES" : "NO");
            t--;
        }
    }
}

