//package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ComplexMarketAnalysis {
    private static int LIM = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> primes = getPrimes();
        Set<Integer> primesSet = new HashSet<>(primes);
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String[] ne = br.readLine().split(" ");
            int n = Integer.parseInt(ne[0]);
            int e = Integer.parseInt(ne[1]);
            String[] str = br.readLine().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = Integer.parseInt(str[i]);
            long ans = 0;
            for (int i = 0; i <= e - 1; i++) {
                int j = i;
                boolean primeEncountered = false;
                int onesBeforePrime = 0;
                int onesAfterPrime = 0;
                while (j < n) {
                    if(a[j]>1){
                        if(!primesSet.contains(a[j])){
                            if (primeEncountered && onesAfterPrime + onesBeforePrime > 0) {
                                ans += (long)(onesBeforePrime + 1) * (onesAfterPrime + 1) - 1;
                            }
                            onesBeforePrime = 0;
                            onesAfterPrime = 0;
                            primeEncountered = false;
                        }else{
                            if(!primeEncountered){
                                primeEncountered = true;
                            }else{
                                if(onesAfterPrime + onesBeforePrime > 0) {
                                    ans += (long)(onesBeforePrime + 1) * (onesAfterPrime + 1) - 1;
                                    onesBeforePrime = onesAfterPrime;
                                    onesAfterPrime = 0;
                                }
                            }
                        }
                    }else{
                        if(primeEncountered){
                            onesAfterPrime+=1;
                        }else
                            onesBeforePrime+=1;
                    }
                    j=j+e;
                }
                if(primeEncountered && onesAfterPrime + onesBeforePrime > 0) {
                    ans += (long)(onesBeforePrime + 1) * (onesAfterPrime + 1) - 1;
                }
            }
            System.out.println(ans);
            t--;
        }
    }

    private static List<Integer> getPrimes() {
        List<Integer> primes = new ArrayList<>();
        boolean[] sieve = new boolean[LIM + 1];
        for (int i = 2; i * i <= LIM; i++) {
            if (!sieve[i]) {
                for (long j = i * i; j <= LIM; j += i) {
                    sieve[(int) j] = true;
                }
            }
        }
        for (int i = 2; i <= LIM; i++) {
            if (!sieve[i])
                primes.add(i);
        }
        return primes;
    }
}
