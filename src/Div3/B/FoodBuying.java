package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FoodBuying {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); //no of test cases
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            int res = 0;
            while (n >= 10) {
                res += (n / 10) * 10;
                n = n % 10 + (n / 10);
            }
            res=res+n;
            System.out.println(res);
            t--;
        }
    }
}
