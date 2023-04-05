//package Div3.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IsItACat {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String s=br.readLine();
            String sol="meow";
            int i=0;
            int idx=0;
            boolean flag=true;
            for(;i<s.length() && idx<sol.length();idx++,i++){
                if(isEqual(s.charAt(i),sol.charAt(idx))) {
                    while(i+1<s.length() && isEqual(s.charAt(i+1), sol.charAt(idx)))
                        i++;
                }else {
                    flag = false;
                    break;
                }
            }
            System.out.println(flag && i==s.length() && idx==sol.length()?"YES":"NO");
            t--;
        }
    }
    private static boolean isEqual(char c1, char c2){
        return c1==c2 || c1+32==c2;
    }
}
