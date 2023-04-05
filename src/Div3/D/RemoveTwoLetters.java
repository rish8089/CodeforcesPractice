//package Div3.D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemoveTwoLetters {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String s=br.readLine();
            int diff=0;
            for(int i=0;i<n-2;i++){
                if(s.charAt(i)!=s.charAt(i+2))
                    diff++;
            }
            System.out.println(diff+1);
            t--;
        }
    }
}
