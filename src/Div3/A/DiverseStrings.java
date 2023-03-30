package Div3.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DiverseStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            String s=br.readLine();
            char []ch=s.toCharArray();
            Arrays.sort(ch);
            boolean flag=true;
            for(int i=0;i<ch.length-1;i++){
                if(ch[i+1]-ch[i]!=1){
                    flag=false;
                    break;
                }
            }
            System.out.println(flag?"Yes":"No");
            t--;
        }
    }
}
