//package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class StringTransformation1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            String a = br.readLine();
            String b = br.readLine();
            boolean flag = true;
            Map<Character, Set<Character>> mp = new HashMap<>();
            for (int i = 0; i < n; i++) {
                char c1 = a.charAt(i);
                char c2 = b.charAt(i);
                if (c1 > c2) {
                    flag = false;
                    break;
                } else if (c1 < c2) {
                    if (mp.containsKey(c1)) {
                        mp.get(c1).add(c2);
                    } else {
                        Set<Character> set = new TreeSet<>();
                        set.add(c2);
                        mp.put(c1, set);
                    }
                }
            }
            if (!flag)
                System.out.println(-1);
            else {
                char[] next = new char[26];
                Arrays.fill(next, (char) 0);
                for (Character c : mp.keySet()) {
                    char source = c;
                    Set<Character> set = mp.get(c);
                    for (Character elem : set) {
                        char dest = elem;
                        while (next[source - 'a'] != 0) {
                            if (next[source - 'a'] == dest)
                                break;
                            else if (next[source - 'a'] < dest) {
                                source = next[source - 'a'];
                            } else {
                                char temp = next[source - 'a'];
                                next[source - 'a'] = dest;
                                source = next[source - 'a'];
                                dest = temp;
                            }
                        }
                        next[source - 'a'] = dest;
                        source = elem;
                    }
                }
                int cnt = 0;
                for (int i = 0; i < 20; i++) {
                    if (next[i] != 0)
                        cnt++;
                }
                System.out.println(cnt);
            }
            t--;
        }
    }
}
