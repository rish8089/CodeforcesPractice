//package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KeshiIsThrowingAParty {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            List<Node> a = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String[] str = br.readLine().split(" ");
                a.add(new Node(Integer.parseInt(str[0]), Integer.parseInt(str[1])));
            }
            for (int i = 0; i < n; i++) {
                Node node = a.get(i);
                node.x = Integer.min(node.x, n - 1 - i);
                node.y = Integer.min(node.y, i);
            }
            Collections.sort(a, (n1, n2) -> {
                if (n1.x > n2.x)
                    return 0;
                else if (n1.x == n2.x)
                    return Integer.compare(n1.y, n2.y);
                else
                    return 1;
            });
            int max = a.get(0).x + 1;
            int found = 0;
            for (int i = 0; i < n && found < max; ) {
                Node node = a.get(i);
                //want person who can bear max-found richers and poorers equal to found
                if (node.x >= max - found - 1) {
                    Node tnode = node;
                    while (tnode.x >= max - found - 1 && tnode.y < found) {
                        if (i + 1 < n) {
                            tnode = a.get(i + 1);
                            i++;
                        } else
                            break;
                    }
                    //able to meet??
                    if (tnode.x >= max - found - 1 && tnode.y >= found) {
                        found += 1;
                        i++;
                    } else
                        max -= 1;
                } else {
                    max -= 1;
                }
            }
            System.out.println(max);
            t--;
        }
    }

    private static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
