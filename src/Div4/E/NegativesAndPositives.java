//package Div4.E;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NegativesAndPositives {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String []str=br.readLine().split(" ");
            int []a=new int[n];
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(str[i]);
            int cnt=0;
            for(int i=0;i<n;i++){
                if(a[i]<0)
                    cnt++;
            }
            long sum=0;
            for(int i=0;i<n;i++)
                sum+=Math.abs(a[i]);
            if(cnt%2==0){
                System.out.println(sum);
            }else{
                int min=-1;
                for(int i=0;i<n;i++){
                    if(min==-1 || min>Math.abs(a[i]))
                        min=Math.abs(a[i]);
                }
                System.out.println(sum-2*min);
            }
            t--;
        }
    }
}
