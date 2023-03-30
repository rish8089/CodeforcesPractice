package Div3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BoardMoves {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            BigInteger bg=new BigInteger("0");
            for(int i=1;i<=n/2;i+=1) {
                long boundaryLength = 2*i+1;
                long squares = 2*(boundaryLength) + 2*(boundaryLength-2);
                bg = bg.add(new BigInteger(String.valueOf(i*squares)));
            }
            System.out.println(bg);
            t--;
        }
    }
}
