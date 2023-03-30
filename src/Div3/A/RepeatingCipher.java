package Div3.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RepeatingCipher {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String s=br.readLine();
        StringBuilder ans=new StringBuilder();
        int cnt=0;
        for(int i=0;i<s.length();i+=cnt){
            ans.append(s.charAt(i));
            cnt++;
        }
        System.out.println(ans);
    }
}
