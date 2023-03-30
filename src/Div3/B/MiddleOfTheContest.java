package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MiddleOfTheContest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] h1m1 = br.readLine().split(":");
        String[] h2m2 = br.readLine().split(":");
        int h1 = Integer.parseInt(h1m1[0]);
        int m1 = Integer.parseInt(h1m1[1]);
        int h2 = Integer.parseInt(h2m2[0]);
        int m2 = Integer.parseInt(h2m2[1]);
        int tm1 = h1 * 60 + m1;
        int tm2 = h2 * 60 + m2;
        int diff = tm2 - tm1;
        int dest = tm1 + diff / 2;
        System.out.format("%02d:%02d", dest / 60, dest % 60);
    }
}
