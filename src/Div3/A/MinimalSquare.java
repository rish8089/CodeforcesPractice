package Div3.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimalSquare {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            String []ab=br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            int max = Math.max(a,b);
            int min = Math.min(a,b);
            System.out.println(2*min<max?(int)Math.pow(max,2):(int)Math.pow(2*min,2));
            t--;
        }
    }
}
