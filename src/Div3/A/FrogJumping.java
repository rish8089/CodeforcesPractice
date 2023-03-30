package Div3.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FrogJumping {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            String []abk=br.readLine().split(" ");
            long a=Long.parseLong(abk[0]);
            long b=Long.parseLong(abk[1]);
            long k=Long.parseLong(abk[2]);
            System.out.println((k-k/2)*a-(k/2)*b);
            t--;
        }
    }
}
