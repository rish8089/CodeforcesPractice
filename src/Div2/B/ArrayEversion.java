//package Div2.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayEversion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String []str=br.readLine().split(" ");
            int []a=new int[n];
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(str[i]);
            int x = a[n-1];
            int i = n-2;
            int k=0;
            while(i>=0){
                if(a[i]>x){
                    k+=1;
                    x=a[i];
                }
                i--;
            }
            System.out.println(k);
            t--;
        }
    }
}
