//package Div4.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GrabTheCandies {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String []str=br.readLine().split(" ");
            int []a=new int[n];
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(str[i]);
            int even=0;
            int odd=0;
            for(int i=0;i<n;i++){
                if(a[i]%2==0){
                    even+=a[i];
                }else{
                    odd+=a[i];
                }
            }
            System.out.println(even>odd?"YES":"NO");
            t--;
        }
    }
}
