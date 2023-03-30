package Div3.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class YetAnotherTwoIntegersProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); //no of test cases
        while(t>0){
            String []ab=br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            int diff = Math.abs(a-b);
            System.out.println(diff/10+((diff%10!=0)?1:0));
            t--;
        }
    }
}
