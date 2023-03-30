//package Div2.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongComparison {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            String []x1p1=br.readLine().split(" ");
            int x1=Integer.parseInt(x1p1[0]);
            int p1=Integer.parseInt(x1p1[1]);
            String []x2p2=br.readLine().split(" ");
            int x2=Integer.parseInt(x2p2[0]);
            int p2=Integer.parseInt(x2p2[1]);
            int d1=getNoOfDigits(x1);
            int d2=getNoOfDigits(x2);
            if(d1+p1<d2+p2)
                System.out.println("<");
            else if(d1+p1>d2+p2)
                System.out.println(">");
            else{
                if(d1<d2)
                    x1=(int)Math.pow(10,d2-d1)*x1;
                else
                    x2=(int)Math.pow(10,d1-d2)*x2;
                if(x1<x2)
                    System.out.println("<");
                else if(x1>x2)
                    System.out.println(">");
                else
                    System.out.println("=");
            }

            t--;
        }
    }
    private static int getNoOfDigits(int num){
        int d=0;
        while(num>0){
            d=d+1;
            num/=10;
        }
        return d;
    }
}
