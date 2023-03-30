//package Div2.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoSubsequences {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            String s=br.readLine();
            int minIdx=-1;
            for(int i=0;i<s.length();i++){
                char c=s.charAt(i);
                if(minIdx==-1){
                    minIdx=i;
                }else{
                    if(s.charAt(minIdx)>c)
                        minIdx=i;
                }
            }
            System.out.println(s.charAt(minIdx)+ " "+ (s.substring(0,minIdx)+s.substring(minIdx+1)));
            t--;
        }
    }
}
