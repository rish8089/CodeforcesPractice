package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlphabeticalStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            String s=br.readLine();
            int sidx=-1, eidx=-1;
            for(int i=0;i<s.length();i++){
                char c= s.charAt(i);
                if(c=='a'){
                    sidx=i;
                    eidx=i;
                    break;
                }
            }
            if(sidx==-1){
                System.out.println("NO");
            } else {
                for (int i = 1; i < s.length(); i++) {
                    char c = (char) ('a' + i);
                    if (sidx - 1 >= 0 && s.charAt(sidx - 1) == c) {
                        sidx -= 1;
                    } else if (eidx + 1 < s.length() && s.charAt(eidx + 1) == c) {
                        eidx += 1;
                    } else {
                        break;
                    }
                }
                if (sidx == 0 && eidx == s.length() - 1) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
            t--;
        }
    }
}
