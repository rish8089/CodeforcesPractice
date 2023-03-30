//package Div2.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Era {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String []str=br.readLine().split(" ");
            int []a=new int[n];
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(str[i]);
            long mv=0;//no of elements added
            for(int i=0;i<n;i++){
                if(a[i]>(i+1+mv)){
                    mv+=a[i]-(i+1+mv);
                }
            }
            System.out.println(mv);
            t--;
        }
    }
}
