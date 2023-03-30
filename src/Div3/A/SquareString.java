//package Div3.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SquareString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            String s=br.readLine();
            int n=s.length();
            if(n%2==0){
                int len=n/2;
                boolean flag=true;
                for(int i=0;i<len;i++){
                    if(s.charAt(i)!=s.charAt(len+i)){
                        flag=false;
                        break;
                    }
                }
                System.out.println(flag?"YES":"NO");
            }else{
                System.out.println("NO");
            }
            t--;
        }
    }
}
