package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CandiesDivision {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); //no of test cases
        while(t>0){
            String []nk=br.readLine().split(" ");
            int n=Integer.parseInt(nk[0]);
            int k=Integer.parseInt(nk[1]);
            System.out.println((n / k) * k + Math.min(n % k, k / 2));
            t--;
        }
    }
}
