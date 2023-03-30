//package Div2.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PolycarpAndSumsOfSubsequences {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            String []str=br.readLine().split(" ");
            int []b=new int[7];
            for(int i=0;i<7;i++)
                b[i]=Integer.parseInt(str[i]);
            int a1=b[6]-b[5];
            int a2=b[6]-b[4];
            System.out.format("%d %d %d\n", a1, a2, b[6]-a1-a2);
            t--;
        }
    }
}
