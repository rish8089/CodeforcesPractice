package Div3.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CasimirsStringSolitaire {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            String str=br.readLine();
            int A=0,B=0,C=0;
            for(int i=0;i<str.length();i++){
                char c=str.charAt(i);
                if(c=='A')
                    A=A+1;
                else if(c=='B')
                    B=B+1;
                else
                    C=C+1;
            }

            System.out.println(A+C==B?"YES":"NO");
            t--;
        }
    }
}
