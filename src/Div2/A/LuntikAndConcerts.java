//package Div2.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LuntikAndConcerts {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            String []abc=br.readLine().split(" ");
            int a=Integer.parseInt(abc[0]);
            int b=Integer.parseInt(abc[1]);
            int c=Integer.parseInt(abc[2]);
            int diff=0;
            if(c%2!=0){
                diff+=3;
                //to be compensated by a and b
                if(b>0){
                    b-=1;
                    diff-=2;
                } else if (a > 0) {
                    diff-=Integer.min(a,3);
                    a=Integer.max(a-3,0);
                }
            }
            if(b%2!=0){
                //to be compensated by a
                diff-=2;
                if(a>0){
                    diff+=Integer.min(a,2);
                    a=Integer.max(a-2,0);
                }
            }
            if(a%2!=0){
                if(diff<0)
                    diff+=1;
                else
                    diff-=1;
            }
            System.out.println(diff<0?-diff:diff);
            t--;
        }
    }
}
