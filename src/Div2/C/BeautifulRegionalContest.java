package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeautifulRegionalContest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = Integer.parseInt(str[i]);
            int half = n / 2;
            //awarding gold medals
            int g = 0;
            int i = 0;
            while (i < n && a[i] == a[0]) {
                g = g + 1;
                i++;
            }
            if (3 * g + 2 > half) {
                System.out.println("0 0 0");
            } else {
                //awarding silver medals
                int s = 0;
                while (s <= g && i < n) {
                    int j = i;
                    while (i + 1 < n && a[i + 1] == a[j]) {
                        i++;
                    }
                    s += i - j + 1;
                    i++;
                }
                if (2 * g + s + 1 > half)
                    System.out.println("0 0 0");
                else {
                    int b = 0;
                    while (b <= g && i < n) {
                        int j = i;
                        while (i + 1 < n && a[i + 1] == a[j]) {
                            i++;
                        }
                        b += i - j + 1;
                        i++;
                    }
                    if (g + s + b > half)
                        System.out.println("0 0 0");
                    else {
                        //trying to increase bronze medals
                        while (i < half) {
                            int j = i;
                            while (i + 1 < n && a[i + 1] == a[j]) {
                                i++;
                            }
                            if (i < half)
                                b += i - j + 1;
                            i++;
                        }
                        System.out.println(g + " " + s + " " + b);
                    }
                }
            }
            t--;
        }
    }
}
