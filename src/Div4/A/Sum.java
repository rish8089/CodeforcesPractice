//package Div4.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            String []abc=br.readLine().split(" ");
            int a=Integer.parseInt(abc[0]);
            int b=Integer.parseInt(abc[1]);
            int c=Integer.parseInt(abc[2]);
            if(a==b+c || b==a+c || c==a+b)
                System.out.println("YES");
            else
                System.out.println("NO");
            t--;
        }
    }
}
