package Div3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakeItGood {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String []str=br.readLine().split(" ");
            int []a=new int[n];
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(str[i]);
            int i=n-1;
            //path of increase
            while(i-1>=0 && a[i-1]>=a[i])
                i--;
            //path of decrease
            while(i-1>=0 && a[i-1]<=a[i])
                i--;
            System.out.println(i-1<0?0:i);
            t--;
        }
    }
}
