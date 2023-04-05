//package AprilFoolsDay.Contest2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WasItRated {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        if(n==1 || n==5 || n==4 || n==21 || n==19 || n==24 || n==20 || n==9)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
