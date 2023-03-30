//package Div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class EngineerArtem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String[] nm = br.readLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);
            int[][] a = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] str = br.readLine().split(" ");
                for (int j = 0; j < m; j++)
                    a[i][j] = Integer.parseInt(str[j]);
            }
            Queue<Node> q = new LinkedList<>();
            q.add(new Node(0, 0));
            while (!q.isEmpty()) {
                Node nd = q.poll();
                if (nd.x + 1 < n) {
                    if (a[nd.x][nd.y] == a[nd.x + 1][nd.y]) {
                        a[nd.x + 1][nd.y] += 1;
                    }
                    q.add(new Node(nd.x + 1, nd.y));
                }
                if (nd.y + 1 < m) {
                    if (a[nd.x][nd.y] == a[nd.x][nd.y + 1]) {
                        a[nd.x][nd.y + 1] += 1;
                    }
                    q.add(new Node(nd.x, nd.y + 1));
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++)
                    System.out.print(a[i][j] + " ");
                System.out.println();
            }
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

    private static int abs(int x) {
        return x < 0 ? -x : x;
    }
}
