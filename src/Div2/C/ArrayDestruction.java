package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ArrayDestruction {
    private static int LIM = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();
        int[] hash = new int[LIM + 1];
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            List<Integer> a=new ArrayList<>();
            for (int i = 0; i < 2 * n; i++)
                a.add(Integer.parseInt(str[i]));
            Collections.sort(a);
            int first = a.get(2 * n - 1);
            boolean found = false;
            for (int i = 2 * n - 2; i >= 0; i--) {
                List<Integer> distincts = new ArrayList<>();
                PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
                for (int j = 0; j < 2 * n; j++) {
                    if (hash[a.get(j)] == 0) {
                        pq.add(a.get(j));
                        distincts.add(a.get(j));
                    }
                    hash[a.get(j)]++;
                }
                first = a.get(2 * n - 1);
                int second = a.get(i);
                int x = first + second;
                List<Node> pairs = new ArrayList<>();

                //map deductions
                hash[first]--;
                hash[second]--;
                pairs.add(new Node(first, second));

                boolean flag = true;
                for (int j = 2; j <= n; j++) {
                    x = Integer.max(first, second);
                    //extract the max element
                    while (!pq.isEmpty() && hash[pq.peek()] == 0) {
                        pq.poll();
                    }
                    assert (pq.size() > 0);
                    first = pq.peek();

                    hash[first]--;

                    if (hash[x - first] > 0) {
                        second = x - first;
                        hash[second]--;
                        pairs.add(new Node(first, second));
                    } else {
                        flag = false;
                        break;
                    }

                }
                if (flag) {
                    ans.append("YES\n");
                    ans.append(pairs.get(0).first + pairs.get(0).second).append("\n");
                    for (Node pair : pairs) ans.append(pair.first).append(" ").append(pair.second).append("\n");
                    found = true;
                    break;
                }
                //cleanup
                for (Integer distinct : distincts)
                    hash[distinct] = 0;
            }
            if (!found)
                ans.append("NO\n");
            t--;
        }
        System.out.println(ans);
    }

    private static class Node {
        int first;
        int second;

        Node(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
