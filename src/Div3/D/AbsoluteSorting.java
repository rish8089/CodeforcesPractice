//package Div3.D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AbsoluteSorting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String []str=br.readLine().split(" ");
            int []a=new int[n];
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(str[i]);
            int maxX=0;
            for(int i=0;i<n-1;i++){
                if(a[i]>a[i+1]){
                    maxX=max(maxX, (int)Math.ceil((a[i]+a[i+1])/2.0));
                }
            }
            for(int i=0;i<n;i++){
                a[i]=Math.abs(a[i]-maxX);
            }
            boolean flag=true;
            for(int i=0;i<n-1;i++){
                if(a[i]>a[i+1]){
                    flag=false;
                    break;
                }
            }
            System.out.println(flag?maxX:-1);
            t--;
        }
    }
    private static int max(int a, int b){
        return Math.max(a, b);
    }
}
