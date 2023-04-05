//package Div4.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlusOrMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            String []str=br.readLine().split(" ");
            int a=Integer.parseInt(str[0]);
            int b=Integer.parseInt(str[1]);
            int c=Integer.parseInt(str[2]);
            System.out.println(a+b==c?'+':'-');
            t--;
        }
    }
}
