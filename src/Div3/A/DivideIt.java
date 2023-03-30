package Div3.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DivideIt {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            long n=Long.parseLong(br.readLine());
            int two, three, five;
            two=three=five=0;
            while(n%2==0) {
                two+=1;
                n/=2;
            }
            while(n%3==0) {
                three+=1;
                n/=3;
            }
            while(n%5==0) {
                five+=1;
                n/=5;
            }
            if(n>1)
                System.out.println(-1);
            else {
                System.out.println(2 * three + 3 * five + two);
            }
            t--;
        }
    }
}
