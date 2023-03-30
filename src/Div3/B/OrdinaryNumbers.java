package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrdinaryNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            int d = getNoOfDigits(n);
            int firstDigit = (int)(n/Math.pow(10,d-1));
            System.out.println((d-1)*9+(isNumberHigherThanEqualToOrdinaryNumber(n, firstDigit)?firstDigit:firstDigit-1));
            t--;
        }
    }
    private static int getNoOfDigits(int n) {
        int d = 0;
        while (n > 0) {
            d = d + 1;
            n /= 10;
        }
        return d;
    }
    //ordinary number is a number with all digits repeated with first digit
    private static boolean isNumberHigherThanEqualToOrdinaryNumber(int n, int firstDigit){
        int d = getNoOfDigits(n);
        int []digits = new int[d];
        int i=0;
        while(n>0){
            digits[d-1-i] = n%10;
            n/=10;
            i++;
        }
        for(i=0;i<d;i++){
            if(digits[i]>firstDigit)return true;
            if(digits[i]<firstDigit)return false;
        }
        return true;
    }
}
