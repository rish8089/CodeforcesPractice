package Div3.C;//package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoodString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int del = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            ans.append(s.charAt(i));
            if ((i + 1 - del) % 2 != 0) {
                //odd position
                int j = i;
                while (i + 1 < n && s.charAt(i) == s.charAt(i + 1))
                    i++;
                del += i - j;
            }
        }
        if(ans.length()%2==0) {
            System.out.println(del);
            System.out.println(ans);
        }else{
            System.out.println(del+1);
            System.out.println(ans.substring(0,ans.length()-1));
        }
    }
}
