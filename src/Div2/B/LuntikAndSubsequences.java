package Div2.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LuntikAndSubsequences {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String []str=br.readLine().split(" ");
            int []a=new int[n];
            for(int i=0;i<n;i++){
                a[i]=Integer.parseInt(str[i]);
            }
            int zeros=0;
            int ones=0;
            for(int i=0;i<n;i++){
                if(a[i]==0)
                    zeros+=1;
                if(a[i]==1)
                    ones+=1;
            }
            long combs=(long)Math.pow(2,zeros);
            System.out.println(ones*combs);
            t--;
        }

    }
}
