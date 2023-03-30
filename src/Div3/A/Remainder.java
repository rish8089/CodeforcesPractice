package Div3.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Remainder {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String []nxy=br.readLine().split(" ");
        int n=Integer.parseInt(nxy[0]);
        int x=Integer.parseInt(nxy[1]);
        int y=Integer.parseInt(nxy[2]);
        String s=br.readLine();
        String substr=s.substring(n-x);
        int cnt=0;
        for(int i=0;i<substr.length();i++){
            char c=substr.charAt(i);
            char targetc='0';
            if(i==substr.length()-y-1){
                targetc='1';
            }
            if(c!=targetc)
                cnt+=1;
        }
        System.out.println(cnt);
    }
}
