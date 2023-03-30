//package Div3.D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DecreaseTheSumOfDigits {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String[] ns = br.readLine().split(" ");
            long n = Long.parseLong(ns[0]);
            int s = Integer.parseInt(ns[1]);
            int sumOfDigits = getSumOfDigits(n);
            long operations = 0;
            int zerosAhead = 0;
            while (sumOfDigits > s) {
                int x = (int) (n % 10);
                if (x != 0) {
                    operations += (10 - x) * mypow(10, zerosAhead);
                    n /= 10;
                    n += 1;
                    sumOfDigits = getSumOfDigits(n);
                } else
                    n /= 10;
                zerosAhead += 1;
            }
            System.out.println(operations);
            t--;
        }
    }

    private static int getSumOfDigits(long n) {
        int s = 0;
        while (n > 0) {
            int x = (int) (n % 10);
            n /= 10;
            s = s + x;
        }
        return s;
    }

    private static long mypow(int a, int b) {
        long base = a;
        long result = 1;
        while (b > 0) {
            if (b % 2 != 0) {
                result = result * base;
            }
            b = b >> 1;
            if (b > 0) {
                base = base * base;
            }
        }

        return result;
    }
}
