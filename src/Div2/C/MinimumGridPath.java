//package Div2.C;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MinimumGridPath {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = Integer.parseInt(str[i]);
            //moving in up
            long minCost = Long.MAX_VALUE;
            long upSum = 0;
            long rightSum = 0;
            long minUpCost = Long.MAX_VALUE;
            long minRightCost = Long.MAX_VALUE;
            for (int i = 0; i < n - 1; i++) {
                //can i and i+1 be the finishing point
                long totalUpCost, totalRightCost;
                if (i % 2 == 0) {
                    minUpCost = Long.min(minUpCost, a[i]);
                    minRightCost = Long.min(minRightCost, a[i + 1]);
                    totalUpCost = (upSum + a[i] - minUpCost) + (n - i / 2) * minUpCost;
                    totalRightCost = (rightSum + a[i + 1] - minRightCost) + (long) (n - (i + 1) / 2) * minRightCost;
                    upSum += a[i];
                } else {
                    minRightCost = Long.min(minRightCost, a[i]);
                    minUpCost = Long.min(minUpCost, a[i + 1]);
                    totalRightCost = (rightSum + a[i] - minRightCost) + (n - i / 2) * minRightCost;
                    totalUpCost = (upSum + a[i + 1] - minUpCost) + (long) (n - (i + 1) / 2) * minUpCost;
                    rightSum += a[i];
                }
                minCost = Long.min(minCost, totalUpCost + totalRightCost);
            }
            System.out.println(minCost);
            t--;
        }
    }
}
