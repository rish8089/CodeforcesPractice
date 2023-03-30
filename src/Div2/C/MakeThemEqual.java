//package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MakeThemEqual {
    private static int LIM = 300000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> primes = calculatePrimesUptoN(LIM);
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String[] str = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            char c = str[1].charAt(0);
            String s = br.readLine();

            List<Integer> positions = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) != c)
                    positions.add(i + 1);
            }
            if (positions.size() == 0) {
                System.out.println(0);
            } else {
                Set<Integer> divisors = new HashSet<>();
                for (int pos : positions) {
                    for (int i = 1; i * i <= pos; i++) {
                        if (pos % i == 0) {
                            divisors.add(i);
                            divisors.add(pos / i);
                        }
                    }
                }
                if (divisors.size() < n) {
                    int x = -1;
                    for (int i = 1; i <= n; i++) {
                        if (!divisors.contains(i)) {
                            x = i;
                            break;
                        }
                    }
                    System.out.println(1);
                    System.out.println(x);
                } else {
                    int x = -1;
                    for (int i = 2; i <= n - 1; i++) {
                        if (n % i != 0) {
                            x = i;
                            break;
                        }
                    }
                    System.out.println(2);
                    System.out.println(x + " " + n);
                }
            }
            t--;
        }
    }

    private static List<Integer> calculatePrimesUptoN(int n) {
        List<Integer> primes = new ArrayList<>();
        boolean[] sieve = new boolean[n + 1];
        for (int i = 2; i * i <= n; i++) {
            if (!sieve[i]) {
                for (int j = i * i; j <= n; j += i)
                    sieve[j] = true;
            }
        }
        for (int i = 2; i <= n; i++) {
            if (!sieve[i])
                primes.add(i);
        }
        return primes;
    }
}
