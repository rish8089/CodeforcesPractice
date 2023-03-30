package Div3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class YetAnotherArrayRestoration {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String[] nxy = br.readLine().split(" ");
            int n = Integer.parseInt(nxy[0]);
            int x = Integer.parseInt(nxy[1]);
            int y = Integer.parseInt(nxy[2]);
            if (n - 2 > 0) {
                int i = 1;
                while (i <= y - x) {
                    if ((y - x) % i == 0) {
                        int div = (y - x) / i;
                        if ((div-1) <= n - 2)
                            break;
                    }
                    i++;
                }
                for (int j = x; j <= y; j += i, n -= 1) {
                    System.out.print(j + " ");
                }
                for (int j = x - i; j > 0 && n > 0; j -= i, n -= 1) {
                    System.out.print(j + " ");
                }
                for (int j = y + i; n > 0; j += i, n -= 1) {
                    System.out.print(j + " ");
                }
                System.out.println();
            } else {
                System.out.format("%d %d\n", x, y);
            }
            t--;
        }
    }
}
