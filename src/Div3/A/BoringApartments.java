package Div3.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BoringApartments {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            int x = Integer.parseInt(br.readLine());
            int ld = x%10;
            int d = getNoOfDigits(x);
            System.out.println((ld-1)*10+d*(d+1)/2);
            t--;
        }
    }
    private static int getNoOfDigits(int x){
        int d=0;
        while(x>0){
            d=d+1;
            x/=10;
        }
        return d;
    }
}
