package Div3.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WaterBuying {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String[] nab = br.readLine().split(" ");
            long n = Long.parseLong(nab[0]);
            long a = Long.parseLong(nab[1]);
            long b = Long.parseLong(nab[2]);
            if (a * 2 <= b) {
                System.out.println(n * a);
            } else {
                System.out.println((n / 2) * b + (n % 2 == 0 ? 0 : a));
            }
            t--;
        }

    }
}
