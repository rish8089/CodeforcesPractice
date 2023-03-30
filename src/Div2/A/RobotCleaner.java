//package Div2.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RobotCleaner {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String[] nmrscsrdcd = br.readLine().split(" ");
            int n = Integer.parseInt(nmrscsrdcd[0]);
            int m = Integer.parseInt(nmrscsrdcd[1]);
            int rs = Integer.parseInt(nmrscsrdcd[2]);
            int cs = Integer.parseInt(nmrscsrdcd[3]);
            int rd = Integer.parseInt(nmrscsrdcd[4]);
            int cd = Integer.parseInt(nmrscsrdcd[5]);
            int ans = 0;
            int dr = 1, cr = 1;
            if (rs == n)
                dr = -1;
            if (cs == m)
                cr = -1;
            while (rs != rd && cs != cd) {
                rs = rs + dr;
                cs = cs + cr;
                ans++;
                //hitting the vertical top or bottom
                if(rs==n || rs==1){
                    dr *= -1;
                }
                if(cs ==m || cs == 1){
                    cr *= -1;
                }
            }
            System.out.println(ans);
            t--;
        }
    }
}
