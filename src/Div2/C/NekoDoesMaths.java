package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NekoDoesMaths {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String []ab=br.readLine().split(" ");
        int a=Integer.parseInt(ab[0]);
        int b=Integer.parseInt(ab[1]);
        int min=Integer.min(a,b);
        int max=Integer.max(a,b);
        int x = max/min;
        int rem = max%min;
        if(rem==0 || x==1){
            System.out.println(0);
        }else{
            int i=2;
            int sum = i+1;
            int ans=0;
            long lcm = (long)a*b/gcd(a,b);
            while(i<=x && (sum-1)<=rem){
                if(rem%(sum-1)==0){
                    int k=rem/(sum-1);
                    if(lcm>max+k){
                        lcm=max+k;
                        ans=k;
                        break;
                    }
                }
                i++;
                sum+=i;
            }
            System.out.println(ans);
        }
    }
    private static int gcd(int a,int b){
        if(b==0)
            return a;
        else
            return gcd(b,a%b);
    }
}
