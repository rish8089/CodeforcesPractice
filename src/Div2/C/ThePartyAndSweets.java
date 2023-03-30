package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThePartyAndSweets {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        List<Integer> b = new ArrayList<>();
        List<Integer> g = new ArrayList<>();
        String[] sb = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            b.add(Integer.parseInt(sb[i]));
        String[] sg = br.readLine().split(" ");
        for (int i = 0; i < m; i++)
            g.add(Integer.parseInt(sg[i]));
        b.sort(Collections.reverseOrder());
        g.sort(Collections.reverseOrder());
        long ans = 0;
        int gidx = 0;
        for (int i = 0; i < n; i++) {
            int j = gidx;
            while (j < m && g.get(j) >= b.get(i)) {
                if (j == gidx + m - 1) {
                    if (!g.get(j).equals(b.get(i))) {
                        break;
                    }
                }
                ans = ans + g.get(j);
                j++;
            }
            //if it breaks out of the loop due to girl receiving lesser gift, then not possible
            if (j < m && g.get(j) < b.get(i))
                break;
            ans = ans + (long)(m - j + gidx) * b.get(i);
            gidx = j;
        }
        System.out.println(gidx < m ? -1 : ans);
    }
}
