//package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MaximumWidth {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String []nm=br.readLine().split(" ");
        int n=Integer.parseInt(nm[0]);
        int m=Integer.parseInt(nm[1]);
        String s=br.readLine();
        String t=br.readLine();
        int post=0;
        List<Integer> possl=new ArrayList<>();
        for (int i = 0; i < s.length() && possl.size() < m; i++) {
            if (s.charAt(i) == t.charAt(post)) {
                possl.add(i);
                post++;
            }
        }
        assert(possl.size()==m);
        //stretching back and finding the max
        int ans=0;
        int endPos = n-1;
        for (int j = possl.size() - 1; j > 0; j--) {
            int pos = possl.get(j);
            char ch = s.charAt(pos);
            for (int k = endPos; k > pos; k--) {
                if (s.charAt(k) == ch) {
                    pos = k;
                    break;
                }
            }
            ans=Integer.max(ans, pos-possl.get(j-1));
            endPos=pos-1;
        }
        System.out.println(ans);
    }
}
