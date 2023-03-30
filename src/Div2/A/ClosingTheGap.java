//package Div2.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClosingTheGap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String []str=br.readLine().split(" ");
            int []a=new int[n];
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(str[i]);
            int sum=0;
            for(int i=0;i<n;i++)
                sum+=a[i];
            System.out.println(sum%n==0?0:1);
            t--;
        }
    }
}
