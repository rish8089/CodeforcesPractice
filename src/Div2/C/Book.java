//package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Book {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                List<Integer> l = new ArrayList<>();
                graph.add(l);
                String[] str = br.readLine().split(" ");
                int k = Integer.parseInt(str[0]);
                for (int j = 0; j < k; j++)
                    l.add(Integer.parseInt(str[j + 1]) - 1);
            }
            boolean[] visited = new boolean[n];
            int[] minReads = new int[n];
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    int res = getMinReads(i, visited, minReads, graph);
                    if (res == 0) {
                        flag = false;
                        break;
                    }
                    minReads[i] = res;
                }
            }
            if (!flag)
                System.out.println(-1);
            else {
                int ans = 0;
                for (int i = 0; i < n; i++) {
                    ans = Integer.max(ans, minReads[i]);
                }
                System.out.println(ans);
            }
            t--;
        }
    }

    private static int getMinReads(int v, boolean[] visited, int[] minReads, List<List<Integer>> graph) {
        List<Integer> l = graph.get(v);
        if (l.size() == 0)
            return 1;
        int maxReads = 0;
        int maxChild = 0;
        for (int c : l) {
            //detecting cycle, if visited but if the result didn't arrive then cycle
            if (visited[c]) {
                if (minReads[c] == 0)
                    return 0;
            } else {
                visited[c] = true;
                int res = getMinReads(c, visited, minReads, graph);
                if (res == 0)
                    return 0;
                minReads[c] = res;
            }
            if (maxReads <= minReads[c]) {
                if (maxReads == minReads[c]) {
                    if (maxChild < c)
                        maxChild = c;
                } else {
                    maxChild = c;
                    maxReads = minReads[c];
                }
            }
        }
        if (v > maxChild)
            return maxReads;
        else
            return maxReads + 1;
    }
}
