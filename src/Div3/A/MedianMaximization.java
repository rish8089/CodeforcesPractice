package Div3.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MedianMaximization {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String[] ns = br.readLine().split(" ");
            int n = Integer.parseInt(ns[0]);
            int s = Integer.parseInt(ns[1]);
            int cnt = n - (n + 1) / 2 + 1;
            System.out.println(s / cnt);
            t--;
        }
    }
}
