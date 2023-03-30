//package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DominantCharacter {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            int a = 0, b = 0, c = 0;
            int cnt = 0;
            int ans = -1;
//            for (int i = 0; i < n; i++) {
//                char ch = str.charAt(i);
//                if (ch == 'a')
//                    a = a + 1;
//                if (ch == 'b')
//                    b = b + 1;
//                if (ch == 'c')
//                    c = c + 1;
//                //as two a's are anyways required to fill up
//                if (b > a || c > a) {
//                    cnt = 0;
//                    a = 0;
//                    b = 0;
//                    c = 0;
//                } else {
//                    cnt += 1;
//                    if (a > b && a > c && cnt >= 2) {
//                        if (ans == -1 || ans > cnt)
//                            ans = cnt;
//                        cnt = 1;
//                        a = 1;
//                        b = 0;
//                        c = 0;
//                    }
//                }
//
//            }
            if(str.contains("aa")){
                System.out.println(2);
            } else if(str.contains("aba") || str.contains("aca"))
                System.out.println(3);
            else if(str.contains("abca") || str.contains("acba"))
                System.out.println(4);
            else
                System.out.println(-1);
            t--;
        }
    }

    private static class Node {
        int a;
        int b;
        int c;
    }
}
