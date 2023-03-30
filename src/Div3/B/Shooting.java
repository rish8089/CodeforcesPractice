package Div3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Shooting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        Node[] a = new Node[n];
        for (int i = 0; i < n; i++) {
            a[i] = new Node();
            a[i].val = Integer.parseInt(str[i]);
            a[i].idx = i;
        }
        Arrays.sort(a, (n1,n2)-> Integer.compare(n2.val,n1.val));
        int shots = 0;
        for (int i = 0; i < n; i++) {
            shots += a[i].val * i + 1;
        }
        System.out.println(shots);
        for (int i = 0; i < n; i++)
            System.out.print((a[i].idx+1) + " ");
        System.out.println();
    }

    private static class Node {
        int val;
        int idx;
    }
}
