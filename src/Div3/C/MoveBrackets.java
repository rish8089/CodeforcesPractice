//package Div3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MoveBrackets {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String s=br.readLine();
            StringBuilder sb=new StringBuilder(s);
            int open=0,close=0;
            int mv=0;
            for(int i=0;i<s.length();i++){
                char c=sb.charAt(i);
                if(c=='(')
                    open+=1;
                else
                    close+=1;
                if(close>open){
                    sb.append(')');
                    close--;
                    mv+=1;
                }
            }
            System.out.println(mv);
            t--;
        }
    }
}
