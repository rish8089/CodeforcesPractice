//package Div4.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeforcesChecking {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        String str="codeforces";
        while(t>0){
            String c=br.readLine();
            System.out.println(str.contains(c)?"YES":"NO");
            t--;
        }
    }
}
