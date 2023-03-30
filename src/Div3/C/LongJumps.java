package Div3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongJumps {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String []str=br.readLine().split(" ");
            int []a=new int[n];
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(str[i]);
            int []dp=new int[n];
            //initialization
            for(int i=0;i<n;i++)
                dp[i]=a[i];
            for(int i=n-1;i>=0;i--){
                if(i+a[i]<n){
                    dp[i]+=dp[i+a[i]];
                }
            }
            int max=0;
            for(int i=0;i<n;i++){
                if(max<dp[i])
                    max=dp[i];
            }
            System.out.println(max);
            t--;
        }
    }
}
