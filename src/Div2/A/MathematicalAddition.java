//package Div2.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MathematicalAddition {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            String []uv=br.readLine().split(" ");
            long u = Long.parseLong(uv[0]);
            long v = Long.parseLong(uv[1]);
            System.out.println(-u*u+" "+v*v);
            t--;
        }

    }
}
