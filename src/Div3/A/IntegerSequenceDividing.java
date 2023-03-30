package Div3.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IntegerSequenceDividing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        if(n%2==0){
            System.out.println((n/2)%2==0?0:1);
        }else{
            System.out.println((n-1)/2%2==0?1:0);
        }
    }
}
