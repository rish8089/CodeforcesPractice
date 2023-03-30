//package Div3.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LinearKeyboard {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            String seq=br.readLine();
            int [][]dist=new int[26][26];
            for(int i=0;i<seq.length();i++){
                for(int j=i;j<seq.length();j++){
                    dist[seq.charAt(i)-'a'][seq.charAt(j)-'a']=j-i;
                    dist[seq.charAt(j)-'a'][seq.charAt(i)-'a']=j-i;
                }
            }
            String s=br.readLine();
            int time=0;
            for(int i=0;i<s.length()-1;i++){
                time+=dist[s.charAt(i+1)-'a'][s.charAt(i)-'a'];
            }
            System.out.println(time);
            t--;
        }
    }
}
