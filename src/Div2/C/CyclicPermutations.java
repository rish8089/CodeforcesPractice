//package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CyclicPermutations {
    private static int MOD=1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        long nonCyclic = mypow(2,n-1);
        long factres=fact(n);
        System.out.println((factres-nonCyclic+MOD)%MOD);
    }

    private static long mypow(int a, int b) {
        long base = a;
        long result = 1;
        while (b > 0) {
            if (b % 2 != 0) {
                result = (result * base) % MOD;
            }
            b = b >> 1;
            if (b > 0) {
                base = (base * base) % MOD;
            }
        }

        return result;
    }
    private static long fact(int n){
        long res=1;
        for(int i=1;i<=n;i++){
            res=(res*i)%MOD;
        }
        return res;
    }
}
