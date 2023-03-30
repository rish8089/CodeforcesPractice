package Div3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommonDivisors {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String []str=br.readLine().split(" ");
        Long []a=new Long[n];
        for(int i=0;i<n;i++)
            a[i]=Long.parseLong(str[i]);
        long gcd=a[0];
        for(int i=1;i<n;i++){
            gcd=gcdf(gcd,a[i]);
        }
        int cnt=0;
        for(long i=1;i*i<=gcd;i++){
            if(gcd%i==0){
                if(i!=gcd/i)
                    cnt+=2;
                else
                    cnt+=1;
            }
        }
        System.out.println(cnt);
    }
    private static long gcdf(long a, long b){
        if(b==0)
            return a;
        else {
            return gcdf(b, a % b);
        }
    }
}
