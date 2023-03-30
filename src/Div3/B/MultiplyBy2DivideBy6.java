package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultiplyBy2DivideBy6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); //no of test cases
        while(t>0){
            int n = Integer.parseInt(br.readLine());
            int cnt2=0;
            int cnt3=0;
            while(n%2==0){
                cnt2+=1;
                n=n/2;
            }
            while(n%3==0){
                cnt3+=1;
                n=n/3;
            }
            if(n>1){
               System.out.println(-1);
            }else{
                if(cnt2==cnt3 || cnt2<cnt3){
                    System.out.println(2*cnt3-cnt2);//cnt3 times divide by 6 and cnt3-cnt2 times multiply by 2
                }else{
                    System.out.println(-1);
                }
            }
            t--;
        }
    }
}
