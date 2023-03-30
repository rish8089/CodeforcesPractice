package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class TwoArraysAndSwaps {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            String []nk = br.readLine().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);
            String []str=br.readLine().split(" ");
            Integer []a=new Integer[n];
            for(int i=0;i<n;i++)
                a[i] = Integer.parseInt(str[i]);
            str = br.readLine().split(" ");
            Integer []b=new Integer[n];
            for(int i=0;i<n;i++)
                b[i]=Integer.parseInt(str[i]);
            Arrays.sort(a);
            Arrays.sort(b, Collections.reverseOrder());
            int res=0;
            for(int i=0;i<n;i++)
                res=res+a[i];
            int i=0,j=0;
            while(i<n && j<n && k>0) {
                if(a[i]<b[j]){
                    res = res-a[i]+b[j];
                    i++;
                    j++;
                } else{
                    break;
                }
                k--;
            }
            System.out.println(res);
            t--;
        }
    }
}
