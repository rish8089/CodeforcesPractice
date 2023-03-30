//package Div2.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LifeOfAFlower {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = Integer.parseInt(str[i]);
            int height = 1;
            for (int i = 0; i < n; i++) {
                if (a[i] == 1) {
                    if ((i - 1) >= 0 && a[i - 1] == 1)
                        height += 5;
                    else
                        height += 1;
                } else {
                    if ((i - 1) >= 0 && a[i - 1] == 0) {
                        height = -1;
                        break;
                    }
                }
            }
            System.out.println(height);
            t--;
        }
    }
}
