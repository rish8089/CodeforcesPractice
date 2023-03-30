package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WhosOpposite {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); //no of test cases
        while (t > 0) {
            String[] abc = br.readLine().split(" ");
            int a = Integer.parseInt(abc[0]);
            int b = Integer.parseInt(abc[1]);
            int c = Integer.parseInt(abc[2]);
            int minab = Math.min(a, b);
            int maxab = Math.max(a, b);
            int d = maxab - minab;
            if(minab-1>=d || maxab-1<=0 || c>2*d){
                System.out.println(-1);
            }else {
                if(c>=d+1){
                    System.out.println(c-d);
                }else{
                    System.out.println(c+d);
                }
            }

            t--;
        }
    }
}