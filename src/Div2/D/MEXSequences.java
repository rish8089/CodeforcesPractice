//package Div2.D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MEXSequences {
    private static int MOD=998244353;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String []str=br.readLine().split(" ");
            int []a=new int[n];
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(str[i]);
            int []hash=new int[n+1];
            for(int i=0;i<n;i++)
                hash[a[i]]++;
            long total=0;
            //MEX subseqs with only 1 distinct
            for(int i=0;i<=n;i++){
                total=(total+(mypow(2,hash[i])-1+MOD)%MOD)%MOD;
            }
            //MEX subseqs with only 2 distincts
            for(int i=0;i<=n-2;i++){
                long val1=(mypow(2,hash[i])-1+MOD)%MOD;
                long val2=(mypow(2,hash[i+2])-1+MOD)%MOD;
                total=(total+(val1*val2)%MOD)%MOD;
            }
            System.out.println(total);
            t--;
        }
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
}
