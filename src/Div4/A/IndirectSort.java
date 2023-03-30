//package Div4.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IndirectSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String []str=br.readLine().split(" ");
            int []a=new int[n];
            for(int i=0;i<n;i++){
                a[i]=Integer.parseInt(str[i]);
            }
            int min=Integer.MAX_VALUE;
            for(int i=0;i<n;i++) {
                if(min>a[i])
                    min=a[i];
            }
            System.out.println(min==a[0]?"Yes":"No");
            t--;
        }
    }
}
