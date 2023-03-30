//package Div2.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FindArray {
    private static int LIM=10000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> primes=calculatePrimesUptoN(LIM);
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            StringBuilder ans=new StringBuilder();
            for(int i=0;i<n;i++){
                ans.append(primes.get(i)).append(" ");
            }
            System.out.println(ans);
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
