//package Div3.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StrangeTable {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            String []nmx=br.readLine().split(" ");
            long n=Long.parseLong(nmx[0]);
            long m=Long.parseLong(nmx[1]);
            long x=Long.parseLong(nmx[2]);

            long col=x/n+(x%n==0?0:1);
            long row=(x%n==0)?n:x%n;
            System.out.println((row-1)*m+col);
            t--;
        }
    }
}
