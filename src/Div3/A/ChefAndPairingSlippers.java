//package Div3.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChefAndPairingSlippers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            String []nlx=br.readLine().split(" ");
            int n=Integer.parseInt(nlx[0]);
            int l=Integer.parseInt(nlx[1]);
            int x=Integer.parseInt(nlx[2]);
            System.out.println(Integer.min(l,n-l)*x);
            t--;
        }

    }
}
