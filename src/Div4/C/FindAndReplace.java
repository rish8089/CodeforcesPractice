//package Div4.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindAndReplace {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String str=br.readLine();
            int []hash1=new int[26];
            for(int i=0;i<n;i+=2){
                hash1[str.charAt(i)-'a']++;
            }
            boolean flag=true;
            for(int i=1;i<n;i+=2){
                if(hash1[str.charAt(i)-'a']>0){
                    flag=false;
                    break;
                }
            }
            System.out.println(flag?"YES":"NO");
            t--;
        }
    }
}
