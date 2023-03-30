//package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Division {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0) {
            String[] pq = br.readLine().split(" ");
            long p=Long.parseLong(pq[0]);
            int q=Integer.parseInt(pq[1]);
            if(p%q!=0)
                System.out.println(p);
            else{
                Map<Long,Integer> qpf = primeFactorization(q);
                long minDividedFactor = -1;
                for(Long k:qpf.keySet()){
                    int ppc = getPowerCnt(p, k);
                    int qpc = qpf.get(k);
                    long dividedFactor = mypow(k, ppc - qpc + 1);
                    if(minDividedFactor == -1 || minDividedFactor > dividedFactor)
                        minDividedFactor = dividedFactor;
                }
                System.out.println(p/minDividedFactor);
            }
            t--;
        }
    }

    private static Map<Long,Integer> primeFactorization(long p){
        Map<Long,Integer> ppf = new HashMap<>();
        for(int i=2;i*i<=p;i++){
            int cnt=0;
            while(p%i==0){
                p/=i;
                cnt++;
            }
            if(cnt>0)
                ppf.put((long)i, cnt);
        }
        if(p>1)
            ppf.put(p,1);
        return ppf;
    }
    private static long mypow(long a, int b) {
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
    private static int getPowerCnt(long a, long p){
        int cnt=0;
        while(a%p==0) {
            cnt++;
            a=a/p;
        }
        return cnt;
    }
}
