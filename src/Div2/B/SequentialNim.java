//package Div2.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SequentialNim {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = Integer.parseInt(str[i]);
            int i = 0;
            while (i < n && a[i] == 1)
                i++;
            if (i < n) {
                System.out.println(i % 2 == 0 ? "First" : "Second");
            } else {
                System.out.println(i % 2 == 0 ? "Second" : "First");
            }
            t--;
        }
    }
}
