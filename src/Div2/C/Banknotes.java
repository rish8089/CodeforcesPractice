package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Banknotes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            String []nk=br.readLine().split(" ");
            int n=Integer.parseInt(nk[0]);
            int k=Integer.parseInt(nk[1]);
            String []str=br.readLine().split(" ");
            int []a=new int[n];
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(str[i]);
            long s=0;
            int bk = k+1;//bank notes to represent
            for(int i=0;i<n && bk>0;i++){
                long dmv = (long)Math.pow(10,a[i]);
                //if there is higher denomination available
                if(i+1<n){
                    //max bank notes of a[i] denomination
                    int mbn = (int)Math.pow(10,a[i+1]-a[i])-1;
                    //denomination value
                    s += Integer.min(bk, mbn) * dmv;
                    bk -= Integer.min(bk, mbn);
                }else{
                    s += bk * dmv;
                    bk = 0;
                }
            }
            System.out.println(s);
            t--;
        }
    }
}
