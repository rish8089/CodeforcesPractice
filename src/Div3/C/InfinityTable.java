package Div3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InfinityTable {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            int r=(int)Math.sqrt(n);
            if(r*r==n){
                System.out.format("%d %d\n", r, 1);
            }else{
                int rem=n-r*r;
                if(rem<=r+1){
                    System.out.format("%d %d\n", rem, r+1);
                }else{
                    System.out.format("%d %d\n", r+1, 2*(r+1)-rem);
                }
            }
            t--;
        }
    }
}
