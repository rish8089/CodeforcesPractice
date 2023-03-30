package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EqualRectangles {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());
        while (q > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            int[] a = new int[4 * n];
            for (int i = 0; i < 4 * n; i++)
                a[i] = Integer.parseInt(str[i]);
            Arrays.sort(a);
            int equalArea = a[0] * a[4 * n - 1];
            boolean flag = true;
            for (int i = 0; i < 2 * n; i += 2) {
                if (equalArea != a[i] * a[4 * n - 1 - i] || a[i] != a[i + 1] || a[4 * n - 2 - i] != a[4 * n - 1 - i]) {
                    flag = false;
                    break;
                }
            }
            System.out.println(flag ? "YES" : "NO");
            q--;
        }

    }
}
