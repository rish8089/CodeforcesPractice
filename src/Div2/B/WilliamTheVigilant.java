//package Div2.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WilliamTheVigilant {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String []nq=br.readLine().split(" ");
        int n=Integer.parseInt(nq[0]);
        int q=Integer.parseInt(nq[1]);
        String s=br.readLine();
        char []c=new char[n];
        for(int i=0;i<n;i++)
            c[i]=s.charAt(i);
        int cnt=0;
        for(int i=0;i<n-2;i++){
            if(c[i]=='a' && c[i+1]=='b' && c[i+2]=='c') {
                cnt += 1;
                i+=2;
            }
        }
        while (q > 0) {
            String[] posc = br.readLine().split(" ");
            int pos = Integer.parseInt(posc[0]);
            char ch = posc[1].charAt(0);
            pos--;
            //is abc already around pos
            if (c[pos] != ch) {
                boolean res1 = isABCAroundPos(c, pos);
                if (res1)
                    cnt--;
                c[pos] = ch;
                boolean res2 = isABCAroundPos(c, pos);
                if (res2)
                    cnt++;
            }
            System.out.println(cnt);
            q--;
        }
    }

    private static boolean isABCAroundPos(char[] c, int pos) {
        if (c[pos] == 'a') {
            return pos + 2 < c.length && c[pos + 1] == 'b' && c[pos + 2] == 'c';
        } else if (c[pos] == 'b') {
            return pos - 1 >= 0 && pos + 1 < c.length && c[pos - 1] == 'a' && c[pos + 1] == 'c';
        } else {
            return pos - 2 >= 0 && c[pos - 2] == 'a' && c[pos - 1] == 'b';
        }
    }
}
