//package Div4.G;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TeleportersEasy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            String []nc=br.readLine().split(" ");
            int n=Integer.parseInt(nc[0]);
            int c=Integer.parseInt(nc[1]);
            Integer []a=new Integer[n];
            String []str=br.readLine().split(" ");
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(str[i]);
            for(int i=0;i<n;i++)
                a[i]=a[i]+i+1;
            Arrays.sort(a);
            int ans=0;
            for(int i=0;i<n;i++) {
                if(c-a[i]<0)
                    break;
                else{
                    c-=a[i];
                    ans+=1;
                }
            }
            System.out.println(ans);
            t--;
        }
    }
}
