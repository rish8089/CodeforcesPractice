package Div3.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShortSubstrings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t =Integer.parseInt(br.readLine());
        while(t>0) {
            String str = br.readLine();
            StringBuilder res =new StringBuilder();
            res.append(str, 0, 2);
            for (int i = 3; i < str.length(); i += 2) {
                res.append(str.charAt(i));
            }
            System.out.println(res);
            t--;
        }
    }
}
