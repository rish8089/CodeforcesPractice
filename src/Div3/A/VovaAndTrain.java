package Div3.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VovaAndTrain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0) {
            String[] Lvlr = br.readLine().split(" ");
            int L = Integer.parseInt(Lvlr[0]);
            int v = Integer.parseInt(Lvlr[1]);
            int l = Integer.parseInt(Lvlr[2]);
            int r = Integer.parseInt(Lvlr[3]);
            int tp = L / v;//total points
            int tpc = r/v-(l-1)/v;
            System.out.println(tp - tpc);
            t--;
        }
    }
}
