package Div3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SocialDistance {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String[] nk = br.readLine().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);
            String s = br.readLine();
            int leftOne = -1;
            int rightOne;
            int ans = 0;
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (c == '1') {
                    rightOne = i;
                    if(leftOne==-1){
                        ans+=rightOne/(k+1);
                    }else{
                        int dist=rightOne-leftOne-k-1;
                        ans+=dist/(k+1);
                    }
                    leftOne = rightOne;
                }
            }
            if(leftOne==-1){
                int dist = n-1;
                ans+=1+dist/(k+1);
            }else{
                int dist=n-leftOne-1;
                ans+=dist/(k+1);
            }
            System.out.println(ans);
            t--;
        }
    }
}
