package Div3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IncreaseAndCopy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            int sqrt = (int)Math.ceil(Math.sqrt(n));
            int stepsToReachNFromSqrt = (int)Math.ceil(1.0*(n-sqrt)/sqrt);
            System.out.println((sqrt-1)+stepsToReachNFromSqrt);
            t--;
        }

    }
}
