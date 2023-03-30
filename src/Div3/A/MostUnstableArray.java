package Div3.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MostUnstableArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); //no of test cases
        while(t>0) {
            String []str=br.readLine().split(" ");
            int n=Integer.parseInt(str[0]);
            int m=Integer.parseInt(str[1]);
            switch (n){
                case 1:
                    System.out.println(0);
                    break;
                case 2:
                    System.out.println(m);
                    break;
                default:
                    System.out.println(2*m);
            }
            t--;
        }
    }
}
