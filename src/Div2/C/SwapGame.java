//package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SwapGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n=Integer.parseInt(br.readLine());
            String []str=br.readLine().split(" ");
            int []a=new int[n];
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(str[i]);
            boolean flag=false;
            for(int i=1;i<n;i++){
                if(a[i]<a[0]){
                    flag=true;
                    break;
                }
            }
            System.out.println(flag?"Alice":"Bob");
            t--;
        }
    }
}
