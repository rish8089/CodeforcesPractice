package Div3.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FloorNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            String []nx=br.readLine().split(" ");
            int n=Integer.parseInt(nx[0]);
            int x=Integer.parseInt(nx[1]);
            if(n<=2)
                System.out.println(1);
            else{
                System.out.println((n-2)%x==0?(n-2)/x+1:(n-2)/x+2);
            }
            t--;
        }
    }
}
