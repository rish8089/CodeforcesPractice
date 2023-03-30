//package Div2.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AntiLightsCellGuessing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            String []nm=br.readLine().split(" ");
            int n=Integer.parseInt(nm[0]);
            int m=Integer.parseInt(nm[1]);
            if(n>1 && m>1)
                System.out.println(2);
            else if(n>1 || m>1)
                System.out.println(1);
            else
                System.out.println(0);
            t--;
        }
    }
}
