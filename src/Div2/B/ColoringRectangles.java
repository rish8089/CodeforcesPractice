//package Div2.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ColoringRectangles {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String[] nm = br.readLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);
            if (n > 1 && m > 1) {
                int ans = n / 3 * m;
                int remn = n % 3;
                if (remn == 1)
                    ans += m / 3 + ((m % 3) > 0 ? 1 : 0);
                else if (remn == 2) {
                    ans += (m / 3) * 2;
                    int remm = m % 3;
                    if (remm == 1)
                        ans += 1;
                    else if (remm == 2)
                        ans += 2;
                }
                System.out.println(ans);
            } else if (n > 1)
                System.out.println(n / 3 + ((n % 3) > 0 ? 1 : 0));
            else
                System.out.println(m / 3 + ((m % 3) > 0 ? 1 : 0));
            t--;
        }
    }

}
