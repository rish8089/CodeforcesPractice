//package Div2.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Distance {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            String []xy=br.readLine().split(" ");
            int x=Integer.parseInt(xy[0]);
            int y=Integer.parseInt(xy[1]);
            if((x+y)%2==0){
                if(x>=y)
                    System.out.format("%d %d\n", (x+y)/2, 0);
                else
                    System.out.format("%d %d\n", 0, (x+y)/2);
            }else
                System.out.format("%d %d\n", -1, -1);
            t--;
        }
    }
}
