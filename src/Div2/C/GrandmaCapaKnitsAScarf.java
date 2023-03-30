package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GrandmaCapaKnitsAScarf {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String s=br.readLine();
            StringBuilder sb=new StringBuilder(s);
            int ans = -1;
            for (char i = 'a'; i <= 'z'; i++) {
                int j = 0;
                int k = sb.length() - 1;
                int mv = 0;
                while (j < k) {
                    char u = sb.charAt(j);
                    char v = sb.charAt(k);
                    if (u != v) {
                        if (u == i) {
                            mv += 1;
                            j += 1;
                        } else if (v == i) {
                            mv += 1;
                            k -= 1;
                        } else {
                            break;
                        }
                    }else {
                        j++;
                        k--;
                    }
                }
                if(j>=k){
                    //string can be made palindrome
                    if(ans==-1 || ans>mv)
                        ans=mv;
                }
            }
            System.out.println(ans);
            t--;
        }
    }
}
