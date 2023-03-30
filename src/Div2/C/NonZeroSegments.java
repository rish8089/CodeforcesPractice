//package Div2.C;

import javax.swing.tree.TreeCellRenderer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class NonZeroSegments {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(str[i]);
        Map<Long, TreeSet<Integer>> prefixSum = new HashMap<>();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            if (!prefixSum.containsKey(sum)) {
                TreeSet<Integer> set = new TreeSet<>();
                set.add(i);
                prefixSum.put(sum, set);
            } else {
                TreeSet<Integer> set = prefixSum.get(sum);
                set.add(i);
            }
        }
        int endIdx = -1;
        sum = 0;
        int moves = 0;
        for (int i = 0; i < n - 1; i++) {
            if (prefixSum.containsKey(sum)) {
                TreeSet<Integer> set = prefixSum.get(sum);
                Integer pos = set.first();
                if (endIdx == -1) {
                    moves += 1;
                    endIdx = pos;
                } else {
                    if (i < endIdx) {
                        endIdx = Integer.min(endIdx, pos);
                    } else {
                        moves += 1;
                        endIdx = pos;
                    }
                }
            }
            sum += a[i];
            TreeSet<Integer> set = prefixSum.get(sum);
            set.remove(i);
            if (set.size() == 0)
                prefixSum.remove(sum);
        }
        System.out.println(moves);
    }
}
