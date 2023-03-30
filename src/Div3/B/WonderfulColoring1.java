package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WonderfulColoring1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); //no of test cases
        while(t>0){
            String str=br.readLine();
            int []hash=new int[26];
            for(int i=0;i<str.length();i++){
                char c=str.charAt(i);
                hash[c-'a']++;
            }
            int cntMoreThanOne =0;
            int cntOne=0;
            for(int i=0;i<26;i++){
                if(hash[i]>1){
                    cntMoreThanOne+=1;
                }else if(hash[i]==1){
                    cntOne+=1;
                }
            }
            System.out.println(cntMoreThanOne+(cntOne/2));
            t--;
        }
    }
}
